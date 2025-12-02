package com.example.AppKotlin_Microservicio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.AppKotlin_Microservicio.model.Paciente;
import com.example.AppKotlin_Microservicio.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> getAll() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable Long id) {
        Optional<Paciente> pac = pacienteService.findById(id);
        return pac.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paciente create(@RequestBody Paciente paciente) {
        return pacienteService.save(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody Paciente paciente) {
        Optional<Paciente> pac = pacienteService.findById(id);

        if (pac.isEmpty()) return ResponseEntity.notFound().build();

        paciente.setId(id);
        return ResponseEntity.ok(pacienteService.save(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
