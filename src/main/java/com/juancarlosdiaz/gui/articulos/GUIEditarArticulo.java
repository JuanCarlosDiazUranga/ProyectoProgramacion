package com.juancarlosdiaz.gui.articulos;

import com.juancarlosdiaz.entities.Articulo;

import javax.swing.*;

public class GUIEditarArticulo  extends JFrame{


    private JPanel root;
    private JTextField inputCodigo;
    private JTextField inputPrecio;
    private JButton cambiarButton;
    private JButton salirButton;

    public GUIEditarArticulo(Articulo articulo){
        setSize(400,400);
        inputCodigo.setText(String.valueOf(articulo.getCodigo()));
        inputPrecio.setText(String.valueOf(articulo.getPrecio()));
        UIManager.put("OptionPane.yesButtonText", "Si");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(root);
        this.setHandlers();


    }


    private void setHandlers() {
        cambiarButton.addActionListener(e -> {
            int input = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres guardarlo?", "Seleccione Opcion", JOptionPane.YES_NO_CANCEL_OPTION);
            dispose();
            System.out.println(input);
        });
        salirButton.addActionListener(e1 -> {
            int input = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres salir?", "Seleccione Opcion", JOptionPane.YES_NO_OPTION);
            if (input == JOptionPane.YES_OPTION) {
                dispose();
            }
            System.out.println(input);
        });
    }
}
