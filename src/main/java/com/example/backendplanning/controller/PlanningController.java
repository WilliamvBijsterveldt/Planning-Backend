package com.example.backendplanning.controller;

import com.example.backendplanning.model.CreatePlanning;
import com.example.backendplanning.model.Planning;
import com.example.backendplanning.model.Weather;
import com.example.backendplanning.service.PlanningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/planning")
public class PlanningController {
    private PlanningService planningService;

    public PlanningController(PlanningService planningService) {
        this.planningService = planningService;
    }

    @PostMapping
    public ResponseEntity<Planning> saveEmployee(@Valid @RequestBody CreatePlanning createPlanning){
        return new ResponseEntity<>(planningService.createPlanning(createPlanning), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Planning> getAllPlannings() {
        return planningService.getAllPlannings();
    }

    @GetMapping("{id}")
    public ResponseEntity<Planning> getPlanningById(@PathVariable("id") long id) {
        return new ResponseEntity<Planning>(planningService.getPlanningById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Planning> updatePlanning(@PathVariable("id") long id, @RequestBody Planning planning) {
        return new ResponseEntity<>(planningService.updatePlanning(planning, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePlanning(@PathVariable("id") long id) {
        planningService.deletePlanning(id);

        return new ResponseEntity<>("Employee has been deleted successfully!", HttpStatus.OK);
    }
}
