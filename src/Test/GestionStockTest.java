package Test;

import Ejercicios.GestionStock;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.IllegalArgumentException;


public class GestionStockTest {

    private GestionStock gestionStock;

    @Before
    public void setUp() {
        gestionStock = new GestionStock();
    }

    // Test 1: Aumentar stock funciona
    @Test
    public void testAgregarStock_AumentaStockCorrectamente() {
        // Verificar stock inicial
        assertEquals("El stock inicial debe ser 0", 0, gestionStock.getStock());

        // Agregar stock
        gestionStock.agregarStock(50);
        assertEquals("Después de agregar 50 unidades", 50, gestionStock.getStock());

        // Agregar más stock
        gestionStock.agregarStock(30);
        assertEquals("Después de agregar 30 unidades más", 80, gestionStock.getStock());
    }

    // Test 2: Reducir stock válido funciona
    @Test
    public void testReducirStock_Valido_ReduceStockCorrectamente() {
        // Preparar stock inicial
        gestionStock.agregarStock(100);
        assertEquals("Stock inicial preparado", 100, gestionStock.getStock());

        // Reducir stock válido
        gestionStock.reducirStock(40);
        assertEquals("Después de reducir 40 unidades", 60, gestionStock.getStock());

        // Reducir más stock
        gestionStock.reducirStock(20);
        assertEquals("Después de reducir 20 unidades más", 40, gestionStock.getStock());
    }

    // Test 3: Reducir stock mayor al disponible lanza excepción
    @Test(expected = IllegalArgumentException.class)
    public void testReducirStock_Invalido_LanzaExcepcion() {
        // Preparar stock inicial
        gestionStock.agregarStock(50);

        // Intentar reducir más stock del disponible - debe lanzar excepción
        gestionStock.reducirStock(60);
    }

    // Test adicional: Verificar el mensaje de la excepción
    @Test
    public void testReducirStock_Invalido_VerificaMensajeExcepcion() {
        // Preparar stock inicial
        gestionStock.agregarStock(50);

        try {
            gestionStock.reducirStock(60);
            fail("Debería haber lanzado una excepción");
        } catch (IllegalArgumentException e) {
            assertEquals("Mensaje de excepción incorrecto",
                    "No hay suficiente stock disponible. Stock actual: 50",
                    e.getMessage());
            // Verificar que el stock no cambió
            assertEquals("El stock no debería cambiar después de excepción", 50, gestionStock.getStock());
        }
    }

    // Test adicional: Agregar cantidad negativa lanza excepción
    @Test(expected = IllegalArgumentException.class)
    public void testAgregarStock_CantidadNegativa_LanzaExcepcion() {
        gestionStock.agregarStock(-10);
    }

    // Test adicional: Reducir cantidad negativa lanza excepción
    @Test(expected = IllegalArgumentException.class)
    public void testReducirStock_CantidadNegativa_LanzaExcepcion() {
        gestionStock.agregarStock(50);
        gestionStock.reducirStock(-5);
    }

    // Test adicional: Agregar cantidad cero lanza excepción
    @Test(expected = IllegalArgumentException.class)
    public void testAgregarStock_CantidadCero_LanzaExcepcion() {
        gestionStock.agregarStock(0);
    }

    // Test adicional: Reducir cantidad cero lanza excepción
    @Test(expected = IllegalArgumentException.class)
    public void testReducirStock_CantidadCero_LanzaExcepcion() {
        gestionStock.agregarStock(50);
        gestionStock.reducirStock(0);
    }

    // Test adicional: Múltiples operaciones combinadas
    @Test
    public void testOperacionesCombinadas() {
        // Operaciones secuenciales
        gestionStock.agregarStock(100);
        gestionStock.reducirStock(30);
        gestionStock.agregarStock(50);
        gestionStock.reducirStock(20);

        assertEquals("Stock después de operaciones combinadas", 100, gestionStock.getStock());
    }
}