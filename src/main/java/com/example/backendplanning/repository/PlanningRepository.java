package com.example.backendplanning.repository;

import com.example.backendplanning.model.Planning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanningRepository extends JpaRepository<Planning, Long> {
}
