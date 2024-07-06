package ar.unrn.estructura;

import ar.unrn.excepciones.PosicionFueraDeLugarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test para los métodos de la clase ClientesPremium.
 */
@DisplayName("Test para métodos de la clase ClientesPremium")
class ClientesPremiumTest {

    //AGREGAR Y LARGO --------------------------------------------------------------
    @Test
    @DisplayName("ClientesPremium - Agregar y Largo - Prueba Uno")
    void testAgregarYLargoPruebaUno() {
        Cliente uno = new Cliente("Roberto", 12345678, 32);
        ClientesPremium premiums = new ClientesPremium();
        premiums.agregar(uno);
        int esperado = 1;
        int resultado = premiums.largo();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("ClientesPremium - Agregar y Largo - Prueba Dos")
    void testAgregarYLargoPruebaDos() {
        Cliente uno = new Cliente("Roberto", 12345678, 32);
        Cliente dos = new Cliente("María", 48392212, 36);
        Cliente tres = new Cliente("Patricio", 91840274, 41);
        Cliente cuatro = new Cliente("Juan", 67162309, 28);
        ClientesPremium premiums = new ClientesPremium();
        premiums.agregar(uno);
        premiums.agregar(dos);
        premiums.agregar(tres);
        premiums.agregar(cuatro);
        int esperado = 4;
        int resultado = premiums.largo();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("ClientesPremium - Agregar y Largo - Prueba Tres")
    void testAgregarYLargoPruebaTres() {
        Cliente uno = new Cliente("Roberto", 12345678, 32);
        Cliente dos = new Cliente("María", 48392212, 36);
        Cliente tres = new Cliente("Patricio", 91840274, 41);
        Cliente cuatro = new Cliente("Juan", 67162309, 28);
        ClientesPremium premiums = new ClientesPremium();
        premiums.agregar(uno);
        premiums.agregar(dos);
        int esperado = 2;
        int resultado = premiums.largo();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("ClientesPremium - Agregar y Largo - Prueba Cuatro")
    void testAgregarYLargoPruebaCuatro() {
        ClientesPremium premiums = new ClientesPremium();
        int esperado = 0;
        int resultado = premiums.largo();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    //REMOVER Y TO STRING ---------------------------------------------------------

    @Test
    @DisplayName("ClientesPremium - Remover y ToString - Prueba Uno")
    void testRemoverYToStringPruebaUno() {
        Cliente uno = new Cliente("Roberto", 12345678, 32);
        Cliente dos = new Cliente("María", 48392212, 36);
        Cliente tres = new Cliente("Patricio", 91840274, 41);
        Cliente cuatro = new Cliente("Juan", 67162309, 28);
        ClientesPremium premiums = new ClientesPremium();
        premiums.agregar(uno);
        premiums.agregar(dos);
        premiums.agregar(tres);
        premiums.agregar(cuatro);
        premiums.remover(2);
        String esperado = "([Nombre: Juan, DNI: 67162309, Edad: 28], "
                + "[Nombre: Patricio, DNI: 91840274, Edad: 41], "
                + "[Nombre: Roberto, DNI: 12345678, Edad: 32])";
        String resultado = premiums.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("ClientesPremium - Remover y ToString - Prueba Dos")
    void testRemoverYToStringPruebaDos() {
        Cliente uno = new Cliente("Roberto", 12345678, 32);
        Cliente dos = new Cliente("María", 48392212, 36);
        Cliente tres = new Cliente("Patricio", 91840274, 41);
        Cliente cuatro = new Cliente("Juan", 67162309, 28);
        ClientesPremium premiums = new ClientesPremium();
        premiums.agregar(uno);
        premiums.agregar(dos);
        premiums.agregar(tres);
        premiums.agregar(cuatro);
        premiums.remover(0);
        String esperado = "([Nombre: Patricio, DNI: 91840274, Edad: 41], "
                + "[Nombre: María, DNI: 48392212, Edad: 36], "
                + "[Nombre: Roberto, DNI: 12345678, Edad: 32])";
        String resultado = premiums.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("ClientesPremium - Remover y ToString - Prueba Tres")
    void testRemoverYToStringPruebaTres() {
        Cliente uno = new Cliente("Roberto", 12345678, 32);
        Cliente dos = new Cliente("María", 48392212, 36);
        ClientesPremium premiums = new ClientesPremium();
        premiums.agregar(uno);
        premiums.agregar(dos);
        premiums.remover(0);
        premiums.remover(0);
        String esperado = "()";
        String resultado = premiums.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("ClientesPremium - Remover y ToString - Prueba Cuatro")
    void testRemoverYToStringPruebaCuatro() {
        try {
            ClientesPremium premiums = new ClientesPremium();
            premiums.remover(0);
            Assertions.fail("Debería haber saltado error");
        } catch (PosicionFueraDeLugarException exc) {
            System.out.println("No se puede remover elementos de una lista vacía");
        }
    }

    @Test
    @DisplayName("ClientesPremium - Remover y ToString - Prueba Cinco")
    void testRemoverYToStringPruebaCinco() {
        try {
            Cliente uno = new Cliente("Roberto", 12345678, 32);
            Cliente dos = new Cliente("María", 48392212, 36);
            ClientesPremium premiums = new ClientesPremium();
            premiums.agregar(uno);
            premiums.agregar(dos);
            premiums.remover(5);
            Assertions.fail("Debería haber saltado error");
        } catch (PosicionFueraDeLugarException exc) {
            System.out.println("La posición se encuentra fuera de los límites de la "
                    + "lista");
        }
    }

    //OBTENER ----------------------------------------------------------------------

    @Test
    @DisplayName("ClientesPremium - Obtener - Prueba Uno")
    void testObtenerPruebaUno() {
        Cliente uno = new Cliente("Roberto", 12345678, 32);
        Cliente dos = new Cliente("María", 48392212, 36);
        Cliente tres = new Cliente("Patricio", 91840274, 41);
        Cliente cuatro = new Cliente("Juan", 67162309, 28);
        ClientesPremium premiums = new ClientesPremium();
        premiums.agregar(uno);
        premiums.agregar(dos);
        premiums.agregar(tres);
        premiums.agregar(cuatro);
        Cliente resultado = premiums.obtener(0);
        Assertions.assertEquals(cuatro, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("ClientesPremium - Obtener - Prueba Dos")
    void testObtenerPruebaDos() {
        Cliente uno = new Cliente("Roberto", 12345678, 32);
        Cliente dos = new Cliente("María", 48392212, 36);
        Cliente tres = new Cliente("Patricio", 91840274, 41);
        Cliente cuatro = new Cliente("Juan", 67162309, 28);
        ClientesPremium premiums = new ClientesPremium();
        premiums.agregar(uno);
        premiums.agregar(dos);
        premiums.agregar(tres);
        premiums.agregar(cuatro);
        Cliente resultado = premiums.obtener(2);
        Assertions.assertEquals(dos, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("ClientesPremium - Obtener - Prueba Tres")
    void testObtenerPruebaTres() {
        try {
            Cliente uno = new Cliente("Roberto", 12345678, 32);
            Cliente dos = new Cliente("María", 48392212, 36);
            Cliente tres = new Cliente("Patricio", 91840274, 41);
            Cliente cuatro = new Cliente("Juan", 67162309, 28);
            ClientesPremium premiums = new ClientesPremium();
            premiums.agregar(uno);
            premiums.agregar(dos);
            premiums.agregar(tres);
            premiums.agregar(cuatro);
            Cliente resultado = premiums.obtener(5);
        } catch (PosicionFueraDeLugarException exc) {
            System.out.println("La posición se encuentra fuera de los límites de la "
                    + "lista");
        }
    }

    @Test
    @DisplayName("ClientesPremium - Obtener - Prueba Cuatro")
    void testObtenerPruebaCuatro() {
        try {
            Cliente uno = new Cliente("Roberto", 12345678, 32);
            Cliente dos = new Cliente("María", 48392212, 36);
            Cliente tres = new Cliente("Patricio", 91840274, 41);
            Cliente cuatro = new Cliente("Juan", 67162309, 28);
            ClientesPremium premiums = new ClientesPremium();
            premiums.agregar(uno);
            premiums.agregar(dos);
            premiums.agregar(tres);
            premiums.agregar(cuatro);
            Cliente resultado = premiums.obtener(-1);
        } catch (PosicionFueraDeLugarException exc) {
            System.out.println("La posición se encuentra fuera de los límites de la "
                    + "lista");
        }
    }

    //VERIFICAR PREMIUM

    @Test
    @DisplayName("ClientesPremium - VerificarPremium - Prueba Uno")
    void testVerificarPremiumPruebaUno() {
        Cliente uno = new Cliente("Roberto", 12345678, 32);
        Cliente dos = new Cliente("María", 48392212, 36);
        Cliente tres = new Cliente("Patricio", 91840274, 41);
        Cliente cuatro = new Cliente("Juan", 67162309, 28);
        ClientesPremium premiums = new ClientesPremium();
        premiums.agregar(uno);
        premiums.agregar(dos);
        premiums.agregar(tres);
        premiums.agregar(cuatro);
        boolean esperado = true;
        boolean resultado = premiums.verificarPremium(12345678);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("ClientesPremium - VerificarPremium - Prueba Dos")
    void testVerificarPremiumPruebaDos() {
        Cliente uno = new Cliente("Roberto", 12345678, 32);
        Cliente dos = new Cliente("María", 48392212, 36);
        Cliente tres = new Cliente("Patricio", 91840274, 41);
        Cliente cuatro = new Cliente("Juan", 67162309, 28);
        ClientesPremium premiums = new ClientesPremium();
        premiums.agregar(uno);
        premiums.agregar(dos);
        premiums.agregar(tres);
        premiums.agregar(cuatro);
        boolean esperado = true;
        boolean resultado = premiums.verificarPremium(91840274);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("ClientesPremium - VerificarPremium - Prueba Tres")
    void testVerificarPremiumPruebaTres() {
        Cliente uno = new Cliente("Roberto", 12345678, 32);
        Cliente dos = new Cliente("María", 48392212, 36);
        Cliente tres = new Cliente("Patricio", 91840274, 41);
        Cliente cuatro = new Cliente("Juan", 67162309, 28);
        ClientesPremium premiums = new ClientesPremium();
        premiums.agregar(uno);
        premiums.agregar(dos);
        premiums.agregar(tres);
        premiums.agregar(cuatro);
        boolean esperado = false;
        boolean resultado = premiums.verificarPremium(87654321);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("ClientesPremium - VerificarPremium - Prueba Cuatro")
    void testVerificarPremiumPruebaCuatro() {
        Cliente uno = new Cliente("Roberto", 12345678, 32);
        Cliente dos = new Cliente("María", 48392212, 36);
        Cliente tres = new Cliente("Patricio", 91840274, 41);
        Cliente cuatro = new Cliente("Juan", 67162309, 28);
        ClientesPremium premiums = new ClientesPremium();
        premiums.agregar(dos);
        premiums.agregar(tres);
        premiums.agregar(cuatro);
        boolean esperado = false;
        boolean resultado = premiums.verificarPremium(12345678);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }
}
