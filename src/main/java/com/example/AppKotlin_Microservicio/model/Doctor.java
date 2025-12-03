package com.example.AppKotlin_Microservicio.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;
    private String foto;
    private String ciudad;
    private String pais;
    private String especialidad;
    private int experiencia;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Consulta> consultas;
}
