package ar.unrn;

import ar.unrn.excepciones.ParametroNoValidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test para los métodos de la clase Producto.
 */
@DisplayName("Test para métodos de la clase Producto")
class ProductoTest {

    //TICKET STRING PRODUCT ------------------------------------------------------
    @Test
    @DisplayName("Producto - TicketStringProduct - Prueba Uno")
    void testTicketStringProductPruebaUno() {
        double precio = 100;
        String nombre = "Arroz";
        String tipo = "Granos";
        Producto producto = new Producto(precio, nombre, tipo);
        String esperado = "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Precio: " + precio;
        String resultado = producto.ticketStringProduct();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - TicketStringProduct - Prueba Dos")
    void testTicketStringProductPruebaDos() {
        double precio = 200;
        String nombre = "Fideos";
        String tipo = "Pasta";
        Producto producto = new Producto(precio, nombre, tipo);
        String esperado = "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Precio: " + precio;
        String resultado = producto.ticketStringProduct();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - TicketStringProduct - Prueba Tres")
    void testTicketStringProductPruebaTres() {
        double precio = 30;
        String nombre = "Gomitas";
        String tipo = "Golosinas";
        Producto producto = new Producto(precio, nombre, tipo);
        String esperado = "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Precio: " + precio;
        String resultado = producto.ticketStringProduct();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - TicketStringProduct - Prueba Cuatro")
    void testTicketStringProductPruebaCuatro() {
        try {
            double precio = -10;
            String nombre = "Arroz";
            String tipo = "Granos";
            Producto producto = new Producto(precio, nombre, tipo);
            Assertions.fail("Debería haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("El precio del producto no puede ser negativo");
        }
    }

    @Test
    @DisplayName("Producto - TicketStringProduct - Prueba Cinco")
    void testTicketStringProductPruebaCinco() {
        try {
            double precio = -100;
            String nombre = "Fideos";
            String tipo = "Pasta";
            Producto producto = new Producto(precio, nombre, tipo);
            Assertions.fail("Debería haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("El precio del producto no puede ser negativo");
        }
    }

    //TO STRING Y AUMENTAR STOCK -----------------------------------------------------

    @Test
    @DisplayName("Producto - To String - Prueba Uno")
    void testToStringPruebaUno() {
        double precio = 100;
        int stock = 0;
        String nombre = "Arroz";
        String tipo = "Granos";
        Producto producto = new Producto(precio, nombre, tipo);
        String esperado = "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Stock: " + stock
                + ", Precio: " + precio;
        String resultado = producto.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - To String y Aumentar Stock - Prueba Dos")
    void testToStringYAumentarStockPruebaDos() {
        double precio = 100;
        int stock = 10;
        String nombre = "Arroz";
        String tipo = "Granos";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.aumentarStock(stock);
        String esperado = "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Stock: " + stock
                + ", Precio: " + precio;
        String resultado = producto.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - To String - Prueba Tres")
    void testToStringYAumentarStockPruebaTres() {
        double precio = 100;
        int stock = 100;
        String nombre = "Arroz";
        String tipo = "Granos";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.aumentarStock(stock);
        String esperado = "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Stock: " + stock
                + ", Precio: " + precio;
        String resultado = producto.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - To String - Prueba Cuatro")
    void testToStringYAumentarStockPruebaCuatro() {
        try {
            double precio = 100;
            int stock = -10;
            String nombre = "Arroz";
            String tipo = "Granos";
            Producto producto = new Producto(precio, nombre, tipo);
            producto.aumentarStock(stock);
            Assertions.fail("Debería haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("El precio del producto no puede ser negativo");
        }
    }

    @Test
    @DisplayName("Producto - To String - Prueba Cinco")
    void testToStringYAumentarStockPruebaCinco() {
        try {
            double precio = 100;
            int stock = -50;
            String nombre = "Arroz";
            String tipo = "Granos";
            Producto producto = new Producto(precio, nombre, tipo);
            producto.aumentarStock(stock);
            Assertions.fail("Debería haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("El precio del producto no puede ser negativo");
        }
    }

    //DISMINUIR STOCK

    @Test
    @DisplayName("Producto - Disminuir Stock - Prueba Uno")
    void testDisminuirStockPruebaUno() {
        double precio = 100;
        int stock = 10;
        String nombre = "Arroz";
        String tipo = "Granos";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.aumentarStock(stock);
        producto.disminuirStock(5);
        String esperado = "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Stock: 5"
                + ", Precio: " + precio;
        String resultado = producto.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - Disminuir Stock - Prueba Dos")
    void testDisminuirStockPruebaDos() {
        double precio = 100;
        int stock = 100;
        String nombre = "Arroz";
        String tipo = "Granos";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.aumentarStock(stock);
        producto.disminuirStock(23);
        String esperado =  "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Stock: 77"
                + ", Precio: " + precio;
        String resultado = producto.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - Disminuir Stock - Prueba Tres")
    void testDisminuirStockPruebaTres() {
        try {
            double precio = 100;
            int stock = 10;
            String nombre = "Arroz";
            String tipo = "Granos";
            Producto producto = new Producto(precio, nombre, tipo);
            producto.aumentarStock(stock);
            producto.disminuirStock(12);
            Assertions.fail("Debería haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("La cantidad a disminuir es mayor que el stock");
        }
    }

    @Test
    @DisplayName("Producto - Disminuir Stock - Prueba Cuatro")
    void testDisminuirStockPruebaCuatro() {
        try {
            double precio = 100;
            String nombre = "Arroz";
            String tipo = "Granos";
            Producto producto = new Producto(precio, nombre, tipo);
            producto.disminuirStock(1);
            Assertions.fail("Debería haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("La cantidad a disminuir es mayor que el stock");
        }
    }

    //AUMENTAR PRECIO ------------------------------------------------------------

    @Test
    @DisplayName("Producto - AumentarPrecio - Prueba Uno")
    void testAumentarPrecioPruebaUno() {
        double precio = 30;
        String nombre = "Fideos";
        String tipo = "Pasta";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.aumentarPrecio(15);
        String esperado = "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Precio: 45.0";
        String resultado = producto.ticketStringProduct();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - AumentarPrecio - Prueba Dos")
    void testAumentarPrecioPruebaDos() {
        double precio = 100;
        String nombre = "Arroz";
        String tipo = "Granos";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.aumentarPrecio(25.5);
        String esperado = "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Precio: 125.5";
        String resultado = producto.ticketStringProduct();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - AumentarPrecio - Prueba Tres")
    void testAumentarPrecioPruebaTres() {
        double precio = 30;
        String nombre = "Fideos";
        String tipo = "Pasta";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.aumentarPrecio(0);
        String esperado = "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Precio: 30.0";
        String resultado = producto.ticketStringProduct();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - AumentarPrecio - Prueba Cuatro")
    void testAumentarPrecioPruebaCuatro() {
        try {
            double precio = 30;
            String nombre = "Fideos";
            String tipo = "Pasta";
            Producto producto = new Producto(precio, nombre, tipo);
            producto.aumentarPrecio(-5);
            Assertions.fail("Debería haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("El valor no puede ser menor a 0");
        }
    }

    @Test
    @DisplayName("Producto - AumentarPrecio - Prueba Cinco")
    void testAumentarPrecioPruebaCinco() {
        try {
            double precio = 20;
            String nombre = "Gomitas";
            String tipo = "Golosinas";
            Producto producto = new Producto(precio, nombre, tipo);
            producto.aumentarPrecio(-10);
            Assertions.fail("Debería haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("El valor no puede ser menor a 0");
        }
    }

    //DISMINUIR PRECIO -------------------------------------------------------

    @Test
    @DisplayName("Producto - DisminuirPrecio - Prueba Uno")
    void testDisminuirPrecioPruebaUno() {
        double precio = 100;
        String nombre = "Pan";
        String tipo = "Panadería";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.disminuirPrecio(20);
        String esperado = "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Precio: 80.0";
        String resultado = producto.ticketStringProduct();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - DisminuirPrecio - Prueba Dos")
    void testDisminuirPrecioPruebaDos() {
        double precio = 20;
        String nombre = "Gomitas";
        String tipo = "Golosinas";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.disminuirPrecio(10.4);
        String esperado = "Producto:"
                + " Nombre: " + nombre
                + ", Tipo: " + tipo
                + ", Precio: 9.6";
        String resultado = producto.ticketStringProduct();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - DisminuirPrecio - Prueba Tres")
    void testDisminuirPrecioPruebaTres() {
        try {
            double precio = 20;
            String nombre = "Gomitas";
            String tipo = "Golosinas";
            Producto producto = new Producto(precio, nombre, tipo);
            producto.disminuirPrecio(30);
            Assertions.fail("Debería haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("El valor a disminuir no puede ser mayor al precio del "
                    + "producto");
        }
    }

    @Test
    @DisplayName("Producto - DisminuirPrecio - Prueba Cuatro")
    void testDisminuirPrecioPruebaCuatro() {
        try {
            double precio = 100;
            String nombre = "Fideos";
            String tipo = "Pasta";
            Producto producto = new Producto(precio, nombre, tipo);
            producto.aumentarPrecio(-10);
            Assertions.fail("Debería haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("El valor no puede ser menor a 0");
        }
    }

    //DISPONIBILIDAD

    @Test
    @DisplayName("Producto - Disponibilidad - Prueba Uno")
    void testDisponibilidadPruebaUno() {
        double precio = 90;
        int stock = 100;
        String nombre = "Fideos";
        String tipo = "Pasta";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.aumentarStock(stock);
        boolean esperado = true;
        boolean resultado = producto.disponibilidad(50);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - Disponibilidad - Prueba Dos")
    void testDisponibilidadPruebaDos() {
        double precio = 90;
        int stock = 100;
        String nombre = "Fideos";
        String tipo = "Pasta";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.aumentarStock(stock);
        boolean esperado = true;
        boolean resultado = producto.disponibilidad(100);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - Disponibilidad - Prueba Tres")
    void testDisponibilidadPruebaTres() {
        double precio = 90;
        int stock = 50;
        String nombre = "Fideos";
        String tipo = "Pasta";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.aumentarStock(stock);
        boolean esperado = false;
        boolean resultado = producto.disponibilidad(100);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - Disponibilidad - Prueba Cuatro")
    void testDisponibilidadPruebaCuatro() {
        double precio = 90;
        int stock = 50;
        String nombre = "Fideos";
        String tipo = "Pasta";
        Producto producto = new Producto(precio, nombre, tipo);
        producto.aumentarStock(stock);
        boolean esperado = false;
        boolean resultado = producto.disponibilidad(51);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - Disponibilidad - Prueba Cinco")
    void testDisponibilidadPruebaCinco() {
        try {
            double precio = 90;
            int stock = 50;
            String nombre = "Fideos";
            String tipo = "Pasta";
            Producto producto = new Producto(precio, nombre, tipo);
            producto.aumentarStock(stock);
            boolean resultado = producto.disponibilidad(-10);
            Assertions.fail("Debió haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("La cantidad no puede ser menor a 0");
        }
    }

    //COMPARAR TIPO -------------------------------------------------------------

    @Test
    @DisplayName("Producto - CompararTipo - Prueba Uno")
    void testCompararTipoPruebaUno() {
        double precio = 120;
        String nombre = "Jamón";
        String tipo = "Fiambre";
        Producto producto = new Producto(precio, nombre, tipo);
        boolean esperado = true;
        boolean resultado = producto.compararTipo("Fiambre");
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - CompararTipo - IgnoreCase - Prueba Dos")
    void testCompararTipoIgnoreCasePruebaDos() {
        double precio = 120;
        String nombre = "Jamón";
        String tipo = "Fiambre";
        Producto producto = new Producto(precio, nombre, tipo);
        boolean esperado = true;
        boolean resultado = producto.compararTipo("fiambre");
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - CompararTipo - Prueba Tres")
    void testCompararTipoPruebaTres() {
        double precio = 120;
        String nombre = "Jamón";
        String tipo = "Fiambre";
        Producto producto = new Producto(precio, nombre, tipo);
        boolean esperado = false;
        boolean resultado = producto.compararTipo("Pasta");
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    //COMPARAR Nombre -------------------------------------------------------------

    @Test
    @DisplayName("Producto - CompararNombre - Prueba Uno")
    void testCompararNombrePruebaUno() {
        double precio = 150;
        String nombre = "Ravioles";
        String tipo = "Pasta";
        Producto producto = new Producto(precio, nombre, tipo);
        boolean esperado = true;
        boolean resultado = producto.compararNombre("Ravioles");
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - CompararNombre - IgnoreCase - Prueba Dos")
    void testCompararNombreIgnoreCasePruebaDos() {
        double precio = 150;
        String nombre = "Ravioles";
        String tipo = "Pasta";
        Producto producto = new Producto(precio, nombre, tipo);
        boolean esperado = true;
        boolean resultado = producto.compararNombre("ravioles");
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - CompararNombre - Prueba Tres")
    void testCompararNombrePruebaTres() {
        double precio = 150;
        String nombre = "Ravioles";
        String tipo = "Pasta";
        Producto producto = new Producto(precio, nombre, tipo);
        boolean esperado = false;
        boolean resultado = producto.compararNombre("Arroz");
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    //DETERMINAR PRECIO -------------------------------------------------------------

    @Test
    @DisplayName("Producto - DeterminarPrecio - Prueba Uno")
    void testDeterminarPrecioPruebaUno() {
        double precio = 90;
        String nombre = "Fideos";
        String tipo = "Pasta";
        Producto producto = new Producto(precio, nombre, tipo);
        double esperado = 270;
        double resultado = producto.determinarPrecio(3);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - DeterminarPrecio - Prueba Dos")
    void testDeterminarPrecioPruebaDos() {
        double precio = 120;
        String nombre = "Arroz";
        String tipo = "Granos";
        Producto producto = new Producto(precio, nombre, tipo);
        double esperado = 2400;
        double resultado = producto.determinarPrecio(20);
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Producto - DeterminarPrecio - Prueba Tres")
    void testDeterminarPrecioPruebaTres() {
        try {
            double precio = 90;
            String nombre = "Fideos";
            String tipo = "Pasta";
            Producto producto = new Producto(precio, nombre, tipo);
            double resultado = producto.determinarPrecio(-10);
            Assertions.fail("Debería haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("La cantidad no puede ser menor a 0");
        }
    }
}
