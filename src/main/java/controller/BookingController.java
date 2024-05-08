package controller;

import Service.BookingService;
import dto.BookingRequestDto;
import dto.BookingResponseDto;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bs){
        this.bookingService = bs;
    }

    public BookingResponseDto CreateBooking(BookingRequestDto bookingRequestDto){
        return null;
    }

}
