package com.juancarlosdiaz.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.j256.ormlite.field.DatabaseField;

@JacksonXmlRootElement(localName = "articulo")
public class Articulo {

    @JacksonXmlProperty(isAttribute = true)
    private String codigo;

    @JacksonXmlProperty(isAttribute = true)
    private Float precio;
    @DatabaseField(foreign = true, columnName = "categoria", canBeNull = true)
    @JacksonXmlProperty(isAttribute = true)
   private  Categoria categoria;

    public Articulo  (){}

    public Articulo(String codigo, Float precio,Categoria categoria) {
        this.codigo = codigo;
        this.precio = precio;
       this.categoria=categoria;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public Float getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "codigo='" + codigo + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                '}';
    }
}