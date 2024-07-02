package com.scaler.bookmyshow;

import com.scaler.bookmyshow.Repo.BookingRepo;
import com.scaler.bookmyshow.Repo.UserRepository;
import com.scaler.bookmyshow.Service.UserService;
import com.scaler.bookmyshow.controller.UserController;
import com.scaler.bookmyshow.dto.SignupRequestDto;
import com.scaler.bookmyshow.dto.SignupResponseDto;
import com.scaler.bookmyshow.models.Booking;
import com.scaler.bookmyshow.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BookMyShowApplicationTests {

    @Autowired
    private UserController userController;

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


}
