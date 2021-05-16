package com.juancarlosdiaz.dao.Articulos;

import com.juancarlosdiaz.dao.DAOSerializable;
import com.juancarlosdiaz.entities.Articulo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DAOArticulosSerializable extends DAOSerializable implements DAOArticulos  {
    private final List<Articulo> articulos;

    public DAOArticulosSerializable() {
        super("articulos");
        Object obj = load();
        if (obj == null) {
            this.articulos = new ArrayList<>();
        } else this.articulos = (List<Articulo>) obj;
    }

    @Override
    public Articulo exists(String codigo) {
        return null;
    }

    @Override
    public void crear(Articulo articulo) {
        articulos.add(articulo);
        this.save(articulo);
    }

    @Override
    public void eliminar(String codigo) {
        articulos.remove(codigo);
        this.save(articulos);
    }

    @Override
    public List<Articulo> getAll() {
        return articulos;
    }

    @Override
    public void clear() {
        List<Articulo> partidos = getAll();
        partidos.remove(partidos);
    }

    @Override
    public void actualizarArticulo(Articulo articulo) {
        List<Articulo> articulos = getAll();
        for (int i = 0; i < articulos.size(); i++) {
            Articulo actual = articulos.get(i);
            if (actual.getCodigo().equals(articulo.getCodigo())){
                articulos.add(articulo);
            }
            break;
        }
        save(articulos);
    }
}
