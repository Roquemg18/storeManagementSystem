package ar.unrn;

import ar.unrn.excepciones.ElementoNullException;
import ar.unrn.excepciones.ParametroNoValidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Test para métodos de la clase Inventario")
class InventarioTest {

    @Test
    @DisplayName("test del metodo agregar productos")
    void testInventarioAgregarProducto() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        Producto producto2 = new Producto(10, "pan", "panaderia");
        Producto producto3 = new Producto(18, "facturas", "panaderia");

        productos.agregarProducto(producto1);
        productos.agregarProducto(producto2);
        productos.agregarProducto(producto3);


        Assertions.assertEquals(productos.largo(), 3);
    }

    @Test
    @DisplayName("test agregar product y aumentar cantidad")
    void testInventarioAgregarYaumentarCantidad() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        int cantidad = 3;

        productos.agregarProducto(producto1, cantidad);

        Assertions.assertEquals(productos.imprimirProducto(producto1),
                "Producto: Nombre: coca, Tipo: gaseosas, Stock: 3, Precio: 12.0");
    }

    @Test
    @DisplayName("eliminar producto del inventanrio")
    void testInventarioEliminarProducto() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        Producto producto2 = new Producto(10, "pan", "panaderia");
        Producto producto3 = new Producto(18, "facturas", "panaderia");

        productos.agregarProducto(producto1);
        productos.agregarProducto(producto2);
        productos.agregarProducto(producto3);
        //hay 3 productos en el inventario

        //elimina el producto
        productos.eliminarProducto(producto1);
        Assertions.assertEquals(productos.largo(), 2);

    }

    @Test
    @DisplayName("aumentar la cantidad de un producto en el inventario")
    void testInventarioAumentarCantidad() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        productos.agregarProducto(producto1, 5);


        //aumento la cantidad de un producto en el inventario
        productos.aumentarCantidad(producto1, 10);

        String expected = "Producto: Nombre: coca, Tipo: gaseosas, Stock: 15, Precio: "
                + "12.0";
        Assertions.assertEquals(expected, productos.imprimirProducto(producto1));
    }

    @Test
    @DisplayName("aumentar la cantidad de un producto en el inventario con parametro "
            + "negativo")
    void testInventarioAumentarCantidadNegativo() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        productos.agregarProducto(producto1, 5);
        int cantidad = -1;
        try {
            productos.aumentarCantidad(producto1, cantidad);
            fail("Se esperaba ParametroNoValidoException");
        } catch (ParametroNoValidoException e) {
            System.out.println("parametro menor a 0");
        }
    }


    @Test
    @DisplayName("disminuir la cantidad de un producto en el inventario")
    void testInventarioDisminuirCantidad() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        productos.agregarProducto(producto1, 5);

        //disminuye la cantidad de un producto en el inventario
        productos.disminuirCantidad(producto1, 2);
        String expectedModificacion = "Producto: Nombre: coca, Tipo: gaseosas, Stock: "
                + "3, Precio: 12.0";
        Assertions.assertEquals(expectedModificacion,
                productos.imprimirProducto(producto1));
    }

    @Test
    @DisplayName("disminuir la cantidad de un producto en el inventario con parametro "
            + "negativo")
    void testInventarioDisminuirLaCantidadNegativo() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        productos.agregarProducto(producto1, 5);
        int cantidad = -1;
        try {
            productos.disminuirCantidad(producto1, cantidad);
            fail("Se esperaba ParametroNoValidoException");
        } catch (ParametroNoValidoException e) {
            System.out.println("parametro menor a 0");
        }
    }


    @Test
    @DisplayName("imprimir un producto en el inventario")
    void testInventarioImprimirProducto() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        productos.agregarProducto(producto1, 5);
        String expected = "Producto: Nombre: coca, Tipo: gaseosas, Stock: 5, Precio: 12"
                + ".0";

        Assertions.assertEquals(expected, productos.imprimirProducto(producto1));

    }

    @Test
    @DisplayName("imprimir un producto en el inventario con un producto null")
    void testInventarioImprimirProductoNull() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        productos.agregarProducto(producto1, 5);

        try {
            productos.imprimirProducto(null);
        } catch (ElementoNullException e) {
            System.out.println("producto igual a null");
        }
    }

    @Test
    @DisplayName("test metodo toString")
    void testInventarioToString() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        Producto producto2 = new Producto(10, "pan", "panaderia");
        Producto producto3 = new Producto(18, "facturas", "panaderia");

        productos.agregarProducto(producto1, 3);
        productos.agregarProducto(producto2, 3);
        productos.agregarProducto(producto3, 3);

        StringBuilder builder = new StringBuilder();
        builder.append("Producto: Nombre: coca, Tipo: gaseosas, Stock: 3, Precio: 12"
                + ".0");
        builder.append("\nProducto: Nombre: pan, Tipo: panaderia, Stock: 3, "
                + "Precio: 10.0");
        builder.append("\nProducto: Nombre: facturas, Tipo: panaderia, Stock: 3, "
                + "Precio: 18.0");
        builder.append("\n");

        Assertions.assertEquals(builder.toString(), productos.toString());
    }

    @Test
    @DisplayName("test metodo largo de inventario")
    void testInventarioLargo() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        Producto producto2 = new Producto(10, "pan", "panaderia");
        Producto producto3 = new Producto(18, "facturas", "panaderia");

        productos.agregarProducto(producto1);
        productos.agregarProducto(producto2);
        productos.agregarProducto(producto3);

        Assertions.assertEquals(productos.largo(), 3);
    }


    @Test
    @DisplayName("test metodo verificar disponibilidad de inventario - True")
    void testInventarioVerificarDisponibilidad() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");

        productos.agregarProducto(producto1,
                10); //10 es el stock

        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(producto1, 5);
        //se pide 5 y se verifica si hay esa cantidad disponible en stock
        Assertions.assertTrue(productos.verificarDisponibilidad(productoEnCarrito));
    }

    @Test
    @DisplayName("test metodo verificar disponibilidad de inventario - False")
    void testInventarioVerificarDisponibilidadFalse() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");

        productos.agregarProducto(producto1, 10); //10 es el stock

        ProductoEnCarrito productoEnCarrito = new ProductoEnCarrito(producto1,
                15);
        //se pide 5 y se verifica si hay esa cantidad disponible en stock
        Assertions.assertFalse(productos.verificarDisponibilidad(productoEnCarrito));
    }

    @Test
    @DisplayName("aumentar el precio de un producto en el inventario")
    void testInventarioAumentarPrecio() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        productos.agregarProducto(producto1, 5);


        //aumenta el precio de un producto en el inventario
        productos.aumentarPrecio(producto1, 20);
        String expectedModificacion = "Producto: Nombre: coca, Tipo: gaseosas, Stock: "
                + "5, Precio: 32.0";
        Assertions.assertEquals(expectedModificacion,
                productos.imprimirProducto(producto1));
    }

    @Test
    @DisplayName("aumentar el precio de un producto en el inventario con parametro "
            + "negativo")
    void testInventarioAumentarPrecioNegativo() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        productos.agregarProducto(producto1, 5);
        int precio = -1;
        try {
            productos.aumentarPrecio(producto1, precio);
            fail("Se esperaba ParametroNoValidoException");
        } catch (ParametroNoValidoException e) {
            System.out.println("parametro menor a 0");
        }
    }

    @Test
    @DisplayName("disminuir el precio de un producto en el inventario")
    void testInventarioDisminuirPrecio() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        productos.agregarProducto(producto1, 5);

        //aumenta el precio de un producto en el inventario
        productos.disminuirPrecio(producto1, 5);
        String expectedModificacion = "Producto: Nombre: coca, Tipo: gaseosas, Stock: "
                + "5, Precio: 7.0";
        Assertions.assertEquals(expectedModificacion,
                productos.imprimirProducto(producto1));
    }

    @Test
    @DisplayName("Disminuir el precio de un producto en el inventario con parametro "
            + "negativo")
    void testInventarioDisminuirPrecioNegativo() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        productos.agregarProducto(producto1, 5);
        int precio = -1;
        try {
            productos.disminuirPrecio(producto1, precio);
            fail("Se esperaba ParametroNoValidoException");
        } catch (ParametroNoValidoException e) {
            System.out.println("parametro menor a 0");
        }
    }

    @Test
    @DisplayName("test metodo obtenerInventario")
    void testInventarioObtenerInventario() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");
        Producto producto2 = new Producto(10, "pan", "panaderia");

        productos.agregarProducto(producto1);
        productos.agregarProducto(producto2);

        ArrayList<Producto> otrosProductos = productos.obtenerProductos();
        StringBuilder sb = new StringBuilder();
        sb.append("[" + producto1 + ", ");
        sb.append(producto2 + "]");
        String expected = sb.toString();
        Assertions.assertEquals(expected, otrosProductos.toString());

    }

    @Test
    @DisplayName("test inventario metodo buscarPorNombre ")
    void testInventarioBuscarPorNombre() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");

        productos.agregarProducto(producto1);

        String nombre = "coca";

        Assertions.assertEquals(0, productos.buscarPorNombre(nombre));

    }

    @Test
    @DisplayName("test inventario metodo buscarPorNombre nombre inexistente")
    void testInventarioBuscarPorNombreInexistente() {
        Inventario productos = new Inventario();
        Producto producto1 = new Producto(12, "coca", "gaseosas");

        productos.agregarProducto(producto1);

        String nombre = "pepsi";

        Assertions.assertEquals(-1, productos.buscarPorNombre(nombre));

    }

}
