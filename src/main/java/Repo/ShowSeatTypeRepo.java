package Repo;

import models.Show;
import models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatTypeRepo extends JpaRepository<ShowSeatType,Long>{
    List<ShowSeatType> findAllByShow(Show s);
}