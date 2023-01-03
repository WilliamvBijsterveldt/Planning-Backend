package com.example.backendplanning.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Cloudiness")
    private int cloudiness;

    @Column(name = "CurrentWeather")
    private String currentWeather;

    @Column(name = "Temperature")
    private Double temperature;

    @Column(name = "WindSpeed")
    private int windSpeed;
}
