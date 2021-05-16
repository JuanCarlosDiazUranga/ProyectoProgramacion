package com.juancarlosdiaz.dao.Articulos;

import com.juancarlosdiaz.dao.DAOFactory;
import com.juancarlosdiaz.dao.Source;
import com.juancarlosdiaz.entities.Articulo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOArticulosXMLTest {
    @AfterEach
    @BeforeEach
    private void clearDatabase () {

        DAOFactory.getInstance().getDAOarticulos(Source.XML).clear();

    }

    @Test
    public void insertarYExtraer() {
        Articulo articuloEsperado = new Articulo("12314", 474.50f, null);
        DAOFactory.getInstance().getDAOarticulos(Source.XML).crear(articuloEsperado);
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.XML).getAll();
         assertEquals(articuloEsperado.getCodigo(), articulos.get(articulos.size() -1).getCodigo());
    }
    @Test
    public void todosArticulos () {
        Articulo articuloEsperado = new Articulo("2", 474.50f,null);

        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.XML).getAll();
        DAOFactory.getInstance().getDAOarticulos(Source.XML).crear(articuloEsperado);
        int tamañoEsperado = 2;
        assertEquals(tamañoEsperado, articulos.size());
    }

    @Test
    public void borrarArticulo () {
        Articulo articuloEsperado = new Articulo("3", 474.50f,null);
        DAOFactory.getInstance().getDAOarticulos(Source.XML).crear(articuloEsperado);
        DAOFactory.getInstance().getDAOarticulos(Source.XML).clear();
        List<Articulo> articulosObtenidos = DAOFactory.getInstance().getDAOarticulos(Source.XML).getAll();
        List<Articulo> articulosEsperados = new ArrayList<>();
        assertEquals(articulosEsperados.size(), articulosObtenidos.size());
    }
}

