package com.juancarlosdiaz.entities;

import java.util.Date;
import com.juancarlosdiaz.entities.Trabajadores;


/**
 * esta clase es una herencia de trabajadores
 */
public class ResponsablesDeInformatica extends Trabajadores {

    public ResponsablesDeInformatica(String dni, Date fechadealta, Integer telefono) {
        super(dni, fechadealta, telefono);
    }
}
