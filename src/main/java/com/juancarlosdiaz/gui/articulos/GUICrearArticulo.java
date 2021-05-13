package com.juancarlosdiaz.gui.articulos;

import com.juancarlosdiaz.dao.DAOFactory;
import com.juancarlosdiaz.dao.Source;
import com.juancarlosdiaz.entities.Articulo;

import javax.swing.*;

public class GUICrearArticulo  extends  JFrame{
    private JPanel root;
    private JTextField inputCodigo;
    private JTextField inputPrecio;
    private JButton salirButton;
    Articulo articulo = null;
    private JButton publicarArticuloButton;

    public GUICrearArticulo(){
        setSize(400,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(root);
        UIManager.put("OptionPane.yesButtonText", "Si");
        UIManager.put("OptionPane.noButtonText", "No");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        this.setHandlers();


    }


    private GUICrearArticulo setHandlers(){
        publicarArticuloButton.addActionListener(e->{
            DAOFactory.getInstance().getDAOarticulos(Source.SQL).crear(buildArticulo());
        });
        salirButton.addActionListener(e1 -> {
            int input = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres salir?", "Seleccione Opcion", JOptionPane.YES_NO_OPTION);
            if (input == JOptionPane.YES_OPTION) {
                dispose();
            }
            System.out.println(input);
        });
        return null;
    }


    private Articulo buildArticulo(){
        try {
            String codigo = inputCodigo.getText();
            float precio = Float.parseFloat(inputPrecio.getText());

            articulo = new Articulo(codigo,precio,null);
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,
                    "Error al crear la articulo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            inputPrecio.setText(null);
            inputCodigo.setText(null);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return articulo;
    }
}
