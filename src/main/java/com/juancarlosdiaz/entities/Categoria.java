package com.juancarlosdiaz.entities;

public enum Categoria {
   categoria1("cine"),categoria2("electricidad");

    private String nombre;

    private  Categoria(String nombre){
        this.nombre=nombre;
    }
    public  String getNombre(){
        return nombre;
    }



}
