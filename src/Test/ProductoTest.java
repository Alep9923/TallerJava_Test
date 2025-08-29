package Test;

import Ejercicios.Producto;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProductoTest {

    private Producto producto;

    @Before
    public void setUp() {
        producto = new Producto("Laptop", 1000.0, 0);
    }

    @Test
    public void testProductoSinDescuento() {
        assertEquals(1000.0, producto.calcularPrecioFinal(), 0.001);
    }

    @Test
    public void testProductoCon10PorcientoDeDescuento() {
        producto = new Producto("Smartphone", 500.0, 10);
        assertEquals(450.0, producto.calcularPrecioFinal(), 0.001);
    }

    @Test
    public void testProductoCon50PorcientoDeDescuento() {
        producto = new Producto("Teclado", 100.0, 50);
        assertEquals(50.0, producto.calcularPrecioFinal(), 0.001);
    }
}