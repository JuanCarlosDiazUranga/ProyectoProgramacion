package com.juancarlosdiaz.dao.Articulos;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.juancarlosdiaz.entities.Articulo;
import com.juancarlosdiaz.entities.Data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DAOArticulosXML implements  DAOArticulos {
    private final String file = "articulos.xml";
    @Override
    public Articulo exists(String codigo) {
        List<Articulo> articulos = getAll();
        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).getCodigo() == codigo){
                Articulo poisibleArticulo = articulos.get(i);
                return poisibleArticulo;
            }
            else {
                return null;
            }
        }
        return null;
    }
    private void save(List<Articulo> articulos){
        Data dataContainer = new Data(articulos);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(file), dataContainer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String crear(Articulo articulo) {
        List<Articulo> articulos=getAll();
        articulos.add(articulo);
        save(articulos);
        return articulo.getCodigo();
    }

    @Override
    public void eliminar(String codigo, Articulo articulo) {
        List<Articulo> articulos = getAll();
        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).getCodigo() == codigo) {
                articulos.remove(articulo);
                save(articulos);

            }
        }
    }

    @Override
    public List<Articulo> getAll() {
        Data data = new Data(null);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = new String(Files.readAllBytes(Path.of(file)));
            data = xmlMapper.readValue(xml, Data.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.getArticulos();
    }
}