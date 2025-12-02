package com.example.AppKotlin_Microservicio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.AppKotlin_Microservicio.model.Consulta;
import com.example.AppKotlin_Microservicio.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
@CrossOrigin("*")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping
    public List<Consulta> getAll() {
        return consultaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getById(@PathVariable Long id) {
        Optional<Consulta> consulta = consultaService.findById(id);
        return consulta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/paciente/{id}")
    public List<Consulta> getByPaciente(@PathVariable Long id) {
        return consultaService.findByPaciente(id);
    }

    @GetMapping("/doctor/{id}")
    public List<Consulta> getByDoctor(@PathVariable Long id) {
        return consultaService.findByDoctor(id);
    }

    @PostMapping
    public Consulta create(@RequestBody Consulta consulta) {
        return consultaService.save(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> update(@PathVariable Long id, @RequestBody Consulta consulta) {
        Optional<Consulta> cons = consultaService.findById(id);

        if (cons.isEmpty()) return ResponseEntity.notFound().build();

        consulta.setId(id);
        return ResponseEntity.ok(consultaService.save(consulta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        consultaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
