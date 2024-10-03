package com.stage.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.stage.model.Alert;

@Repository
public interface AlertRepository extends JpaRepository<Alert,Long> {
    
}
