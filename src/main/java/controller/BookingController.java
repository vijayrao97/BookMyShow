package controller;

import Service.BookingService;
import dto.BookingRequestDto;
import dto.BookingResponseDto;
import dto.ResponseStatus;
import models.Booking;
import models.BookingStatus;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bs){
        this.bookingService = bs;
    }

    public BookingResponseDto CreateBooking(BookingRequestDto bookingRequestDto){
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        Booking b = bookingService.CreateBooking(bookingRequestDto.getUserId(),
                                                bookingRequestDto.getShowSeatsIds(),
                                                bookingRequestDto.getShowId());
        bookingResponseDto.setBookingId(b.getId());
        bookingResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return bookingResponseDto;
    }

}
