package com.scaler.bookmyshow;

import com.scaler.bookmyshow.Repo.*;
import com.scaler.bookmyshow.Service.UserService;
import com.scaler.bookmyshow.controller.UserController;
import com.scaler.bookmyshow.dto.*;
import com.scaler.bookmyshow.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@SpringBootTest
class BookMyShowApplicationTests {

    @Autowired
    private UserController userController;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private ScreenRepo screenRepo;
    @Autowired
    private SeatRepo seatRepo;

    @Test
    void contextLoads() {
    }



    @Test
    public void testSignUpFunctionality(){
        SignupRequestDto signupRequestDto = new SignupRequestDto();
        signupRequestDto.setName("Vijay");
        signupRequestDto.setEmail("Vijay@gmail.com");
        signupRequestDto.setPassword("rock@13");
        SignupResponseDto signupResponseDto = userController.signUp(signupRequestDto);
        System.out.println("User id is "+ signupResponseDto.getUserId());
    }


    @Test
    public void testShow(){
        Movie m = new Movie();
        m.setName("Inception");
        m.setRunningTime(2.5F);
        m.setFeatures(List.of(Features.DOLBY,Features.IMAX));
        m.setReleaseDate(new Date(22/07/2012));

        movieRepo.save(m);

        Seat seat1 = new Seat();
        seat1.setRow(1);
        seat1.setCol(1);
        seat1.setNumber("A1");
        seat1.setSeatType(SeatType.SILVER);

        seatRepo.save(seat1);

        Seat seat2 = new Seat();
        seat2.setRow(1);
        seat2.setCol(2);
        seat2.setNumber("A2");
        seat2.setSeatType(SeatType.SILVER);

        seatRepo.save(seat2);

        Seat seat3 = new Seat();
        seat3.setRow(1);
        seat3.setCol(3);
        seat3.setNumber("A3");
        seat3.setSeatType(SeatType.SILVER);

        seatRepo.save(seat3);

        Screen s1 = new Screen();
        s1.setName("Screen 1");
        s1.setFeatures(List.of(Features.TOW_D,Features.THREE_D));
        s1.setSeats(List.of(seat1,seat2,seat3));

        screenRepo.save(s1);

        Show s = new Show();
        s.setMovie(m);
        s.setScreen(s1);
        s.setFeatures(List.of(Features.TOW_D,Features.THREE_D));

        showRepository.save(s);

        ShowSeat ss1 = new ShowSeat();
        ss1.setShow(s);
        ss1.setSeat(seat1);
        ss1.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
        showSeatRepository.save(ss1);

        ShowSeat ss2 = new ShowSeat();
        ss2.setShow(s);
        ss2.setSeat(seat2);
        ss2.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
        showSeatRepository.save(ss2);

        ShowSeat ss3 = new ShowSeat();
        ss3.setShow(s);
        ss3.setSeat(seat3);
        ss3.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
        showSeatRepository.save(ss3);
    }

    @Test
    public void testLoginFunctionality(){
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setEmail("Vijay@gmail.com");
        loginRequestDto.setPassword("rock@133");
        LoginResponseDto loginResponseDto = userController.login(loginRequestDto);
        if( loginResponseDto.getResponseStatus().equals(ResponseStatus.SUCCESS) ){
            System.out.println("Password matches.");
        }
        else{
            System.out.println("Password not matched.");
        }

    }




}
