package com.juancarlosdiaz.entities;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ClienteTest {
    @Test
    public void asignaDatos() {
        Cliente cliente = new Cliente();
        String nombreEsperado="pepe";
        cliente.setNombre(nombreEsperado);
        String idEsperado ="1";
        cliente.setId(idEsperado);
        String passwordEsperada="1234";
        cliente.setPassword(passwordEsperada);
        assertEquals(nombreEsperado,cliente.getNombre());
        assertEquals(idEsperado,cliente.getId());

        assertEquals(passwordEsperada,cliente.getPassword());
    }
    }
