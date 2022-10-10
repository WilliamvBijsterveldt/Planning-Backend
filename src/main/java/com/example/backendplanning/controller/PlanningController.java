package com.example.backendplanning.controller;

import com.example.backendplanning.model.Planning;
import com.example.backendplanning.service.PlanningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/planning")
public class PlanningController {
    private PlanningService planningService;

    public PlanningController(PlanningService planningService) {
        this.planningService = planningService;
    }

    @PostMapping
    public ResponseEntity<Planning> saveEmployee(@RequestBody Planning planning){
        return new ResponseEntity<>(planningService.createPlanning(planning), HttpStatus.CREATED);
    }
}
