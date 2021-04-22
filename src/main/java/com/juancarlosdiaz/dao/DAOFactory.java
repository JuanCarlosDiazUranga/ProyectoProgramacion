package com.juancarlosdiaz.dao;


import com.juancarlosdiaz.dao.Clientes.DAOCliente;
import com.juancarlosdiaz.dao.Clientes.DAOClientes;
import com.juancarlosdiaz.dao.Tiendas.DAOTienda;
import com.juancarlosdiaz.dao.Tiendas.DAOTiendas;

public class DAOFactory {


        private static DAOFactory daoFactory;
        private DAOClientes daoclientes;
private DAOTienda daoTienda;
        private DAOFactory(){}

        public static DAOFactory getInstance() {
            if(daoFactory == null){
                daoFactory = new DAOFactory();
            }
            return daoFactory;
        }
        private  DAOClientes getDaoclientes(){
            if (daoclientes==null){
                daoclientes=new DAOCliente();
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