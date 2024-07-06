package ar.unrn;

import ar.unrn.excepciones.ParametroNoValidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Test para métodos de la clase ProductoEnCarrito")
class ProductoEnCarritoTest {
    @Test
    @DisplayName("Test crear un productoEnCarrito")
    void testProductoEnCarritoCrearProductEnCarrito() {
        Producto fanta = new Producto(15, "fanta", "gaseosas");
        int cantidad = 10;
        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(fanta, cantidad);

        String expected = "Producto: Nombre: fanta, Tipo: gaseosas, Precio: 15.0, "
                + "Cantidad : 10";
        Assertions.assertEquals(expected, productoEnCarrito.toString());

    }

    @Test
    @DisplayName("Test crear un productoEnCarrito con una cantidad negativa")
    void testProductoEnCarritoCrearProductEnCarritoError() {
        Producto fanta = new Producto(15, "fanta", "gaseosas");
        int cantidad = -1;
        try {
            ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(fanta, cantidad);
            fail("Se esperaba ParametroNoValidoException");
        } catch (ParametroNoValidoException e) {
            // Exception esperada
        }
    }

    @Test
    @DisplayName("test del metodo calcularPrecio")
    void testProductoEnCarritoCalcularPrecio() {
        Producto fanta = new Producto(15, "fanta", "gaseosas");
        int cantidad = 10;
        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(fanta, cantidad);

        double expedted = 150;

        Assertions.assertEquals(expedted, productoEnCarrito.calcularPrecio());
    }

    @Test
    @DisplayName("test del metodo compararTipoEnCarrito - true")
    void testProductoEnCarritoComparaTipoCarrito() {
        Producto fanta = new Producto(15, "fanta", "gaseosas");
        int cantidad = 10;
        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(fanta, cantidad);

        String tipoAcomprarar = "gaseosas";

        Assertions.assertTrue(productoEnCarrito.compararTipoEnCarrito(tipoAcomprarar));

    }

    @Test
    @DisplayName("test del metodo compararTipoEnCarrito - false")
    void testProductoEnCarritoComparaTipoCarritoFalse() {
        Producto fanta = new Producto(15, "fanta", "gaseosas");
        int cantidad = 10;
        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(fanta, cantidad);

        String tipoAcomprarar = "jugos";

        Assertions.assertFalse(productoEnCarrito.compararTipoEnCarrito(tipoAcomprarar));

    }

    @Test
    @DisplayName("test metodo comparar cantidad cantidad mayor")
    void testProductoEnCarritoComparaCantidad() {
        Producto fanta = new Producto(15, "fanta", "gaseosas");
        int cantidad = 10;
        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(fanta, cantidad);

        int cantidadAcomparar = 5;

        int expected = 1;
        Assertions.assertEquals(expected,
                productoEnCarrito.comparaCantidad(cantidadAcomparar));
    }

    @Test
    @DisplayName("test metodo comparar cantidad cantidad menor")
    void testProductoEnCarritoComparaCantidadMenor() {
        Producto fanta = new Producto(15, "fanta", "gaseosas");
        int cantidad = 10;
        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(fanta, cantidad);

        int cantidadAcomparar = 15;

        int expected = -1;
        Assertions.assertEquals(expected,
                productoEnCarrito.comparaCantidad(cantidadAcomparar));
    }

    @Test
    @DisplayName("test metodo comparar cantidad cantidad igual")
    void testProductoEnCarritoComparaCantidadIgual() {
        Producto fanta = new Producto(15, "fanta", "gaseosas");
        int cantidad = 10;
        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(fanta, cantidad);

        int cantidadAcomparar = 10;

        int expected = 0;
        Assertions.assertEquals(expected,
                productoEnCarrito.comparaCantidad(cantidadAcomparar));
    }

    @Test
    @DisplayName("test metodo verificar stock -True")
    void testProductoEnCarritoVerificarStock() {
        Producto fanta = new Producto(15, "fanta", "gaseosas");
        fanta.aumentarStock(10);
        int cantidad = 5;
        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(fanta, cantidad);

        Assertions.assertTrue(productoEnCarrito.verificarStock());

    }

    @Test
    @DisplayName("test metodo verificar stock - False")
    void testProductoEnCarritoVerificarStockFalse() {
        Producto fanta = new Producto(15, "fanta", "gaseosas");
        fanta.aumentarStock(10);
        int cantidad = 15;
        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(fanta, cantidad);

        Assertions.assertFalse(productoEnCarrito.verificarStock());

    }

    @Test
    @DisplayName("test metodo toString")
    void testProductoEnCarritoToString() {
        Producto fanta = new Producto(15, "fanta", "gaseosas");
        int cantidad = 15;
        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(fanta, cantidad);

        String expected = "Producto: Nombre: fanta, Tipo: gaseosas, Precio: 15.0, "
                + "Cantidad : 15";

        Assertions.assertEquals(expected, productoEnCarrito.toString());
    }

    @Test
    @DisplayName("test metodo actualizar inventario")
    void testProductoEnCarritoActualizarInventario() {
        Inventario productos = new Inventario();
        Producto fanta = new Producto(15, "fanta", "gaseosas");
        fanta.aumentarStock(10);
        productos.agregarProducto(fanta);
        int cantidad = 5;

        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(fanta, cantidad);

        productoEnCarrito.actualizarInventario(productos);
        String expected = "Producto: Nombre: fanta, Tipo: gaseosas, Stock: "
                + "5, Precio: 15.0\n";

        Assertions.assertEquals(expected, productos.toString());
    }
}
