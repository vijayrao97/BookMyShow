package com.scaler.bookmyshow.controller;

import com.scaler.bookmyshow.Service.BookingService;
import com.scaler.bookmyshow.dto.BookingRequestDto;
import com.scaler.bookmyshow.dto.BookingResponseDto;
import com.scaler.bookmyshow.dto.ResponseStatus;
import com.scaler.bookmyshow.models.Booking;
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
