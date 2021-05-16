package com.juancarlosdiaz.dao.Articulos;

import com.juancarlosdiaz.dao.DAOFactory;
import com.juancarlosdiaz.dao.Source;
import com.juancarlosdiaz.entities.Articulo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOArticulosORMTest {
    @BeforeAll
    @AfterAll
    static void clearDatabase(){
        DAOFactory.getInstance().getDAOarticulos(Source.ORM).clear();
    }

    @Test
    void addCampeonato(){
        Articulo expected = new Articulo("1",123F,null);
        DAOFactory.getInstance().getDAOarticulos(Source.ORM).crear(expected);
        Articulo articulo = DAOFactory.getInstance().getDAOarticulos(Source.ORM).exists(expected.getCodigo());
        assertEquals(expected.getCodigo(), articulo.getCodigo());

    }

    @Test
    public void insertarYExtraer(){
        Articulo articuloEsperado = new Articulo("2",4566F,null);
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.ORM).getAll();
        DAOFactory.getInstance().getDAOarticulos(Source.ORM).crear(articuloEsperado);
        Articulo obtenida = DAOFactory.getInstance().getDAOarticulos(Source.ORM).exists(articulos.get(articulos.size()-1).getCodigo());
        assertEquals(articulos.get(articulos.size()-1).getCodigo(),obtenida.getCodigo());
    }

    @Test
    public void todosCampeonatos(){
        DAOFactory.getInstance().getDAOarticulos(Source.ORM).clear();
        Articulo articuloEsperado = new Articulo("3",1234F,null);
        DAOFactory.getInstance().getDAOarticulos(Source.ORM).crear(articuloEsperado);
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.ORM).getAll();
        int tamañoEsperado = 1;
        assertEquals(tamañoEsperado,articulos.size());
    }



    @Test
    public void actualizaCampeonato(){
        Articulo articulo = new Articulo("4",123312f,null);
        DAOFactory.getInstance().getDAOarticulos(Source.ORM).crear(articulo);
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.ORM).getAll();
        Articulo articulo1 = new Articulo(articulos.get(articulos.size()-1).getCodigo(),123f,null);
        DAOFactory.getInstance().getDAOarticulos(Source.ORM).actualizarArticulo(articulo1);
        Articulo articuloEsperado = DAOFactory.getInstance().getDAOarticulos(Source.ORM).exists(articulos.get(articulos.size()-1).getCodigo());
        assertEquals(articulo1.getCodigo(),articuloEsperado.getCodigo());
    }


    @Test
    public void borrarCampeonato(){
        Articulo articuloEsperado = new Articulo("5",1233F,null);
        DAOFactory.getInstance().getDAOarticulos(Source.ORM).crear(articuloEsperado);
        DAOFactory.getInstance().getDAOarticulos(Source.ORM).eliminar("5");
        Articulo articulo = DAOFactory.getInstance().getDAOarticulos(Source.ORM).exists("5");
        assertEquals(articulo,null);
    }

}