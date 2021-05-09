package com.juancarlosdiaz.controllers;

import com.juancarlosdiaz.dao.DAOFactory;
import com.juancarlosdiaz.entities.Articulo;

import java.util.List;

public class ArticulosControllerTerminal {
    public void DosArticulos(){
        System.out.println(DAOFactory.getInstance().getDaoclientes().getAll().get(0));
        System.out.println(DAOFactory.getInstance().getDaoclientes().getAll().get(1));
    }
    public void ArticuloPatata(){
        List<Articulo> articulos = DAOFactory.getInstance().getDaoclientes().getAll();
        for (int i = 0; i < articulos.size(); i++) {

            if (articulos.get(i).getCodigo().contains("1")){
                System.out.println(articulos.get(i));
            }
        }
    }
}