package com.juancarlosdiaz.dao.Clientes;


import com.juancarlosdiaz.entities.Articulo;
import com.juancarlosdiaz.entities.Cliente;

import java.util.List;

public class DAOCliente implements DAOClientes{


    @Override
    public List<Articulo> deseos(Cliente cliente) {
        return cliente.getDeseos();
    }



    @Override
    public List<Articulo> comprados(Cliente cliente) {
        return  cliente.getComprados();
    }

    @Override
    public List<Articulo> carrito(Cliente cliente) {
        return cliente.getCarrito();
    }

    @Override
    public Boolean exists(String email) {
        return null;
    }

    @Override
    public Boolean alta(Cliente cliente) {
        return null;
    }

    @Override
    public Boolean baja(Cliente cliente) {
        return null;
    }


}
