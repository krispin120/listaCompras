package com.sebastian.listacompras.dao;

import java.sql.*;
import java.util.*;

import com.sebastian.listacompras.models.Producto;

import org.springframework.stereotype.*;

@Repository
public class ProductoDAO {
    
    public void agregarProducto(Connection conn, Producto prod) throws Exception{
        String query = "INSERT INTO Productos " +
        "(lista, codigo, nombre, descripcion, cantidad, precio, comprado) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        
        stmt.setString(1, prod.getLista());
        stmt.setString(2, prod.getCodigo());
        stmt.setString(3, prod.getNombre());
        stmt.setString(4, prod.getDescripcion());
        stmt.setInt(5, prod.getCantidad());
        stmt.setInt(6, prod.getPrecio());
        stmt.setBoolean(7, prod.isComprado());

        stmt.executeUpdate();

    }

    public void eliminarProducto(Connection conn, Producto producto) throws Exception{
        String query = "DELETE FROM Productos " +
        "WHERE lista = ? " +
        "AND codigo = ? ";

        PreparedStatement stmt = conn.prepareStatement(query);
        
        stmt.setString(1, producto.getLista());
        stmt.setString(2, producto.getCodigo());

        stmt.executeUpdate();

    }

    public void eliminarLista(Connection conn, String nombre) throws Exception{
        String query = "DELETE FROM Productos " +
        "WHERE lista = ? ";

        PreparedStatement stmt = conn.prepareStatement(query);
        
        stmt.setString(1, nombre);

        stmt.executeUpdate();

    }

    public List<Producto> consultarProductos(Connection conn) throws Exception{
        String query = "SELECT lista, codigo, nombre, descripcion, cantidad, precio, comprado FROM Productos";
        PreparedStatement stmt = conn.prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        List<Producto> retorno = new ArrayList<>();

        Producto p;

        while (rs.next()){
            p = new Producto();
            p.setLista(rs.getString("lista"));
            p.setCodigo(rs.getString("codigo"));
            p.setNombre(rs.getString("nombre"));
            p.setDescripcion(rs.getString("descripcion"));
            p.setCantidad(rs.getInt("cantidad"));
            p.setPrecio(rs.getInt("precio"));
            p.setComprado(rs.getBoolean("comprado"));

            retorno.add(p);
        }

        return retorno;
    }

    public void actualizarProducto(Connection conn, Producto producto) throws Exception{
        String query = "UPDATE Productos " +
        "SET comprado = ?" +
        "WHERE lista = ? " +
        "AND codigo = ? ";

        PreparedStatement stmt = conn.prepareStatement(query);
        
        stmt.setBoolean(1, producto.isComprado());
        stmt.setString(2, producto.getLista());
        stmt.setString(3, producto.getCodigo());

        stmt.executeUpdate();

    }
}
