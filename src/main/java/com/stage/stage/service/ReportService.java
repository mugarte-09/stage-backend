package com.stage.stage.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.stage.model.Report;
import com.stage.stage.model.Sensor;
import com.stage.stage.model.WaterQualityData;
import com.stage.stage.repository.ReportRepository;
import com.stage.stage.repository.SensorRepository;
import com.stage.stage.repository.WaterQualityDataRepository;
import com.stage.stage.service.impl.ReportServiceImpl;
import java.util.Optional;


@Service
public class ReportService implements ReportServiceImpl {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private WaterQualityDataRepository waterQualityDataRepository;

    @Override
    public Report generateReport(Long sensorId, LocalDateTime startDate, LocalDateTime endDate) {
        Optional<Sensor> sensorOpt = sensorRepository.findById(sensorId);
        if(sensorOpt.isEmpty()){
            throw new RuntimeException("Sensor not find");
        }
        Sensor sensor = sensorOpt.get();

        List<WaterQualityData> waterQualityList = waterQualityDataRepository.findBySensorIdAndTimestampBetween(sensorId, startDate, endDate);

        Report report = new Report();
        report.setSensor(sensor);
        report.setWaterQualityDataList(waterQualityList);
        report.setGenerateAt(LocalDateTime.now());
        report.setSummary(generateSummary(waterQualityList));
        report.setStatus(null);

        return reportRepository.save(report);

    }

    private String generateSummary(List<WaterQualityData> waterQualityList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateSummary'");
    }

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> getReportsBySensor(Long sensorId) {
        return reportRepository.findBySensorId(sensorId);
    }

    @Override
    public List<Report> getReportsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return reportRepository.findByGeneratedAtBetween(startDate, endDate);
    }
    
}
