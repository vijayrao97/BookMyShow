package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDto {
    private Long BookingId;
    private ResponseStatus responseStatus;
}
