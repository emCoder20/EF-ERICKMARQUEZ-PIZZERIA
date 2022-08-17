package com.idat.EFERICKMARQUEZPIZERIA.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "pizzeria")
public class Pizzeria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPizzeria;
    private String direccion;
    private String sede;
}
