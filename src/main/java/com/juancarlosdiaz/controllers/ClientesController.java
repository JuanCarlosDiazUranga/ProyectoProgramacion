package com.juancarlosdiaz.controllers;

import com.juancarlosdiaz.dao.DAOFactory;
import com.juancarlosdiaz.entities.Articulo;
import com.juancarlosdiaz.entities.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class ClientesController {
    @GetMapping("/DosArticulos")
    public String readUsers(Model model) {
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(DAOFactory.getInstance().getDaoclientes().getAll().get(0));
        articulos.add(DAOFactory.getInstance().getDaoclientes().getAll().get(1));
        model.addAttribute("articulos", articulos);
        return "articulos";
    }

    @GetMapping("/ArticulosConDosCategorias")
    public String readUser(Model model) {
        List<Articulo> articulos = DAOFactory.getInstance().getDaoclientes().getAll();
        List<Articulo> articuloaPasar = new ArrayList<>();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategoria();
            if (categorias.size() >= 2) {
                articuloaPasar.add(articulos.get(i));
            }
        }
        model.addAttribute("articulos", articuloaPasar);
        return "articulos";
    }

    @GetMapping("/CategoriaCine")
    public void categoriacine(Model model) {
        List<Articulo> articulos = DAOFactory.getInstance().getDaoclientes().getAll();
        List<Articulo> articuloaPasar = new ArrayList<>();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getCategoria();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).getNombre().contains("cine")) {
                    articuloaPasar.add(articulos.get(i));
                }
            }
        }
    }
}
