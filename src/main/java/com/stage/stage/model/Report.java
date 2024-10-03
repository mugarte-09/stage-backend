package com.stage.stage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;



@Data
@Entity
@Table(name ="reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "generate_at")
    private LocalDateTime generateAt;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "sensoir_id")
    private Sensor sensor;
    @OneToMany
    @JoinColumn(name = "report_id")
    private List<WaterQualityData> waterQualityDataList;
    @Column(name = "summary")
    private String summary;
}
