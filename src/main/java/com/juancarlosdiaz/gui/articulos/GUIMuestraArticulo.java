package com.juancarlosdiaz.gui.articulos;

import com.juancarlosdiaz.entities.Articulo;

import javax.swing.*;

public class GUIMuestraArticulo extends  JFrame{
    private JTextField inputCodigo;
    private JTextField inputPrecio;
    private JPanel root;

        public GUIMuestraArticulo(Articulo articulo){
            setSize(400,400);
            inputCodigo.setText(String.valueOf(articulo.getCodigo()));
            inputPrecio.setText(String.valueOf(articulo.getPrecio()));
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.add(root);
        }
    }

