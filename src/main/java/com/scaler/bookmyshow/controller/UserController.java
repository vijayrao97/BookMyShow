package com.scaler.bookmyshow.controller;


import com.scaler.bookmyshow.Service.UserService;
import com.scaler.bookmyshow.dto.*;
import com.scaler.bookmyshow.models.User;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupResponseDto signUp(SignupRequestDto signupRequestDto){
        User u = userService.signUp(signupRequestDto.getEmail(),
                                    signupRequestDto.getPassword(),
                                    signupRequestDto.getName());
        SignupResponseDto signupResponseDto = new SignupResponseDto();
        signupResponseDto.setUserId(u.getId());
        signupResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return signupResponseDto;
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        try{
            User u = userService.login(loginRequestDto.getEmail(),loginRequestDto.getPassword());
            loginResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            loginResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return loginResponseDto;
    }

}
