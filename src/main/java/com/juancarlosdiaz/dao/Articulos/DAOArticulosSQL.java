package com.juancarlosdiaz.dao.Articulos;

import com.juancarlosdiaz.db.DBConnectionSQL;
import com.juancarlosdiaz.entities.Articulo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DAOArticulosSQL implements DAOArticulos{
    @Override
    public Articulo exists(String codigo) {
        return null;
    }

    @Override
    public void crear(Articulo articulo) {
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            String categoria = null;

            if (articulo.getCategoria() != null) {
                categoria = articulo.getCategoria().getNombre();
            } else {
                categoria = null;
            }
            statement.execute("insert into articulos (codigo,precio,categoria) " +
                    "values ('" + articulo.getCodigo() + "','" + articulo.getPrecio() + "','" + categoria + ")" );
        } catch (SQLException exception) {
            //SQLError duplicate PK
            if (exception.getErrorCode() == 1062) {
                System.err.println("Ya existe una articulo con estos campos");
            } else {
                System.err.println(exception.getMessage());
            }

        }
    }

    @Override
    public void eliminar(String codigo, Articulo articulo) {

    }

    @Override
    public List<Articulo> getAll() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void actualizarArticulo(Articulo articulo) {

    }
}
