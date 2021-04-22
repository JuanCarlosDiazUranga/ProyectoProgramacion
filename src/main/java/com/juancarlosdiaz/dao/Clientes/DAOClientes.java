package com.juancarlosdiaz.dao.Clientes;

import java.util.List;

import com.juancarlosdiaz.entities.Articulo;
import com.juancarlosdiaz.entities.Cliente;


public interface DAOClientes {
    public List<Articulo> deseos(Cliente cliente);
    public  List<Articulo> comprados(Cliente cliente);
    public List<Articulo> carrito(Cliente cliente);
    public Boolean exists(String email);
    public Boolean alta(Cliente cliente);
    public Boolean baja(Cliente cliente);


}

