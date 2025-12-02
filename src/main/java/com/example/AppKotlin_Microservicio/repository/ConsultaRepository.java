package com.example.AppKotlin_Microservicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AppKotlin_Microservicio.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByPacienteId(Long pacienteId);

    List<Consulta> findByDoctorId(Long doctorId);
}