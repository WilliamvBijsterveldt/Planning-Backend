package com.example.backendplanning.service;

import com.example.backendplanning.model.Planning;

import java.util.List;

public interface PlanningService {
    Planning createPlanning(Planning planning);
    List<Planning> getAllPlannings();
    Planning getPlanningById(long id);
    Planning updatePlanning(Planning planning, long id);
    void deletePlanning(long id);
}
