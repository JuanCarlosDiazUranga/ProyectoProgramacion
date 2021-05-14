package com.juancarlosdiaz.gui.articulos;

import com.juancarlosdiaz.entities.Articulo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static javax.swing.JOptionPane.*;

public class GUIListaArticulos extends JFrame{
    private JButton borrarbutton;
    private JButton salirbutton;
    private JPanel root;
    private JPanel jpanel;
    private JLabel codigo;
    private JLabel precio;
    private JLabel informacion;


    public GUIListaArticulos(List<Articulo> articulos){
        setSize(400,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(root);
        jpanel.setLayout(new BoxLayout(jpanel,BoxLayout.Y_AXIS));
        listadoarticulos(articulos);
        UIManager.put("OptionPane.yesButtonText", "Si");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");

    }


    private void listadoarticulos(List<Articulo> articulos) {
        for (int i = 0; i < articulos.size(); i++) {
            Articulo articulo = articulos.get(i);
            JLabel codigo = new JLabel(articulo.getCodigo());
            JLabel precio = new JLabel(String.valueOf(articulos.get(i).getPrecio()));
            JCheckBox borrarcheak = new JCheckBox();

            JButton informacion = new JButton("Informacion");
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

            panel.add(codigo);
            panel.add(precio);
            panel.add(borrarcheak);

            panel.add(informacion);
            jpanel.add(panel);


            informacion.addActionListener(e -> {
              JOptionPane.showMessageDialog(this, informacionMostrar((articulo) ), "ALERTA", PLAIN_MESSAGE);
            });


            borrarbutton.addActionListener(e -> {
                if (borrarcheak.isSelected()) {
                    articulos.remove(articulo);
                    dispose();
                    GUIListaArticulos guiListaArticulos = new GUIListaArticulos(articulos);
                    guiListaArticulos.setVisible(true);
                    System.out.println(articulos.toString());
                }
            });
        }






            salirbutton.addActionListener(e2 -> {
                int input = showConfirmDialog(this, "¿Seguro que quieres salir?", "Seleccione Opcion", YES_NO_OPTION);
                if (input == YES_OPTION) {
                    dispose();

                }



            });


        }


    public String informacionMostrar(Articulo articulo){
        return "Codigo: " + articulo.getPrecio() + "\n" +
                "Requisito: " +articulo.getPrecio()+ "\n"+
                "categoria"+ articulo.getCategoria();
    }

}
