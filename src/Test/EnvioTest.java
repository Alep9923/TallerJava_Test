package Test;

import Ejercicios.Envio;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EnvioTest {

    private Envio envio;

    @Before
    public void setUp() {
        envio = new Envio();
    }

    @Test
    public void testCostoEnvioHasta5kg() {
        double costo = envio.calcularCosto(3.0);
        assertEquals(10.0, costo, 0.001);
    }

    @Test
    public void testCostoEnvioEntre5y20kg() {
        double costo = envio.calcularCosto(10.0);
        assertEquals(25.0, costo, 0.001);
    }

    @Test
    public void testCostoEnvioMayor20kg() {
        double costo = envio.calcularCosto(25.0);
        assertEquals(50.0, costo, 0.001);
    }
}