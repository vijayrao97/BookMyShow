package models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity

public class Movie extends BaseClass{
    private String name;
    private Date releaseDate;
    private float runningTime;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> features;
}
