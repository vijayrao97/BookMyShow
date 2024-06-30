package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity

public class Theater extends BaseClass {
    private String name;
    @ManyToOne
    private Region region;
    @OneToMany
    private List<Screen> screens;
    @Enumerated(EnumType.ORDINAL)
    private TheaterType theaterType;
}
