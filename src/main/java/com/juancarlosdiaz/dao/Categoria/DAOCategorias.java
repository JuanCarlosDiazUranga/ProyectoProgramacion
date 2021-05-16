package com.juancarlosdiaz.dao.Categoria;

import com.juancarlosdiaz.entities.Categoria;

import java.util.List;

public interface DAOCategorias {
    public List<Categoria> list();
    public Categoria get(String nombre);
    public void add(Categoria categoria);
    public void update(Categoria categoria);
    public void clear();
    public void eliminarCategoria(String codigo);
}
