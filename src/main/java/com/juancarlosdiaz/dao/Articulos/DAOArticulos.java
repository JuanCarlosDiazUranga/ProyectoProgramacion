package com.juancarlosdiaz.dao.Articulos;

import java.util.List;

import com.juancarlosdiaz.entities.Articulo;


public interface DAOArticulos {

    public Articulo exists(String codigo);
    public String crear(Articulo articulo);
    public void eliminar(String codigo,Articulo articulo);
    public List<Articulo> getAll();


}
