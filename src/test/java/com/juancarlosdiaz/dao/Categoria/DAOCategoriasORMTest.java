package com.juancarlosdiaz.dao.Categoria;

import com.juancarlosdiaz.dao.DAOFactory;
import com.juancarlosdiaz.entities.Categoria;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOCategoriasORMTest {
    @BeforeAll
    @AfterAll
    static void clearDatabase(){
        DAOFactory.getInstance().getDaoCategorias().clear();
    }

    @Test
    void addCategoria(){
        Categoria expected = new Categoria("CINEss");
        DAOFactory.getInstance().getDaoCategorias().add(expected);
        Categoria patrocinador = DAOFactory.getInstance().getDaoCategorias().get(expected.getNombre());
        assertEquals(expected.getNombre(), patrocinador.getNombre());
    }

    @Test
    public void insertarYExtraer(){
        Categoria categoriaEsperada = new Categoria("tv");
        List<Categoria> categorias = DAOFactory.getInstance().getDaoCategorias().list();
        DAOFactory.getInstance().getDaoCategorias().add(categoriaEsperada);
        Categoria obtenido = DAOFactory.getInstance().getDaoCategorias().get(categorias.get(categorias.size()-1).getNombre());
        assertEquals(categorias.get(categorias.size()-1).getNombre(),obtenido.getNombre());
    }

    @Test
    public void todasCategorias(){
        DAOFactory.getInstance().getDaoCategorias().clear();
        Categoria categoriaEsperada = new Categoria("pepe");
        DAOFactory.getInstance().getDaoCategorias().add(categoriaEsperada);
        List<Categoria> categorias = DAOFactory.getInstance().getDaoCategorias().list();
        int tamañoEsperado = 1;
        assertEquals(tamañoEsperado,categorias.size());
    }



    @Test
    public void actualizaCategoria(){
        Categoria categoria = new Categoria("cine");
        DAOFactory.getInstance().getDaoCategorias().add(categoria);
        List<Categoria> categorias = DAOFactory.getInstance().getDaoCategorias().list();
        Categoria categoria1 = new Categoria(categorias.get(categorias.size()-1).getNombre());
        DAOFactory.getInstance().getDaoCategorias().update(categoria1);
        Categoria categoriaesperada = DAOFactory.getInstance().getDaoCategorias().get(categorias.get(categorias.size()-1).getNombre());
        assertEquals(categoria1.getNombre(),categoriaesperada.getNombre());
    }


    @Test
    public void borrarCategoria(){
        Categoria categoriaesperada = new Categoria("juan");
        DAOFactory.getInstance().getDaoCategorias().add(categoriaesperada);
        DAOFactory.getInstance().getDaoCategorias().eliminarCategoria("juan");
        Categoria categoria = DAOFactory.getInstance().getDaoCategorias().get("juan");
        assertEquals(categoria,null);
    }
}