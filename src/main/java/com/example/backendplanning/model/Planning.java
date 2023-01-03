package com.example.backendplanning.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "planning")
public class Planning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Activity", nullable = false)
    private String activityType;

    @Column(name = "Description")
    private String description;

    @Column(name = "Start_Date")
    private Date startDate;

    @Column(name = "End_Date")
    private Date endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weather_id", referencedColumnName = "id")
    private Weather weather;
}
