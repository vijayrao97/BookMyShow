package models;

import java.util.List;

public class Booking extends BaseClass{
    private User user;
    private Show show;
    private List<ShowSeat> showSeats;
    int amount;
    private List<Payment> payments;
    private BookingStatus bookingStatus;
}
