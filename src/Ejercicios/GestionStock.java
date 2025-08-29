package Ejercicios;

public class GestionStock {
    private int stock;


    public void agregarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a agregar debe ser positiva");
        }
        stock += cantidad;
    }


    public void reducirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a reducir debe ser positiva");
        }
        if (cantidad > stock) {
            throw new IllegalArgumentException("No hay suficiente stock disponible. Stock actual: " + stock);
        }
        stock -= cantidad;
    }



    public int getStock() {
        return stock;
    }
}