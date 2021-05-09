package com.juancarlosdiaz.dao;



import com.juancarlosdiaz.dao.Articulos.DAOArticulos;

import com.juancarlosdiaz.dao.Articulos.DAOArticulosXML;
import com.juancarlosdiaz.dao.Tiendas.DAOTienda;
import com.juancarlosdiaz.dao.Tiendas.DAOTiendas;

public class DAOFactory {


    private static DAOFactory daoFactory;
    private DAOArticulosXML daoarticulos;
    private DAOTienda daoTienda;
    private DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public DAOArticulos getDAOarticulos(){
        if (daoarticulos==null){
            daoarticulos= new DAOArticulosXML();
        }
        return  daoarticulos;
    }
    private DAOTienda getDAOtienda(){
        if (daoTienda==null){
            daoTienda=new DAOTiendas();
        }
        return daoTienda;
    }

}