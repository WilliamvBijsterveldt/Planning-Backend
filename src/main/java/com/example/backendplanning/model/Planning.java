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
    private Date endDate;

    @Column(name = "End_Date")
    private Date startDate;
}
