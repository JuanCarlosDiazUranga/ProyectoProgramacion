package com.juancarlosdiaz.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * esta clase tiene 3 arrayliste que de articulos que representan la lista de deseados , el carrito de compra y los articulos ya comprados.
 */
public class Cliente {


    private  String id;
    private final String nombre;
    private String cliente;
    private  String password;
    /**
     * es una lista de articulos deseados por un cliente
     */
    private final List<Articulo> deseos;
    /**
     * es una lista de articulos comprados por un cliente
     */
    private final List<Articulo> comprados;
    /**
     * es una lista de articulos que guarda en carrito un cliente
     */
    private final List<Articulo>  carrito;


    public Cliente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.deseos = new ArrayList<>();
        this.comprados = new ArrayList<>();
        this.carrito = new ArrayList<>();
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCliente() {
        return cliente;
    }

    public String getPassword() {
        return password;
    }

    public List<Articulo> getDeseos() {
        return deseos;
    }

    public List<Articulo> getComprados() {
        return comprados;
    }

    public List<Articulo> getCarrito() {
        return carrito;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cliente='" + cliente + '\'' +
                ", password='" + password + '\'' +
                ", deseos=" + deseos +
                ", comprados=" + comprados +
                ", carrito=" + carrito +
                '}';
    }
}
