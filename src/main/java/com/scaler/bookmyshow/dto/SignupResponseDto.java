package com.scaler.bookmyshow.dto;

import lombok.Data;

@Data
public class SignupResponseDto {
    private Long userId;
    private ResponseStatus responseStatus;
}
