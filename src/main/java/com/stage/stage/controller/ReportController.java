package com.stage.stage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stage.stage.model.Report;
import com.stage.stage.service.ReportService;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/reports")
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }

    @PostMapping("/generate")
    public Report generateReport( @RequestParam Long sensorId, @RequestParam String startDate, @RequestParam String endDate){
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return reportService.generateReport(sensorId, start, end);
    }

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/sensor/{sensorId}")
    public List<Report> getReportsBySensor(@PathVariable Long sensorId) {
        return reportService.getReportsBySensor(sensorId);
    }

    @GetMapping("/date-range")
    public List<Report> getReportsByDateRange(@RequestParam String startDate,
                                              @RequestParam String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return reportService.getReportsByDateRange(start, end);
    }
}
