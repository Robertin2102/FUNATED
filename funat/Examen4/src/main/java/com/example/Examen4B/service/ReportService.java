package com.example.Examen4B.service;

import com.example.Examen4B.dto.CreateReportDTO;
import com.example.Examen4B.model.Report;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;


@Service
public class ReportService {

    private final Map<Long, Report> reports = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public Report createReport(CreateReportDTO dto) {
        Long id = counter.incrementAndGet();
        Report report = new Report(id,
                dto.getProductName(),
                dto.getProblemDescription(),
                dto.getReportDate());
        reports.put(id, report);
        return report;
    }

    public List<Report> getAll(){
        return new ArrayList<>(reports.values());
    }

    public List<Report> searchByName(String name){
        return reports.values().stream()
                .filter(r ->r.getProductName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Report resolveReport(Long id) {
        Report report = reports.get(id);
        if (report != null) {
            report.setResolved(true);
        }
        return report;
    }



}