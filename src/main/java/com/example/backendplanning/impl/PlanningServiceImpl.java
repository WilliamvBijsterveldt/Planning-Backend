package com.example.backendplanning.impl;

import com.example.backendplanning.model.Planning;
import com.example.backendplanning.repository.PlanningRepository;
import com.example.backendplanning.service.PlanningService;
import org.springframework.stereotype.Service;

@Service
public class PlanningServiceImpl implements PlanningService {

    private PlanningRepository planningRepository;

    @Override
    public Planning createPlanning(Planning planning) {
        return planningRepository.save(planning);
    }
}
