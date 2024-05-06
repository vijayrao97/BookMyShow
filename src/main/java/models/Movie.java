package models;

import java.util.Date;
import java.util.List;

public class Movie extends BaseClass{
    private String name;
    private Date releaseDate;
    private float runningTime;
    private List<Features> features;
}
