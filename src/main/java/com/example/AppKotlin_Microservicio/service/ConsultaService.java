package com.example.AppKotlin_Microservicio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.AppKotlin_Microservicio.model.Consulta;
import com.example.AppKotlin_Microservicio.repository.ConsultaRepository;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> findById(Long id) {
        return consultaRepository.findById(id);
    }

    public List<Consulta> findByPaciente(Long pacienteId) {
        return consultaRepository.findByPacienteId(pacienteId);
    }

    public List<Consulta> findByDoctor(Long doctorId) {
        return consultaRepository.findByDoctorId(doctorId);
    }

    public Consulta save(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void delete(Long id) {
        consultaRepository.deleteById(id);
    }
}
