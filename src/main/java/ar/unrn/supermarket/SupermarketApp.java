package ar.unrn.supermarket;

import ar.unrn.Carrito;
import ar.unrn.Inventario;
import ar.unrn.Producto;
import ar.unrn.ProductoEnCarrito;
import ar.unrn.estructura.ClientesPremium;

import ar.unrn.strategy.DescuentoStrategy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal de la aplicación de Supermercado.
 */
public class SupermarketApp {
    /**
     * Lista de estrategias de descuento disponibles.
     */
    protected static ArrayList<DescuentoStrategy> descuentosList = new ArrayList<>();

    /**
     * Objeto que maneja los clientes premium del supermercado.
     */
    protected static ClientesPremium clientes = new ClientesPremium();

    /**
     * Método que verifica si el usuario que intenta ingresar es un administrador.
     * Precondición: El parámetro otraContra debe ser una contraseña válida.
     * Postcondición: Retorna true si la contraseña ingresada es la correcta,
     * false en caso contrario.
     *
     * @param otraContra La contraseña ingresada por el usuario.
     * @return true si el usuario es administrador, false en caso contrario.
     */

    public static boolean esAdministrador(String otraContra) {
        String password = "1234";
        return otraContra != null && otraContra.equals(password);
    }

    /**
     * Método que verifica si la opción ingresada por el usuario es válida.
     * Precondición: El parámetro opcion debe estar entre 0 y 1.
     * Postcondición: Si la opción no es válida, se lanza una excepción.
     *
     * @param opcion La opción ingresada por el usuario.
     * @throws IllegalStateException si la opción ingresada no es válida.
     */
    public static void verificarDosOpciones(int opcion) {
        if (opcion < 0 || opcion > 1) {
            throw new IllegalStateException("opcion ingresada no valida");
        }
    }

    /**
     * Método que verifica si la opción ingresada por el usuario es válida.
     * Precondición: El parámetro opcion debe estar entre 0 y 2.
     * Postcondición: Si la opción no es válida, se lanza una excepción.
     *
     * @param opcion La opción ingresada por el usuario.
     * @throws IllegalStateException si la opción ingresada no es válida.
     */
    public static void verificarTresOpciones(int opcion) {
        if (opcion < 0 || opcion > 2) {
            throw new IllegalStateException("opcion ingresada no valida");
        }
    }

    /**
     * Método que agrega un producto al carrito de compras.
     * Precondición: Los parámetros inventario, carrito, nombre y
     * cantidad deben ser válidos.
     * Postcondición: Se agrega el producto al carrito de compras.
     *
     * @param inventario El objeto Inventario del supermercado.
     * @param carrito    El objeto Carrito del cliente.
     * @param nombre     El nombre del producto a agregar.
     * @param cantidad   La cantidad del producto a agregar.
     * @throws IllegalArgumentException si el producto no se encuentra en el inventario.
     */
    public static void agregarProducto(Inventario inventario, Carrito carrito,
                                       String nombre, int cantidad) {
        ArrayList<Producto> almacen = inventario.obtenerProductos();
        int posicion = inventario.buscarPorNombre(nombre);
        if (posicion == -1) {
            throw new IllegalArgumentException("Producto no se ha encontrado");
        }
        carrito.agregarProducto(new ProductoEnCarrito(almacen.get(posicion), cantidad));
    }

    /**
     * Método principal de la aplicación.
     * Postcondición: Se ejecuta la aplicación de Supermercado.
     *
     * @param args Los argumentos de línea de comando.
     */
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Carrito carrito = new Carrito();
        Scanner scanner = new Scanner(System.in);
        boolean seguirEnElPrograma = true;

        System.out.println("----------BIENVENIDO A SUPERMARKET----------");

        while (seguirEnElPrograma) {
            System.out.println("Ingrese 0 si quiere ingresar como cliente \n"
                    + "Ingrese 1 si quiere acceder como administrador"
                    + "\nIngrese 2 para terminar el programa");
            int tipoDeUsuario = scanner.nextInt();
            verificarTresOpciones(tipoDeUsuario);

            AccionUsuario accionUsuario;
            if (tipoDeUsuario == 2) {
                seguirEnElPrograma = false;
            } else {
                if (tipoDeUsuario == 1) {
                    System.out.println("Para ingresar como administrado ingrese "
                            + "la contraseña: ");
                    String password = scanner.next();
                    if (!esAdministrador(password)) {
                        System.out.println("Contraseña incorrecta");
                        continue;
                    }
                    accionUsuario = new AccionAdministrador(inventario, clientes,
                            descuentosList);
                } else {
                    accionUsuario = new AccionCliente(inventario, carrito, clientes,
                            descuentosList);
                }

                accionUsuario.ejecutar();
            }
        }
    }
}