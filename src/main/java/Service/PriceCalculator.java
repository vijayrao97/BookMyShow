package Service;

import Repo.ShowSeatTypeRepo;
import models.Show;
import models.ShowSeat;
import models.ShowSeatType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculator {
    private ShowSeatTypeRepo showSeatTypeRepo;

    public PriceCalculator(ShowSeatTypeRepo showSeatTypeRepo){
        this.showSeatTypeRepo = showSeatTypeRepo;
    }

    public int calculate(Show show, List<ShowSeat> showSeats){
        int amount = 0;
        List<ShowSeatType> showSeatTypes = showSeatTypeRepo.findAllByShow(show);
        for(ShowSeat s : showSeats){
            for( ShowSeatType showSeatType : showSeatTypes ){
                if( s.getSeat().getSeatType().equals(showSeatType.getSeatType()) ){
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
