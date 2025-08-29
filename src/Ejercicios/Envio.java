package Ejercicios;


public class Envio {

    public double calcularCosto(double peso) {
        if (peso <= 5) {
            return 10.0;
        } else if (peso > 5 && peso <= 20) {
            return 25.0;
        } else {
            return 50.0;
        }
    }
}

