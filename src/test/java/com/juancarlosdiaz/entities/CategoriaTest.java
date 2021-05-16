package com.juancarlosdiaz.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaTest {
    @Test
    public void asignaDatos() {
       Categoria categoria = new Categoria();
       String nombreEsperado="CINEFILO";
       categoria.setNombre(nombreEsperado);
        assertEquals(nombreEsperado,categoria.getNombre());
    }
    }
