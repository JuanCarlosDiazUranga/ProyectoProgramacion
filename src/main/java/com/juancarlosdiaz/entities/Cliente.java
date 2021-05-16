package com.juancarlosdiaz.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * esta clase tiene 3 arrayliste que de articulos que representan la lista de deseados , el carrito de compra y los articulos ya comprados.
 */
public class Cliente {


    private  String id;
    private String nombre;

    private  String password;
    /**
     * es una lista de articulos deseados por un cliente
     */
    private List<Articulo> deseos;
    /**
     * es una lista de articulos comprados por un cliente
     */
    private List<Articulo> comprados;
    /**
     * es una lista de articulos que guarda en carrito un cliente
     */
    private List<Articulo>  carrito;


    public Cliente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.deseos = new ArrayList<>();
        this.comprados = new ArrayList<>();
        this.carrito = new ArrayList<>();
    }
    public  Cliente(){}

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public void setDeseos(List<Articulo> deseos) {
        this.deseos = deseos;
    }

    public void setComprados(List<Articulo> comprados) {
        this.comprados = comprados;
    }

    public void setCarrito(List<Articulo> carrito) {
        this.carrito = carrito;
    }

    public String getNombre() {
        return nombre;
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
                ", password='" + password + '\'' +
                ", deseos=" + deseos +
                ", comprados=" + comprados +
                ", carrito=" + carrito +
                '}';
    }
}
