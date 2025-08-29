package Ejercicios;

public class Producto {

    private String nombre;
    private double precioBase;
    private double descuento;

    public Producto(String nombre, double precioBase, double descuento) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.descuento = descuento;
    }

    public double calcularPrecioFinal() {
        return precioBase * (1 - (descuento / 100));
    }
}

