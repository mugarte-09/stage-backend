package com.stage.stage.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.stage.model.WaterQualityData;
import java.time.LocalDateTime;

@Repository
public interface WaterQualityDataRepository extends JpaRepository<WaterQualityData,Long> {
    List<WaterQualityData> findBySensorIdAndTimestampBetween(Long id, LocalDateTime start, LocalDateTime end);
}
