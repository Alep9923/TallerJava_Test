package Test;


import Ejercicios.CarritoCompras;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarritoTest {
    private CarritoCompras carrito;

    @Before
    public void setUp(){
        this.carrito = new CarritoCompras();
    }

    @Test
    public void testCarritoRecienCreadoEstaVacio() {
        assertTrue(carrito.estaVacio());
//      assertEquals(0, carrito.getCantidadProductos());
    }

    @Test
    public void testAlAgregarUnProductoDejaDeEstarVacio() {
        carrito.agregarProducto("Libro");
        assertFalse(carrito.estaVacio());
//      assertEquals(1, carrito1.getCantidadProductos());
    }

    @Test
    public void testAlAgregarVariosProductosCantidadEsperada() {
        carrito.agregarProducto("Libro");
        carrito.agregarProducto("Mouse");
        carrito.agregarProducto("Teclado");
        assertEquals(3, carrito.getCantidadProductos());
    }
}