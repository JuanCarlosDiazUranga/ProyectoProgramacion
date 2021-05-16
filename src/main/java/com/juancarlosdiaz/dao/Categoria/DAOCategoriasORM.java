package com.juancarlosdiaz.dao.Categoria;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.juancarlosdiaz.db.DBConnectionORM;
import com.juancarlosdiaz.entities.Categoria;

import java.sql.SQLException;
import java.util.List;

public class DAOCategoriasORM implements DAOCategorias {
    Dao<Categoria, String> daoCategoriasORM;

    public DAOCategoriasORM() throws SQLException {
        this.daoCategoriasORM = DaoManager.createDao(
                DBConnectionORM.getInstance(),
                Categoria.class
        );
        DaoManager.registerDao(
                DBConnectionORM.getInstance(),
                daoCategoriasORM);
    }

    @Override
    public List<Categoria> list() {
        try {
            return daoCategoriasORM.queryForAll();
        } catch (SQLException throwables) {
            return null;
        }
    }

    @Override
    public Categoria get(String nombre) {
        try {
            return daoCategoriasORM.queryForId(nombre);
        } catch (SQLException throwables) {
            return null;
        }
    }

    @Override
    public void add(Categoria categoria) {
        try {
            daoCategoriasORM.create(categoria);
        } catch (SQLException throwables) {
        }
    }

    @Override
    public void update(Categoria categoria) {
        try {
            daoCategoriasORM.update(categoria);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public void clear() {
        try {
            daoCategoriasORM.delete(list());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void eliminarCategoria(String nombre) {
        try {
            daoCategoriasORM.delete(get(nombre));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
}
    }
