package com.sebastian.listacompras.models;

import com.sebastian.listacompras.dto.ProductoDTO;

public class Producto {
    private String lista;
    private String codigo;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private int precio;
    private boolean comprado;

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public void crearModel(String nombre, ProductoDTO productoDTO){
        this.setLista(nombre);
        this.setCodigo(productoDTO.getCodigo());
        this.setNombre(productoDTO.getNombre());
        this.setDescripcion(productoDTO.getDescripcion());
        this.setCantidad(productoDTO.getCantidad());
        this.setPrecio(productoDTO.getPrecio());
        this.setComprado(productoDTO.isComprado());
    }

    public Producto(){
        
    }

}
