package com.juancarlosdiaz.dao.Tiendas;


import com.juancarlosdiaz.entities.Articulo;
import com.juancarlosdiaz.entities.Tienda;

import java.util.List;
/**
 * aqui se especifica algunas de las funciones que tendran las tiendas se podran agregas nuevas tiendas , se podran dar de baja , almacenaran una lista con todas las tiendas y otra con la lista de articulos que tiene cada tienda
 */
public interface DAOTienda {
    public void nuevo(Tienda tienda);
    public void baja(String id);
    public List<Tienda> tiendas();
    public List<Articulo> articulos(Tienda tienda);

}
