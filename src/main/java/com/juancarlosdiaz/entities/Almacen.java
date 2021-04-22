package com.juancarlosdiaz.entities;

public class Almacen {
    private  String estanteria;
    private  Integer codigo;
    private  Integer seccion;
    private  String direccion;


    public Almacen(Integer codigo,String direccion) {
        this.codigo = codigo;
        this.direccion=direccion;
    }
}
