package com.juancarlosdiaz;


import com.juancarlosdiaz.dao.DAOFactory;
import com.juancarlosdiaz.dao.Source;
import com.juancarlosdiaz.entities.Articulo;
import com.juancarlosdiaz.gui.articulos.GUICrearArticulo;
import com.juancarlosdiaz.gui.articulos.GUIEditarArticulo;
import com.juancarlosdiaz.gui.articulos.GUIListaArticulos;
import com.juancarlosdiaz.gui.articulos.GUIMuestraArticulo;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("elige una opcion");
        Scanner scanner = new Scanner(System.in);
        String opcion = scanner.nextLine();
        if(opcion.equals("1")){
            GUICrearArticulo guiCrearArticulo = new GUICrearArticulo();
            guiCrearArticulo.setVisible(true);
        }
        if (opcion.equals("2")){
            List<Articulo> articuloList= DAOFactory.getInstance().getDAOarticulos(Source.SQL).getAll();
            GUIListaArticulos guiListaArticulos= new GUIListaArticulos(articuloList);
            guiListaArticulos.setVisible(true);
        }
        if (opcion.equals("3")){
            Articulo articulo=  new Articulo("1",12314f,null);
            GUIMuestraArticulo guiMuestraArticulo =new GUIMuestraArticulo(articulo);
            guiMuestraArticulo.setVisible(true);
        }
        if (opcion.equals("4")){
            Articulo articulo=  new Articulo("1",12314f,null);
            GUIEditarArticulo guiEditarArticulo=new GUIEditarArticulo(articulo);
            guiEditarArticulo.setVisible(true);
        }
    }
}
