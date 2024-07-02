package com.scaler.bookmyshow.Repo;

import com.scaler.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat,Long> {
    Seat save(Seat s1);
}
