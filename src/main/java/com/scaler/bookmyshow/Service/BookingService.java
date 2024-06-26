package com.scaler.bookmyshow.Service;


import com.scaler.bookmyshow.Repo.BookingRepo;
import com.scaler.bookmyshow.Repo.ShowRepository;
import com.scaler.bookmyshow.Repo.ShowSeatRepository;
import com.scaler.bookmyshow.Repo.UserRepository;
import com.scaler.bookmyshow.models.*;
//import models.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private ShowRepository showRepo;
    private UserRepository userRepo;
    private ShowSeatRepository showSeatRepo;
    private BookingRepo bookingRepo;
    private PriceCalculator priceCalculator;

    public BookingService(ShowRepository showRepository,
                          UserRepository userRepository,
                          ShowSeatRepository showSeatRepo,
                          BookingRepo bookingRepo,
                          PriceCalculator priceCalculator){
        this.showRepo = showRepository;
        this.userRepo = userRepository;
        this.showSeatRepo = showSeatRepo;
        this.bookingRepo = bookingRepo;
        this.priceCalculator = priceCalculator;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking CreateBooking(Long userId, List<Long> showSeat, Long showId){
        /*
        1. check user if user exists...
        2. check if show exist...
        3. get all showSeat Ids objects and see if they exist...
        4. ----TAKE LOCK---
        5. check if seat available or not...
        6. if not throw error...
        7. if yes, Mark the status of all seats to blocked and save to db...
        8. --- RELEASE LOCK ---
        9. create a booking object with pending status...
        10. returning booking object...
        */
        Optional<User> userOptional = this.userRepo.findById(userId);
        if( userOptional.isEmpty() ){
            throw new RuntimeException("User is not present.");
        }
        User u = userOptional.get();

        Optional<Show> showOptional = this.showRepo.findById(userId);
        if( showOptional.isEmpty() ){
            throw new RuntimeException("Show not available");
        }
        Show show = showOptional.get();

        List<ShowSeat> showSeats = this.showSeatRepo.findAllById(showSeat);
        for(ShowSeat s : showSeats){
            if( !s.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE) ){
                throw new RuntimeException("Show seat id"+s.getId()+" is not available..");
            }
        }

        for(ShowSeat s : showSeats){
            s.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepo.save(s);
        }

        Booking b = new Booking();
        b.setBookingStatus(BookingStatus.PENDING);
        b.setCreatedAt(new Date());
        b.setUser(u);
        b.setShow(show);
        b.setPayments(new ArrayList<>());
        b.setShowSeats(showSeats);
        b.setAmount(priceCalculator.calculate(show,showSeats));
        b = bookingRepo.save(b);
        return b;
    }

}
