package com.sebastian.listacompras.dto;

import com.sebastian.listacompras.models.Producto;

public class ProductoDTO {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private int precio;
    private boolean comprado;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public void crearDTO(Producto producto){
        this.setCodigo(producto.getCodigo());
        this.setNombre(producto.getNombre());
        this.setDescripcion(producto.getDescripcion());
        this.setCantidad(producto.getCantidad());
        this.setPrecio(producto.getPrecio());
        this.setComprado(producto.isComprado());
    }

    public ProductoDTO(){
        
    }
}
