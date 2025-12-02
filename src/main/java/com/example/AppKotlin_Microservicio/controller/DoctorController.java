package com.example.AppKotlin_Microservicio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.AppKotlin_Microservicio.model.Doctor;
import com.example.AppKotlin_Microservicio.service.DoctorService;

@RestController
@RequestMapping("/doctores")
@CrossOrigin("*")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAll() {
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorService.findById(id);
        return doctor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Doctor create(@RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> update(@PathVariable Long id, @RequestBody Doctor doctor) {
        Optional<Doctor> doc = doctorService.findById(id);

        if (doc.isEmpty()) return ResponseEntity.notFound().build();

        doctor.setId(id);
        return ResponseEntity.ok(doctorService.save(doctor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
