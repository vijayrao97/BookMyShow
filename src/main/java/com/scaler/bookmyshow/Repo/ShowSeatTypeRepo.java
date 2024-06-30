package com.scaler.bookmyshow.Repo;

import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepo extends JpaRepository<ShowSeatType,Long>{
    List<ShowSeatType> findAllByShow(Show s);
}