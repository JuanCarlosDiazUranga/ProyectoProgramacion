package com.juancarlosdiaz.entities;

public class Articulo {
    private String codigo;
    private Integer precio;

    public Articulo(String codigo, Integer precio) {
        this.codigo = codigo;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public Integer getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo='" + codigo + '\'' +
                ", precio=" + precio +
                '}';
    }
}