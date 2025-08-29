package Ejercicios;



import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    private final List<String> productos = new ArrayList<>();

    public void agregarProducto(String producto){
        productos.add(producto);
    }

    public boolean estaVacio(){
        return productos.isEmpty();
    }

    public int getCantidadProductos(){
        return productos.size();
    }

}