package com.example.backendplanning.service;

import com.example.backendplanning.model.Planning;
import com.example.backendplanning.repository.PlanningRepository;

public interface PlanningService {
    Planning createPlanning(Planning planning);
}
