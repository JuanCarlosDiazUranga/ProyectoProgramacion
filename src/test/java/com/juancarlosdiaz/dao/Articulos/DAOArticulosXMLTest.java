package com.juancarlosdiaz.dao.Articulos;

import com.juancarlosdiaz.dao.DAOFactory;
import com.juancarlosdiaz.dao.Source;
import com.juancarlosdiaz.entities.Articulo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOArticulosXMLTest {
    @AfterEach
    private void clearDatabase () {
        DAOFactory.getInstance().getDAOarticulos(Source.XML).clear();
    }

    @Test
    public void insertarYExtraer () {
        Articulo articuloEsperado = new Articulo("1", 47457f,null);
        DAOFactory.getInstance().getDAOarticulos(Source.XML).crear(articuloEsperado);
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.XML).getAll();
        assertEquals(articuloEsperado.getCodigo(), articulos.get(articulos.size() - 1).getCodigo());
    }

    @Test
    public void todasEmpresas () {
        Articulo articuloEsperado = new Articulo("2", 47457f,null);
        DAOFactory.getInstance().getDAOarticulos(Source.XML).crear(articuloEsperado);
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.XML).getAll();
        int tamañoEsperado = 1;
        assertEquals(tamañoEsperado, articulos.size());
    }

    @Test
    public void borrarEmpresa () {
        Articulo articuloEsperado = new Articulo("3", 47457f,null);
        DAOFactory.getInstance().getDAOarticulos(Source.XML).crear(articuloEsperado);
        DAOFactory.getInstance().getDAOarticulos(Source.XML).clear();
        List<Articulo> articulosObtenidos = DAOFactory.getInstance().getDAOarticulos(Source.XML).getAll();
        List<Articulo> articulosEsperados = new ArrayList<>();
        assertEquals(articulosEsperados.size(), articulosObtenidos.size());
    }
}