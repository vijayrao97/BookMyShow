package Service;


import Repo.ShowRepository;
import Repo.ShowSeatRepository;
import Repo.UserRepository;
import models.Booking;
import models.Show;
import models.ShowSeat;
import models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private ShowRepository showRepo;
    private UserRepository userRepo;
    private ShowSeatRepository showSeatRepo;

    public BookingService(ShowRepository showRepository,
                          UserRepository userRepository,
                          ShowSeatRepository showSeatRepo){
        this.showRepo = showRepository;
        this.userRepo = userRepository;
        this.showSeatRepo = showSeatRepo;
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
        // Below code added by Vijay
        Show show = showOptional.get();

        // TODO: complete step 3, 5, 6,7(Except save), 9
        Optional<ShowSeat> showSeatOptional = this.showSeatRepo.findById(userId);
        if( showSeatOptional.isEmpty() ){
            throw new RuntimeException("showSeat is not present.");
        }
        ShowSeat ss = showSeatOptional.get();
        return null;
    }

}
