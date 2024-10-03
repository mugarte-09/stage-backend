package com.stage.stage.service.impl;


import java.time.LocalDateTime;
import java.util.List;

import com.stage.stage.model.Report;

public interface ReportServiceImpl {
    Report generateReport(Long sensorId, LocalDateTime startDate, LocalDateTime endDate);
    List<Report> getAllReports();
    List<Report> getReportsBySensor(Long sensorId);
    List<Report> getReportsByDateRange(LocalDateTime startDate, LocalDateTime endDate);
}
