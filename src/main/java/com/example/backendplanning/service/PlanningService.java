package com.example.backendplanning.service;

import com.example.backendplanning.model.CreatePlanning;
import com.example.backendplanning.model.Planning;
import com.example.backendplanning.model.Weather;

import java.util.List;

public interface PlanningService {
    Planning createPlanning(CreatePlanning createPlanning);
    List<Planning> getAllPlannings();
    Planning getPlanningById(long id);
    Planning updatePlanning(Planning planning, long id);
    void deletePlanning(long id);
    Weather getWeatherByPlanning(long planningID);
}
