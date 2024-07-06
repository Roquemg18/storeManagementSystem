package ar.unrn.strategy;

import ar.unrn.Carrito;
import ar.unrn.Inventario;
import ar.unrn.Producto;
import ar.unrn.ProductoEnCarrito;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test para los métodos de la clase Venta.
 */
@DisplayName("Test para métodos de la clase Venta")
class VentaTest {

    //FIJAR ESTRATEGIA Y PROCESAR VENTA ---------------------------------------------
    @Test
    @DisplayName("Venta - fijarEstrategia y procesarVenta - Prueba Uno")
    void testFijarEstrategiaYProcesarVentaPruebaUno() {
        Producto producto = new Producto(100.0, "Fideos", "Pasta");
        Inventario inventario = new Inventario();
        inventario.agregarProducto(producto, 100);
        ProductoEnCarrito enCarrito = new ProductoEnCarrito(producto, 10);
        Carrito carrito = new Carrito();
        carrito.agregarProducto(enCarrito);
        DescuentoPorVolumen estrategia = new DescuentoPorVolumen(10,
                5.0);
        Venta reporte = new Venta(inventario, carrito);
        reporte.fijarEstrategia(estrategia);
        String esperado = """
                ----- Ticket de Compra -----
                Producto: Nombre: Fideos, Tipo: Pasta, Precio: 100.0, Cantidad : 10
                subTotal: 1000.0
                ---------Descuento--------
                Descuento por volumen: 50.0

                ---------Total--------
                Total: 950.0
                ----------------------------
                """;
        String resultado = reporte.procesarVenta();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Venta - fijarEstrategia y procesarVenta - Prueba Dos")
    void testFijarEstrategiaYProcesarVentaPruebaDos() {
        Producto producto = new Producto(120.0, "Arroz", "Granos");
        Inventario inventario = new Inventario();
        inventario.agregarProducto(producto, 100);
        ProductoEnCarrito enCarrito = new ProductoEnCarrito(producto, 10);
        Carrito carrito = new Carrito();
        carrito.agregarProducto(enCarrito);
        DescuentoPorVolumen estrategia = new DescuentoPorVolumen(15,
                5.0);
        Venta reporte = new Venta(inventario, carrito);
        reporte.fijarEstrategia(estrategia);
        String esperado = """
                ----- Ticket de Compra -----
                Producto: Nombre: Arroz, Tipo: Granos, Precio: 120.0, Cantidad : 10
                subTotal: 1200.0
                ---------Descuento--------

                ---------Total--------
                Total: 1200.0
                ----------------------------
                """;
        String resultado = reporte.procesarVenta();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Venta - fijarEstrategia y procesarVenta - Prueba Tres")
    void testFijarEstrategiaYProcesarVentaPruebaTres() {
        Producto uno = new Producto(100.0, "Fideos", "Pasta");
        Producto dos = new Producto(120.0, "Arroz", "Granos");
        Inventario inventario = new Inventario();
        inventario.agregarProducto(uno, 100);
        inventario.agregarProducto(dos, 100);
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 8);
        Carrito carrito = new Carrito();
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        DescuentoPorVolumen porVolumen = new DescuentoPorVolumen(10,
                5.0);
        Venta reporte = new Venta(inventario, carrito);
        reporte.fijarEstrategia(porVolumen);
        DescuentoPromocional promocional = new DescuentoPromocional("Granos",
                10.0);
        reporte.fijarEstrategia(promocional);
        String esperado = """
                ----- Ticket de Compra -----
                Producto: Nombre: Fideos, Tipo: Pasta, Precio: 100.0, Cantidad : 10
                Producto: Nombre: Arroz, Tipo: Granos, Precio: 120.0, Cantidad : 8
                subTotal: 1960.0
                ---------Descuento--------
                Descuento por volumen: 50.0
                Descuento por promocion: 96.0

                ---------Total--------
                Total: 1814.0
                ----------------------------
                """;
        String resultado = reporte.procesarVenta();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    //APLICAR DESCUENTO Y TOTAL STRING -----------------------------------------------

    @Test
    @DisplayName("Venta - aplicarDescuento y totalString - Prueba Uno")
    void testAplicarDescuentoYTotalStringPruebaUno() {
        Producto producto = new Producto(100.0, "Fideos", "Pasta");
        Inventario inventario = new Inventario();
        inventario.agregarProducto(producto, 100);
        ProductoEnCarrito enCarrito = new ProductoEnCarrito(producto, 10);
        Carrito carrito = new Carrito();
        carrito.agregarProducto(enCarrito);
        DescuentoPorVolumen estrategia = new DescuentoPorVolumen(10,
                5.0);
        Venta reporte = new Venta(inventario, carrito);
        reporte.fijarEstrategia(estrategia); //Este método llama a aplicarDescuento.
        String esperado = "950.0";
        String resultado = reporte.totalString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Venta - aplicarDescuento y totalString - Prueba Dos")
    void testAplicarDescuentoYTotalStringPruebaDos() {
        Producto producto = new Producto(120.0, "Arroz", "Granos");
        Inventario inventario = new Inventario();
        inventario.agregarProducto(producto, 100);
        ProductoEnCarrito enCarrito = new ProductoEnCarrito(producto, 10);
        Carrito carrito = new Carrito();
        carrito.agregarProducto(enCarrito);
        DescuentoPorVolumen estrategia = new DescuentoPorVolumen(15,
                5.0);
        Venta reporte = new Venta(inventario, carrito);
        reporte.fijarEstrategia(estrategia); //Este método llama a aplicarDescuento.
        String esperado = "1200.0";
        String resultado = reporte.totalString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }

    @Test
    @DisplayName("Venta - aplicarDescuento y totalString - Prueba Tres")
    void testAplicarDescuentoYTotalStringPruebaTres() {
        Producto uno = new Producto(100.0, "Fideos", "Pasta");
        Producto dos = new Producto(120.0, "Arroz", "Granos");
        Inventario inventario = new Inventario();
        inventario.agregarProducto(uno, 100);
        inventario.agregarProducto(dos, 100);
        ProductoEnCarrito enCarritoUno = new ProductoEnCarrito(uno, 10);
        ProductoEnCarrito enCarritoDos = new ProductoEnCarrito(dos, 8);
        Carrito carrito = new Carrito();
        carrito.agregarProducto(enCarritoUno);
        carrito.agregarProducto(enCarritoDos);
        DescuentoPorVolumen porVolumen = new DescuentoPorVolumen(10,
                5.0);
        Venta reporte = new Venta(inventario, carrito);
        reporte.fijarEstrategia(porVolumen); //Este método llama a aplicarDescuento.
        DescuentoPromocional promocional = new DescuentoPromocional("Granos",
                10.0);
        reporte.fijarEstrategia(promocional); //Este método llama a aplicarDescuento.
        String esperado = "1814.0";
        String resultado = reporte.totalString();
        Assertions.assertEquals(esperado, resultado, "Deberían ser iguales");
    }
}
