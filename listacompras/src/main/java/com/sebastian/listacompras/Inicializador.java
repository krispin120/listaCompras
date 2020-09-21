package com.sebastian.listacompras;

import java.sql.Connection;
import java.util.*;

import javax.annotation.PostConstruct;

import com.sebastian.listacompras.dao.ProductoDAO;
import com.sebastian.listacompras.db.BaseDeDatos;
import com.sebastian.listacompras.dto.*;
import com.sebastian.listacompras.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Inicializador {
      
    @Autowired
    private BaseDeDatos baseDeDatos;

    @Autowired
    private ProductoDAO productoDAO;

    private List<ListaDTO> misListasDeCompra;

    public List<ListaDTO> getMisListasDeCompra() {
        return misListasDeCompra;
    }

    public void cargarMisListasDeCompra(List<Producto> lProductos) {
        misListasDeCompra = new ArrayList<>();
        for (Producto producto : lProductos){
            boolean existe = false;
            List<ProductoDTO> lProductoDTOs;
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.crearDTO(producto);
            int precio = productoDTO.getPrecio() * productoDTO.getCantidad();
            for (ListaDTO listaDTO : misListasDeCompra){
                if (listaDTO.getNombre().matches(producto.getLista())){
                    existe = true;

                    lProductoDTOs = listaDTO.getProductos();
                    lProductoDTOs.add(productoDTO);
                    listaDTO.setProductos(lProductoDTOs);

                    if (productoDTO.isComprado()){
                        listaDTO.setPagado(listaDTO.getPagado() + precio);
                    }else {
                        listaDTO.setResto(listaDTO.getResto() + precio);
                    }
                    listaDTO.setTotal(listaDTO.getTotal() + precio);
                }
            }
            if (!existe){//si la lista no existe, la creo
                ListaDTO listaDTO = new ListaDTO();
                listaDTO.setNombre(producto.getLista());
                lProductoDTOs = new ArrayList<>();
                lProductoDTOs.add(productoDTO);
                listaDTO.setProductos(lProductoDTOs);

                if (productoDTO.isComprado()){
                    listaDTO.setPagado(precio);
                }else {
                    listaDTO.setResto(precio);
                }
                listaDTO.setTotal(precio);
                misListasDeCompra.add(listaDTO);
            }
        }
    }

    @PostConstruct
    public void init() throws Exception{
        Connection conn = baseDeDatos.connect();
        cargarMisListasDeCompra(productoDAO.consultarProductos(conn));
        //Cargo las listas en memoria
        conn.close();
    }


}
