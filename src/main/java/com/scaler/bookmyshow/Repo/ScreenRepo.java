package com.scaler.bookmyshow.Repo;

import com.scaler.bookmyshow.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepo extends JpaRepository<Screen, Long> {
    Screen save(Screen s);
}
