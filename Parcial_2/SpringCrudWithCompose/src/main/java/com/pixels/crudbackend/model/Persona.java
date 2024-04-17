package com.pixels.crudbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "Persona")
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;

}
