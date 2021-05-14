package com.juancarlosdiaz.dao.Articulos;

import com.juancarlosdiaz.db.DBConnectionSQL;
import com.juancarlosdiaz.entities.Articulo;
import com.juancarlosdiaz.entities.Categoria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            }
            statement.execute("insert into articulos (codigo,precio,categoria) " +
                    "values ('" + articulo.getCodigo() + "','" + articulo.getPrecio() + "','" + categoria + ")" );
        } catch (SQLException exception) {

            if (exception.getErrorCode() == 1062) {
                System.err.println("Ya existe una articulo con estos campos");
            } else {
                System.err.println(exception.getMessage());
            }

        }
    }

    @Override
    public void eliminar(String codigo) {
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            statement.execute("" +
                    "DELETE FROM articulos WHERE codigo=" + codigo);
        } catch (SQLException exception) {

            if (exception.getErrorCode() == 1062) {
                System.err.println("Ya existe una oferta con estos campos");
            } else {
                System.err.println(exception.getMessage());
            }

        }
    }

    @Override
    public List<Articulo> getAll() {
        List<Articulo> articulos = new ArrayList<>();
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("" +
                    "select * from articulos ");
            while (resultSet.next()) {

                String codigo = resultSet.getString("codigo");

                Float precio = resultSet.getFloat("precio");

                String nombre = String.valueOf(resultSet.getInt("categoria"));
                Categoria categoria = new Categoria(nombre);
                articulos.add(new Articulo(codigo, precio,  categoria));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return articulos;

    }

    @Override
    public void clear() {
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            statement.execute("delete from articulos");
        }catch (SQLException exception) {
            if (exception.getErrorCode() == 1062) {
                System.err.println("error lista de articulos");
            } else {
                System.err.println(exception.getMessage());
            }
        }
    }

    @Override
    public void actualizarArticulo(Articulo articulo) {
        try {
            Statement statement = DBConnectionSQL.getInstance().createStatement();
            String sql = "" +
                    "UPDATE articulos SET precio='" + articulo.getPrecio() + "', categoria='" + articulo.getCategoria() + "' where ID = " + articulo.getCodigo();

            statement.execute(sql);

        } catch (SQLException exception) {

            if (exception.getErrorCode() == 1062) {
                System.err.println("Error al actualizar la oferta");
            } else {
                System.err.println(exception.getMessage());
            }

        }
    }
}
