package com.juancarlosdiaz.dao;



import com.juancarlosdiaz.dao.Articulos.DAOArticulos;

import com.juancarlosdiaz.dao.Articulos.DAOArticulosXML;
import com.juancarlosdiaz.dao.Tiendas.DAOTienda;
import com.juancarlosdiaz.dao.Tiendas.DAOTiendas;

public class DAOFactory {


    private static DAOFactory daoFactory;
    private DAOArticulosXML daoclientes;
    private DAOTienda daoTienda;
    private DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public DAOArticulos getDaoclientes(){
        if (daoclientes==null){
            daoclientes= new DAOArticulosXML();
        }
        return  daoclientes;
    }
    private DAOTienda getDAOtienda(){
        if (daoTienda==null){
            daoTienda=new DAOTiendas();
        }
        return daoTienda;
    }

}