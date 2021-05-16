package com.juancarlosdiaz.dao;



import com.juancarlosdiaz.dao.Articulos.DAOArticulos;

import com.juancarlosdiaz.dao.Articulos.DAOArticulosORM;
import com.juancarlosdiaz.dao.Articulos.DAOArticulosSQL;
import com.juancarlosdiaz.dao.Articulos.DAOArticulosXML;
import com.juancarlosdiaz.dao.Categoria.DAOCategorias;
import com.juancarlosdiaz.dao.Categoria.DAOCategoriasORM;


import java.sql.SQLException;

public class DAOFactory {


    private static DAOFactory daoFactory;
    private DAOArticulos daoarticulos;
private  DAOCategorias daoCategorias;
    private DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public DAOArticulos getDAOarticulos(Source source) {
        if (daoarticulos == null) {
            if (source == Source.XML) {
                daoarticulos = new DAOArticulosXML();
            }
            else if (source ==Source.ORM) {
                try {
                    daoarticulos = new DAOArticulosORM();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            else if (source == Source.SQL){
                daoarticulos = new DAOArticulosSQL();
            }
            }
            return daoarticulos;
        }
    public DAOCategorias getDaoCategorias() {
        if(daoCategorias == null){
            try {
                daoCategorias = new DAOCategoriasORM();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return daoCategorias;
    }

    }


