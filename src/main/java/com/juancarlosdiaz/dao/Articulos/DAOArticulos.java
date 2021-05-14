package com.juancarlosdiaz.dao.Articulos;

import java.util.List;

import com.juancarlosdiaz.entities.Articulo;


public interface DAOArticulos {

     public Articulo exists(String codigo);
    public void crear(Articulo articulo);
    public void eliminar(String codigo);
    public List<Articulo> getAll();
    public void clear();
    public void actualizarArticulo(Articulo articulo);

}
