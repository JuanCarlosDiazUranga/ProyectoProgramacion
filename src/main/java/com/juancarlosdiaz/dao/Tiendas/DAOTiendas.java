package com.juancarlosdiaz.dao.Tiendas;


import com.juancarlosdiaz.entities.Articulo;

import java.util.List;

public class DAOTiendas implements DAOTienda{

    List<Tienda> tiendas;

    /**
     *
     * @param tienda dando como parametro una tienda de tipo tienda te agrega esa tienda a una lista de tiendas
     */

    @Override
    public void nuevo(Tienda tienda) {
        tiendas.add(tienda);
    }

    /**
     *
     * @param id poniendo como parametro el id te dara de baja ese id si es que esta y si no te lanza un mensaje
     */

    @Override
    public void baja(String id) {
        int indexTienda = -1;
        for (int i = 0; i < tiendas.size(); i++) {
            Tienda actual=tiendas.get(i);
            if (actual.getId().equals(id)){
                indexTienda = i;
                break;
            }

        }
        if(indexTienda>=0) {
            tiendas.remove(indexTienda);
        }
        else {
            System.out.println("No existe ningúna tienda con este id :"+id);
        }
    }

    /**
     *
     * @return te devuelve un listado de tiendas
     */
    @Override
    public List<Tienda> tiendas() {
        return tiendas;
    }

    /**
     *
     * @param tienda pasando una tienda de tipo tienda
     * @return me devuelven los articulos de la tienda
     */

    @Override
    public List<Articulo> articulos(Tienda tienda) {
        return tienda.getArticulos();
    }


}


