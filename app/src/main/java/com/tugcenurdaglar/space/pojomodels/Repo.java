package com.tugcenurdaglar.space.pojomodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Repo implements Serializable {

    @SerializedName("flight_number")
    @Expose
    public  Integer flightNumber;
    @SerializedName("launch_year")
    @Expose
    public String launchYear;

    @SerializedName("rocket")
    @Expose
    public Rocket rocket;

}
