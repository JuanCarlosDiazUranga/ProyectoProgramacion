package com.juancarlosdiaz.dao.Articulos;

import com.juancarlosdiaz.dao.DAOFactory;
import com.juancarlosdiaz.dao.Source;
import com.juancarlosdiaz.entities.Articulo;
import com.juancarlosdiaz.entities.Categoria;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOArticulosSQLTest {
    @BeforeAll
    @AfterAll
    static void clearDatabase() { DAOFactory.getInstance().getDAOarticulos(Source.SQL).clear(); }


    @Test
    public void insertarYExtraer(){
        Articulo articuloEsperado = new Articulo("1", 800.00F,null);
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).crear(articuloEsperado);
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.SQL).getAll();
        Articulo obtenido = DAOFactory.getInstance().getDAOarticulos(Source.SQL).exists(articulos.get(articulos.size()-1).getCodigo());
        assertEquals(articulos.get(articulos.size()-1).getCodigo(),obtenido.getCodigo());
    }

    @Test
    public void todosArticulos(){

        Articulo articuloesperado = new Articulo("1234",123.45f,null);
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).crear(articuloesperado);
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.SQL).getAll();
        int tamañoEsperado = 1;
        assertEquals(tamañoEsperado,articulos.size());

    }



    @Test
    public void actualizaArticulo(){
        Categoria categoria = new Categoria("CINEFILO");

        Articulo articulo = new Articulo("3", 800.00F,categoria);
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).crear(articulo);
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos(Source.SQL).getAll();
        Articulo articulo1 = new Articulo(articulos.get(articulos.size()-1).getCodigo(),800.00F,categoria);
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).actualizarArticulo(articulo1);

        Articulo articuloEsperado= DAOFactory.getInstance().getDAOarticulos(Source.SQL).exists(articulos.get(articulos.size()-1).getCodigo());
        assertEquals(articulo1.getCodigo(),articuloEsperado.getCodigo());
    }


    @Test
    public void borrarArticulo(){
        Categoria categoria = new Categoria("CINEFILO");
        Articulo articuloEsperado = new Articulo("123",123.45F,categoria);
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).crear(articuloEsperado);
        DAOFactory.getInstance().getDAOarticulos(Source.SQL).eliminar("123");
        Articulo articulo = DAOFactory.getInstance().getDAOarticulos(Source.SQL).exists("123");
        assertNull(articulo);
    }

}