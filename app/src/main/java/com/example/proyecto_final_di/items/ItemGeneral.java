package com.example.proyecto_final_di.items;

public class ItemGeneral {

    int img;
    String nombre;
    double precio;
    String moneda = "€";

    public ItemGeneral(int img, String nombre, double precio) {
        this.img = img;
        this.nombre = nombre;
        this.precio = precio;
        this.moneda = "€";
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMoneda() {
        return moneda;
    }
}
