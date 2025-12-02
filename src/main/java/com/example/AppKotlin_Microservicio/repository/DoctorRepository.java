package com.example.AppKotlin_Microservicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AppKotlin_Microservicio.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
