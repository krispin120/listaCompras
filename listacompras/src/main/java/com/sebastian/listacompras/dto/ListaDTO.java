package com.sebastian.listacompras.dto;

import java.util.*;

public class ListaDTO {
    private String nombre;
    private List<ProductoDTO> productos;
    private int pagado;
    private int resto;
    private int total;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setPagado(int pagado) {
        this.pagado = pagado;
    }

    public int getPagado() {
        return pagado;
    }

    public void setResto(int resto) {
        this.resto = resto;
    }

    public int getResto() {
        return resto;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public ListaDTO(){

    }
    
}
