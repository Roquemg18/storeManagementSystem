package ar.unrn;

import ar.unrn.excepciones.ParametroNoValidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Test para los métodos de la clase Carrito.
 */
@DisplayName("Test para métodos de la clase Carrito")
class CarritoTest {

    //AGREGAR PRODUCTO Y LARGO ------------------------------------------------------
    @Test
    @DisplayName("Carrito - AgregarProducto y Largo - Prueba Uno")
    void testAgregarProductoYLargoPruebaUno() {
        Carrito carrito = new Carrito();
        Producto uno = new Producto(120.0, "Arroz", "Granos");
        Producto dos = new Producto(150.0, "Coca-Cola", "Gaseosa");
        Producto tres = new Producto(100.0, "Fideos", "Pasta");
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 10);
        ProductoEnCarrito enCarritoTres = new ProductoEnCarrito(tres, 10);
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        carrito.agregarProducto(enCarritoTres);
        int esperado = 3;
        int resultado = carrito.largo();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Carrito - AgregarProducto y Largo - Prueba Dos")
    void testAgregarProductoYLargoPruebaDos() {
        Carrito carrito = new Carrito();
        Producto uno = new Producto(120.0, "Arroz", "Granos");
        Producto dos = new Producto(150.0, "Coca-Cola", "Gaseosa");
        Producto tres = new Producto(100.0, "Fideos", "Pasta");
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 10);
        ProductoEnCarrito enCarritoTres = new ProductoEnCarrito(tres, 10);
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        int esperado = 2;
        int resultado = carrito.largo();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Carrito - AgregarProducto y Largo - Prueba Tres")
    void testAgregarProductoYLargoPruebaTres() {
        Carrito carrito = new Carrito();
        Producto uno = new Producto(120.0, "Arroz", "Granos");
        Producto dos = new Producto(150.0, "Coca-Cola", "Gaseosa");
        Producto tres = new Producto(100.0, "Fideos", "Pasta");
        Producto cuatro = new Producto(20.0, "Gomitas", "Golosinas");
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 10);
        ProductoEnCarrito enCarritoTres = new ProductoEnCarrito(tres, 10);
        ProductoEnCarrito enCarritoCuatro = new ProductoEnCarrito(cuatro, 10);
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        carrito.agregarProducto(enCarritoTres);
        carrito.agregarProducto(enCarritoCuatro);
        int esperado = 4;
        int resultado = carrito.largo();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Carrito - AgregarProducto y Largo - Prueba Cuatro")
    void testAgregarProductoYLargoPruebaCuatro() {
        Carrito carrito = new Carrito();
        Producto uno = new Producto(120.0, "Arroz", "Granos");
        Producto dos = new Producto(150.0, "Coca-Cola", "Gaseosa");
        Producto tres = new Producto(100.0, "Fideos", "Pasta");
        Producto cuatro = new Producto(20.0, "Gomitas", "Golosinas");
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        carrito.agregarProducto(enCarritoUno);
        int esperado = 1;
        int resultado = carrito.largo();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    //ELIMINAR PRODUCTO Y TO STRING -------------------------------------------------

    @Test
    @DisplayName("Carrito - EliminarProducto y ToString - Prueba Uno")
    void testEliminarProductoYToStringPruebaUno() {
        Carrito carrito = new Carrito();
        Producto uno = new Producto(120.0, "Arroz", "Granos");
        Producto dos = new Producto(150.0, "Coca-Cola", "Gaseosa");
        Producto tres = new Producto(100.0, "Fideos", "Pasta");
        Producto cuatro = new Producto(20.0, "Gomitas", "Golosinas");
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 10);
        ProductoEnCarrito enCarritoTres = new ProductoEnCarrito(tres, 10);
        ProductoEnCarrito enCarritoCuatro = new ProductoEnCarrito(cuatro, 10);
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        carrito.agregarProducto(enCarritoTres);
        carrito.agregarProducto(enCarritoCuatro);
        carrito.eliminarProducto(enCarritoUno);
        String esperado = "[Producto: Nombre: Coca-Cola, Tipo: Gaseosa, "
                + "Precio: 150.0, Cantidad : 10\n"
                + "Producto: Nombre: Fideos, Tipo: Pasta, Precio: 100.0, "
                + "Cantidad : 10\n"
                + "Producto: Nombre: Gomitas, Tipo: Golosinas, Precio: 20.0, "
                + "Cantidad : 10]";
        String resultado = carrito.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Carrito - EliminarProducto y ToString - Prueba Dos")
    void testEliminarProductoYToStringPruebaDos() {
        Carrito carrito = new Carrito();
        Producto uno = new Producto(120.0, "Arroz", "Granos");
        Producto dos = new Producto(150.0, "Coca-Cola", "Gaseosa");
        Producto tres = new Producto(100.0, "Fideos", "Pasta");
        Producto cuatro = new Producto(20.0, "Gomitas", "Golosinas");
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 10);
        ProductoEnCarrito enCarritoTres = new ProductoEnCarrito(tres, 10);
        ProductoEnCarrito enCarritoCuatro = new ProductoEnCarrito(cuatro, 10);
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        carrito.agregarProducto(enCarritoTres);
        carrito.agregarProducto(enCarritoCuatro);
        carrito.eliminarProducto(enCarritoUno);
        carrito.eliminarProducto(enCarritoDos);
        String esperado = "[Producto: Nombre: Fideos, Tipo: Pasta, Precio: 100.0, "
                + "Cantidad : 10\n"
                + "Producto: Nombre: Gomitas, Tipo: Golosinas, Precio: 20.0, "
                + "Cantidad : 10]";
        String resultado = carrito.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Carrito - EliminarProducto y ToString - Prueba Tres")
    void testEliminarProductoYToStringPruebaTres() {
        Carrito carrito = new Carrito();
        Producto uno = new Producto(120.0, "Arroz", "Granos");
        Producto dos = new Producto(150.0, "Coca-Cola", "Gaseosa");
        Producto tres = new Producto(100.0, "Fideos", "Pasta");
        Producto cuatro = new Producto(20.0, "Gomitas", "Golosinas");
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 10);
        ProductoEnCarrito enCarritoTres = new ProductoEnCarrito(tres, 10);
        ProductoEnCarrito enCarritoCuatro = new ProductoEnCarrito(cuatro, 10);
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        carrito.agregarProducto(enCarritoTres);
        carrito.agregarProducto(enCarritoCuatro);
        carrito.eliminarProducto(enCarritoUno);
        carrito.eliminarProducto(enCarritoDos);
        carrito.eliminarProducto(enCarritoTres);
        String esperado = "[Producto: Nombre: Gomitas, Tipo: Golosinas, Precio: 20.0, "
                + "Cantidad : 10]";
        String resultado = carrito.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Carrito - EliminarProducto y ToString - Prueba Cuatro")
    void testEliminarProductoYToStringPruebaCuatro() {
        Carrito carrito = new Carrito();
        Producto uno = new Producto(120.0, "Arroz", "Granos");
        Producto dos = new Producto(150.0, "Coca-Cola", "Gaseosa");
        Producto tres = new Producto(100.0, "Fideos", "Pasta");
        Producto cuatro = new Producto(20.0, "Gomitas", "Golosinas");
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 10);
        ProductoEnCarrito enCarritoTres = new ProductoEnCarrito(tres, 10);
        ProductoEnCarrito enCarritoCuatro = new ProductoEnCarrito(cuatro, 10);
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        carrito.agregarProducto(enCarritoTres);
        carrito.agregarProducto(enCarritoCuatro);
        carrito.eliminarProducto(enCarritoUno);
        carrito.eliminarProducto(enCarritoDos);
        carrito.eliminarProducto(enCarritoTres);
        carrito.eliminarProducto(enCarritoCuatro);
        String esperado = "[]";
        String resultado = carrito.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Carrito - EliminarProducto y ToString - Prueba Cinco")
    void testEliminarProductoYToStringPruebaCinco() {
        try {
            Carrito carrito = new Carrito();
            Producto uno = new Producto(120.0, "Arroz", "Granos");
            ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
            carrito.agregarProducto(enCarritoUno);
            carrito.eliminarProducto(enCarritoUno);
            carrito.eliminarProducto(enCarritoUno);
            Assertions.fail("Debería haber saltado error");
        } catch (ParametroNoValidoException exc) {
            System.out.println("Producto no encontrado");
        }
    }

    //OBTENER CARRITO --------------------------------------------------------------

    @Test
    @DisplayName("Carrito - ObtenerCarrito - Prueba Uno")
    void testObtenerCarritoPruebaUno() {
        Carrito carrito = new Carrito();
        Producto uno = new Producto(120.0, "Arroz", "Granos");
        Producto dos = new Producto(150.0, "Coca-Cola", "Gaseosa");
        Producto tres = new Producto(100.0, "Fideos", "Pasta");
        Producto cuatro = new Producto(20.0, "Gomitas", "Golosinas");
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 10);
        ProductoEnCarrito enCarritoTres = new ProductoEnCarrito(tres, 10);
        ProductoEnCarrito enCarritoCuatro = new ProductoEnCarrito(cuatro, 10);
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        carrito.agregarProducto(enCarritoTres);
        carrito.agregarProducto(enCarritoCuatro);
        ArrayList<ProductoEnCarrito> otroCarrito = carrito.obtenerCarrito();
        String esperado = "[Producto: Nombre: Arroz, Tipo: Granos, Precio: 120.0, "
                + "Cantidad : 10\n"
                + "Producto: Nombre: Coca-Cola, Tipo: Gaseosa, Precio: 150.0, "
                + "Cantidad : 10\n"
                + "Producto: Nombre: Fideos, Tipo: Pasta, Precio: 100.0, "
                + "Cantidad : 10\n"
                + "Producto: Nombre: Gomitas, Tipo: Golosinas, Precio: 20.0, "
                + "Cantidad : 10]";
        String resultado = carrito.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Carrito - ObtenerCarrito - Prueba Dos")
    void testObtenerCarritoPruebaDos() {
        Carrito carrito = new Carrito();
        Producto uno = new Producto(120.0, "Arroz", "Granos");
        Producto dos = new Producto(150.0, "Coca-Cola", "Gaseosa");
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 10);
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        carrito.eliminarProducto(enCarritoUno);
        ArrayList<ProductoEnCarrito> otroCarrito = carrito.obtenerCarrito();
        String esperado = "[Producto: Nombre: Coca-Cola, Tipo: Gaseosa, Precio: 150.0, "
                + "Cantidad : 10]";
        String resultado = carrito.toString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    //CALCULAR SUBTOTAL ----------------------------------------------------------

    @Test
    @DisplayName("Carrito - CalcularSubTotal - Prueba Uno")
    void testCalcularSubTotalPruebaUno() {
        Carrito carrito = new Carrito();
        Producto uno = new Producto(120.0, "Arroz", "Granos");
        Producto dos = new Producto(150.0, "Coca-Cola", "Gaseosa");
        Producto tres = new Producto(100.0, "Fideos", "Pasta");
        Producto cuatro = new Producto(20.0, "Gomitas", "Golosinas");
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 10);
        ProductoEnCarrito enCarritoTres = new ProductoEnCarrito(tres, 10);
        ProductoEnCarrito enCarritoCuatro = new ProductoEnCarrito(cuatro, 10);
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        carrito.agregarProducto(enCarritoTres);
        carrito.agregarProducto(enCarritoCuatro);
        double esperado = 3900.0;
        double resultado = carrito.calcularSubTotal();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Carrito - CalcularSubTotal - Prueba Dos")
    void testCalcularSubTotalPruebaDos() {
        Carrito carrito = new Carrito();
        Producto uno = new Producto(120.0, "Arroz", "Granos");
        Producto dos = new Producto(150.0, "Coca-Cola", "Gaseosa");
        Producto tres = new Producto(100.0, "Fideos", "Pasta");
        Producto cuatro = new Producto(20.0, "Gomitas", "Golosinas");
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 10);
        ProductoEnCarrito enCarritoTres = new ProductoEnCarrito(tres, 10);
        ProductoEnCarrito enCarritoCuatro = new ProductoEnCarrito(cuatro, 10);
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        carrito.agregarProducto(enCarritoTres);
        carrito.agregarProducto(enCarritoCuatro);
        carrito.eliminarProducto(enCarritoDos);
        double esperado = 2400.0;
        double resultado = carrito.calcularSubTotal();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }
}
