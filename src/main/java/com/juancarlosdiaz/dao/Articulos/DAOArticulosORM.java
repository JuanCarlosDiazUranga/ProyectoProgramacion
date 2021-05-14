package com.juancarlosdiaz.dao.Articulos;

import com.juancarlosdiaz.entities.Articulo;

import java.sql.SQLException;
import java.util.List;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.juancarlosdiaz.db.DBConnectionORM;



public class DAOArticulosORM implements DAOArticulos {

    Dao<Articulo, String> daoarticulosORM;

    public DAOArticulosORM() throws SQLException {
        this.daoarticulosORM = DaoManager.createDao(
                DBConnectionORM.getInstance(),
                Articulo.class
        );
        DaoManager.registerDao(
                DBConnectionORM.getInstance(),
                daoarticulosORM);
    }

    @Override
    public Articulo exists(String codigo) {
        try {
            return daoarticulosORM.queryForId(String.valueOf(codigo));
        } catch (SQLException throwables) {
            return null;
        }
    }

    @Override
    public void crear(Articulo articulo) {
        try {
            daoarticulosORM.create(articulo);
        } catch (SQLException throwables) {

        }
    }



    @Override
    public void eliminar(String codigo) {
        try {
            daoarticulosORM.deleteById(String.valueOf(codigo));
        } catch (SQLException throwables) {
        }
    }

    @Override
    public List<Articulo> getAll() {
        try {
            return daoarticulosORM.queryForAll();
        } catch (SQLException throwables) {
            return null;
        }
    }

    @Override
    public void clear() {
        try {
            daoarticulosORM.delete(getAll());
        }catch (SQLException throwables) {

        }
    }

    @Override
    public void actualizarArticulo(Articulo articulo) {

    }
}
