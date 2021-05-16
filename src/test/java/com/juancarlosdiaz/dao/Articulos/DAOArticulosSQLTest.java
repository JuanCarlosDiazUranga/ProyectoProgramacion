package com.juancarlosdiaz.dao.Articulos;

import com.juancarlosdiaz.dao.DAOFactory;
import com.juancarlosdiaz.dao.Source;
import com.juancarlosdiaz.entities.Articulo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOArticulosSQLTest {
    @BeforeAll
    @AfterAll
    static void clearJugador(){
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).clear();
    }

    @Test
    void addJugador(){
        Articulo expected = new Articulo("1",12345F,null);
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).crear(expected);
        Articulo articulo = DAOFactory.getInstance().getDAOarticulos(Source.SQL).exists(expected.getCodigo());
        assertEquals(expected.getCodigo(), articulo.getCodigo());
    }

    @Test
    public void insertarYExtraer(){
        Articulo articuloEsperado = new Articulo("2",123145F,null);
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.SQL).getAll();
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).crear(articuloEsperado);
        Articulo obtenido = DAOFactory.getInstance().getDAOarticulos(Source.SQL).exists(articulos.get(articulos.size()-1).getCodigo());
        assertEquals(articulos.get(articulos.size()-1).getCodigo(),obtenido.getCodigo());
    }

    @Test
    public void todosArticulos(){
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).clear();
        Articulo articuloEsperado = new Articulo("3",123124F,null);
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).crear(articuloEsperado);
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.SQL).getAll();
        int tamañoEsperado = 0;
        assertEquals(tamañoEsperado,articulos.size());
    }



    @Test
    public void actualizaJugador(){
        Articulo articulo = new Articulo("4",5378345F,null);
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).crear(articulo);
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.SQL).getAll();
        Articulo articulo1 = new Articulo(articulos.get(articulos.size()-1).getCodigo(),5378345F,null);
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).actualizarArticulo(articulo1);
        Articulo articuloEsperado = DAOFactory.getInstance().getDAOarticulos(Source.SQL).exists(articulos.get(articulos.size()-1).getCodigo());
        assertEquals(articulo1.getCodigo(),articuloEsperado.getCodigo());
    }


    @Test
    public void borrarJugador(){
        Articulo articuloEsperado = new Articulo("4",5378345F,null);
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).crear(articuloEsperado);
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).eliminar("5");
        Articulo articulo = DAOFactory.getInstance().getDAOarticulos(Source.SQL).exists("5");
        assertEquals(articulo,null);
    }

}