package com.juancarlosdiaz.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class ClientesController {
    /*
    @GetMapping("/DosArticulos")
    public String readUsers(Model model) {
        List<Articulo> articulos = new ArrayList<>();
        articulos.add(DAOFactory.getInstance().getDAOarticulos().getAll().get(0));
        articulos.add(DAOFactory.getInstance().getDAOarticulos().getAll().get(1));
        model.addAttribute("articulos", articulos);
        return "articulos";
    }

    @GetMapping("/ArticulosConDosCategorias")
    public String readUser(Model model) {
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        List<Articulo> articuloaPasar = new ArrayList<>();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getListaCategoria();
            if (categorias.size() >= 2) {
                articuloaPasar.add(articulos.get(i));
            }
        }
        model.addAttribute("articulos", articuloaPasar);
        return "articulos";
    }

    @GetMapping("/CategoriaCine")
    public void categoriacine(Model model) {
        List<Articulo> articulos = DAOFactory.getInstance().getDAOarticulos().getAll();
        List<Articulo> articuloaPasar = new ArrayList<>();
        for (int i = 0; i < articulos.size(); i++) {
            List<Categoria> categorias = articulos.get(i).getListaCategoria();
            for (int j = 0; j < categorias.size(); j++) {
                if (categorias.get(j).equals(Categoria.categoria1)){
                    articuloaPasar.add(articulos.get(i));
                }
            }
        }
    }
}

     */
    }
