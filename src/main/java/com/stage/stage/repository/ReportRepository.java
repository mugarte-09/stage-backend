package com.stage.stage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.stage.model.Report;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
    List<Report> findByGeneratedAtBetween(LocalDateTime start,LocalDateTime end );
    List<Report> findBySensorId(Long sensorId);
}
