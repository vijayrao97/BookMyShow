package models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseClass{
    private int row;
    private int col;
    private String number;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
