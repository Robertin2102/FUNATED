package com.example.Examen4B.controller;

import com.example.Examen4B.dto.CreateReportDTO;
import com.example.Examen4B.model.Report;
import com.example.Examen4B.service.ReportService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reports")
public class ReportController   {

    private final ReportService service;

    public ReportController(ReportService service){
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreateReportDTO dto) {
        Report report = service.createReport(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(report);
    }

    @GetMapping
    public ResponseEntity<List<Report>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(required = false) String name) {
        if (name == null || name.isBlank()) {
            return ResponseEntity.badRequest().body("name es obligatorio");
        }

        List<Report> found = service.searchByName(name);
        if (found.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product no encontrado");
        }

        return ResponseEntity.ok(found);
    }

    @PatchMapping("/{id}/resolve")
    public ResponseEntity<?> resolve(@PathVariable Long id) {
        Report report = service.resolveReport(id);

        if (report == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product no encontrado");
        }

        return ResponseEntity.ok(report);
    }
}