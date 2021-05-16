package com.juancarlosdiaz.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticuloTest {
    @Test
    public void asignaDatos() {
        Articulo articulo = new Articulo();
        String codigoEsperado="1";
        articulo.setCodigo(codigoEsperado);
        Float precioEsperado=1233f;
        articulo.setPrecio(precioEsperado);
        assertEquals(codigoEsperado,articulo.getCodigo());
        assertEquals(precioEsperado,articulo.getPrecio());
    }
}