package ar.unrn.supermarket;

import ar.unrn.Inventario;
import ar.unrn.Producto;

import ar.unrn.estructura.Cliente;
import ar.unrn.estructura.ClientesPremium;
import ar.unrn.strategy.DescuentoPorVolumen;
import ar.unrn.strategy.DescuentoPromocional;
import ar.unrn.strategy.DescuentoStrategy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa las acciones que puede realizar un administrador en el supermercado.
 */
public class AccionAdministrador implements AccionUsuario {
    /**
     * El Inventario del supermercado.
     */
    private Inventario inventario;

    /**
     * Los clientes premium del supermercado.
     */
    private ClientesPremium clientes;

    /**
     * La lista de estrategias de descuento disponibles.
     */
    private ArrayList<DescuentoStrategy> descuentosList;

    /**
     * Constructor de la clase AccionAdministrador.
     * <p>
     * Precondición: Los parámetros inventario, clientes y descuentosList deben ser
     * válidos.
     * Postcondición: Se inicializan los atributos de la clase con los parámetros
     * proporcionados.
     *
     * @param inventario     El objeto Inventario que se utilizará en la clase.
     * @param clientes       El objeto ClientesPremium que se utilizará en la clase.
     * @param descuentosList La lista de objetos DescuentoStrategy que se utilizará
     *                       en la clase.
     */
    public AccionAdministrador(Inventario inventario, ClientesPremium clientes,
                               ArrayList<DescuentoStrategy> descuentosList) {
        this.inventario = inventario;
        this.clientes = clientes;
        this.descuentosList = descuentosList;
    }

    /**
     * Método que ejecuta las acciones del administrador mediante un menu.
     * <p>
     * Postcondición: Se muestra un menú de opciones al administrador y
     * se ejecuta la acción seleccionada.
     */
    @Override
    public void ejecutar() {

        Scanner scanner = new Scanner(System.in);
        boolean seguirAdministrado = true;

        while (seguirAdministrado) {
            System.out.println("Ingrese 0 si quiere crear un producto"
                    + "\nIngrese 1 si quiere crear una estrategia de descuento"
                    + "\nIngrese 2 si quiere crear un cliente premium"
                    + "\nIngrese 3 para volver al menu principal");
            int opcionesDeAdmin = scanner.nextInt();
            scanner.nextLine();

            switch (opcionesDeAdmin) {
                case 0 -> administradorCrearProducto(inventario);
                case 1 -> administradorCrearDescuento(descuentosList);
                case 2 -> administradorCrearPremium(clientes);
                default -> seguirAdministrado = false;
            }
        }
    }

    /**
     * Método que permite al administrador crear un nuevo producto en el inventario.
     * <p>
     * Precondición: El parámetro inventario debe ser un objeto Inventario válido.
     * Postcondición: Se crea un nuevo Producto y se agrega al Inventario.
     *
     * @param inventario El objeto Inventario en el que se creará el producto.
     */
    private void administradorCrearProducto(Inventario inventario) {
        Scanner scanner = new Scanner(System.in);
        boolean seguirCrando = true;

        while (seguirCrando) {
            System.out.println("\nIngrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el nombre del tipo: ");
            String tipo = scanner.nextLine();
            System.out.println("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();
            System.out.println("Ingrese el stock del producto: ");
            int stock = scanner.nextInt();

            Producto producto = new Producto(precio, nombre, tipo);
            inventario.agregarProducto(producto);
            inventario.aumentarCantidad(producto, stock);

            System.out.println("\ningrese 1 para crear otro producto: \n"
                    + "ingrese 0 para salir al menu: ");
            int opcion = scanner.nextInt();
            SupermarketApp.verificarDosOpciones(opcion);

            if (opcion == 0) {
                seguirCrando = false;
            }
            scanner.nextLine();
        }
    }


    /**
     * Método que permite al administrador crear una nueva estrategia de descuento.
     * <p>
     * Precondición: El parámetro descuentosList debe ser una lista de objetos
     * DescuentoStrategy válida.
     * Postcondición: Se crea una nueva estrategia de descuento y
     * se agrega a la lista descuentosList.
     *
     * @param descuentosList La lista de objetos DescuentoStrategy
     *                       en la que se agregará la nueva estrategia.
     */

    private void administradorCrearDescuento(ArrayList<DescuentoStrategy> descuentosList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese 0 para crear un descuento por volumen "
                + "\nIngrese 1 para crear un descuento promocional");
        int opcionDeDescuento = scanner.nextInt();
        scanner.nextLine();

        if (opcionDeDescuento == 0) {
            System.out.println("Ingrese la cantidad minima para que se aplique el "
                    + "descuento: ");
            int cantidadMinima = scanner.nextInt();
            System.out.println("Ingrese el porcentaje de descuento: ");
            double porcentaje = scanner.nextDouble();

            DescuentoPorVolumen descuentoPorVolumen =
                    new DescuentoPorVolumen(cantidadMinima, porcentaje);

            descuentosList.add(descuentoPorVolumen);

        } else if (opcionDeDescuento == 1) {
            System.out.println("Ingrese el tipo de producto al que se le aplicara el "
                    + "descuento: ");
            String tipoDelProducto = scanner.nextLine();
            System.out.println("Ingrese el porcentaje de descuento: ");
            double porcentaje = scanner.nextDouble();
            DescuentoPromocional descuentoPromocional =
                    new DescuentoPromocional(tipoDelProducto, porcentaje);
            descuentosList.add(descuentoPromocional);
        }
    }

    /**
     * Método que permite al administrador crear un nuevo cliente premium.
     * <p>
     * Precondición: El parámetro clientes debe ser un objeto ClientesPremium válido.
     * Postcondición: Se crea un nuevo Cliente y se agrega a la lista de clientes premium.
     *
     * @param clientes El objeto ClientesPremium en el que se agregará el nuevo cliente.
     */
    private void administradorCrearPremium(ClientesPremium clientes) {
        Scanner scanner = new Scanner(System.in);
        boolean seguirCrando = true;

        while (seguirCrando) {
            System.out.println("Ingrese el nombre del usuario: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el dni del usuario: ");
            int dni = scanner.nextInt();
            System.out.println("Ingrese la edad del usuario: ");
            int edad = scanner.nextInt();

            Cliente cliente = new Cliente(nombre, dni, edad);
            clientes.agregar(cliente);

            System.out.println("\ningrese 1 para crear otro cliente: \n"
                    + "ingrese 0 para salir al menu: ");
            int opcion = scanner.nextInt();
            SupermarketApp.verificarDosOpciones(opcion);

            if (opcion == 0) {
                seguirCrando = false;
            }
            scanner.nextLine();
        }
    }
}
