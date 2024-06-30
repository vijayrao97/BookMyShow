package com.scaler.bookmyshow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseClass{
    @Column(name = "`row`") // Using backticks for the reserved keyword
    private int Row;
    private int Col;
    private String number;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
}
