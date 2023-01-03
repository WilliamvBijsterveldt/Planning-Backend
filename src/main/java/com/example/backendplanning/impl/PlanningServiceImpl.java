package com.example.backendplanning.impl;

import com.example.backendplanning.exception.ResourceNotFoundException;
import com.example.backendplanning.model.Coordinate;
import com.example.backendplanning.model.CreatePlanning;
import com.example.backendplanning.model.Planning;
import com.example.backendplanning.model.Weather;
import com.example.backendplanning.repository.PlanningRepository;
import com.example.backendplanning.service.PlanningService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PlanningServiceImpl implements PlanningService {

    private RestTemplate restTemplate = new RestTemplate();
    private PlanningRepository planningRepository;

    public PlanningServiceImpl(PlanningRepository planningRepository) {
        this.planningRepository = planningRepository;
    }

    @Override
    public Planning createPlanning(CreatePlanning createPlanning) {
        var weather = getWeather(createPlanning.getCoordinate());

        createPlanning.getPlanning().setWeather(weather);

        return planningRepository.save(createPlanning.getPlanning());
    }

    @Override
    public List<Planning> getAllPlannings() {
        return planningRepository.findAll();
    }

    @Override
    public Planning getPlanningById(long id) {
        return planningRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Planning", "Id", id));
    }

    @Override
    public Planning updatePlanning(Planning planning, long id) {
        Planning previousPlanning = planningRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Planning", "Id", id));

        previousPlanning.setActivityType(planning.getActivityType());
        previousPlanning.setDescription(planning.getDescription());
        previousPlanning.setStartDate(planning.getStartDate());
        previousPlanning.setEndDate(planning.getEndDate());

        planningRepository.save(previousPlanning);

        return previousPlanning;
    }

    @Override
    public void deletePlanning(long id) {
        planningRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Planning", "Id", id));

        planningRepository.deleteById(id);
    }

    private Weather getWeather(Coordinate coordinate) {
        String url = String.format("http://localhost:9000/weatherTest?lat=%s&lon=%s",coordinate.getLat(), coordinate.getLon());
        return restTemplate.getForObject(url, Weather.class);
    }
}
