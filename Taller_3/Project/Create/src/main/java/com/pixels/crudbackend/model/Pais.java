package com.pixels.crudbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "Pais")
@Data
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

}
