package com.stage.stage.repository;


import org.springframework.stereotype.Repository;
import com.stage.stage.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


@Repository
public interface SensorRepository extends JpaRepository<Sensor,Long> {
        List<Sensor> findByActive(boolean active);
}
