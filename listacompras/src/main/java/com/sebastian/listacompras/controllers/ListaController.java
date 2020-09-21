package com.sebastian.listacompras.controllers;

import java.sql.*;
import java.util.*;

import com.sebastian.listacompras.Inicializador;
import com.sebastian.listacompras.dao.*;
import com.sebastian.listacompras.db.BaseDeDatos;
import com.sebastian.listacompras.dto.*;
import com.sebastian.listacompras.models.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListaController {
    
	@Autowired
    Inicializador inicializador;
    
	@Autowired
    ProductoDAO productoDAO;
    
    @Autowired
    BaseDeDatos baseDeDatos;

    @PostMapping ("/listas/{nombre}/productos/agregar")
    public void agregarProducto(@PathVariable String nombre, @RequestBody ProductoDTO productoDTO) throws Exception{

        Connection conn = baseDeDatos.connect();

        Producto producto = new Producto();

        producto.crearModel(nombre, productoDTO);

        productoDAO.agregarProducto(conn, producto);

        inicializador.cargarMisListasDeCompra(productoDAO.consultarProductos(conn));

        conn.close();
    }

    @PostMapping ("/listas/{nombre}/productos/eliminar")
    public void eliminarProducto(@PathVariable String nombre, @RequestBody ProductoDTO productoDTO) throws Exception{
        Connection conn = baseDeDatos.connect();

        Producto producto = new Producto();

        producto.crearModel(nombre, productoDTO);

        productoDAO.eliminarProducto(conn, producto);

        inicializador.cargarMisListasDeCompra(productoDAO.consultarProductos(conn));

        conn.close();
    }

    @PostMapping ("/listas/{nombre}/productos/comprado")
    public void comprarProducto(@PathVariable String nombre, @RequestBody ProductoDTO productoDTO) throws Exception{
        Connection conn = baseDeDatos.connect();

        Producto producto = new Producto();

        producto.crearModel(nombre, productoDTO);

        producto.setComprado(true);

        productoDAO.actualizarProducto(conn, producto);

        inicializador.cargarMisListasDeCompra(productoDAO.consultarProductos(conn));

        conn.close();
    }

    @GetMapping ("/listas/consultar")
    public List<ListaDTO> consultarMisListas(){
        return inicializador.getMisListasDeCompra();
    }

    @GetMapping ("/listas/{nombre}/consultar")
    public ListaDTO consultarLista(@PathVariable String nombre) throws RuntimeException{
        for (ListaDTO listaDTO : inicializador.getMisListasDeCompra()){
            if (listaDTO.getNombre().matches(nombre)){
                return listaDTO;
            }
        }
        throw new RuntimeException("no existe");
    }

    @PostMapping ("/listas/{nombre}/eliminar")
    public void eliminarLista(@PathVariable String nombre) throws Exception{
        Connection conn = baseDeDatos.connect();

        productoDAO.eliminarLista(conn, nombre);

        inicializador.cargarMisListasDeCompra(productoDAO.consultarProductos(conn));

        conn.close();
    }




}
