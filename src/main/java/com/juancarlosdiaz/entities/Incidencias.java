package com.juancarlosdiaz.entities;

import java.util.Date;

public class Incidencias {
    private String id;
    private  String estado;
    private String asunto;
    private String mensaje ;
    private Date fechadeentrada;

    public Incidencias(String id, Date fechadeentrada) {
        this.id = id;

        this.fechadeentrada = fechadeentrada;
    }
}
