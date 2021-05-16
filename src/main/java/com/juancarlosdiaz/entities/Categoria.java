package com.juancarlosdiaz.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "categoria")
public class Categoria {
    @JacksonXmlElementWrapper(localName = "nombre")
    private String nombre;

    public Categoria(  ) {

    }

    public Categoria(String nombre) {
        this.nombre = nombre;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
