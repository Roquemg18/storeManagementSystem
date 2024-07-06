package ar.unrn.estructura;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test para los métodos de la clase Cliente.
 */
@DisplayName("Test para métodos de la clase Cliente")
class ClienteTest {

    //COMPARAR DNI ------------------------------------------------------------
    @Test
    @DisplayName("Cliente - CompararDNI - Prueba Uno")
    void testCompararDNIPruebaUno() {
        Cliente cliente = new Cliente("Roberto", 12345678, 32);
        boolean esperado = true;
        boolean resultado = cliente.compararDNI(12345678);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Cliente - CompararDNI - Prueba Dos")
    void testCompararDNIPruebaDos() {
        Cliente cliente = new Cliente("Roberto", 12345678, 32);
        boolean esperado = false;
        boolean resultado = cliente.compararDNI(87654321);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Cliente - CompararDNI - Prueba Tres")
    void testCompararDNIPruebaTres() {
        Cliente cliente = new Cliente("María", 48392212, 32);
        boolean esperado = true;
        boolean resultado = cliente.compararDNI(48392212);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Cliente - CompararDNI - Prueba Cuatro")
    void testCompararDNIPruebaCuatro() {
        Cliente cliente = new Cliente("María", 12345678, 32);
        boolean esperado = false;
        boolean resultado = cliente.compararDNI(21009422);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    //TO STRING ---------------------------------------------------------------------

    @Test
    @DisplayName("Cliente - ToString - Prueba Uno")
    void testToStringPruebaUno() {
        Cliente cliente = new Cliente("Roberto", 12345678, 32);
        String esperado = "[Nombre: Roberto, DNI: 12345678, Edad: 32]";
        String resultado = cliente.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Cliente - ToString - Prueba Dos")
    void testToStringPruebaDos() {
        Cliente cliente = new Cliente("María", 87654321, 36);
        String esperado = "[Nombre: María, DNI: 87654321, Edad: 36]";
        String resultado = cliente.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }
}
