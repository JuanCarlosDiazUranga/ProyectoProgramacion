package com.juancarlosdiaz.entities;

import java.util.Date;

/**
 * esta es la clase padre de responsabledeinformativa y de responsabledeinformativa
 */
public class Trabajadores {
    private  Integer salario;
    private String dni;
    private Date fechadealta;
    private Integer telefono;
    private  String correro;

    public Trabajadores(String dni, Date fechadealta,Integer salario) {
        this.dni = dni;
        this.fechadealta=fechadealta;
        this.salario=salario;
    }
}
