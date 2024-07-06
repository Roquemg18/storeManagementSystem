package ar.unrn.supermarket;

import ar.unrn.Carrito;
import ar.unrn.Inventario;
import ar.unrn.estructura.ClientesPremium;
import ar.unrn.strategy.DescuentoPorPremium;
import ar.unrn.strategy.DescuentoStrategy;
import ar.unrn.strategy.Venta;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que representa las acciones que puede realizar un cliente en el supermercado.
 */
public class AccionCliente implements AccionUsuario {
    /**
     * El Inventario del supermercado.
     */
    private Inventario inventario;

    /**
     * El carrito de compras del cliente.
     */
    private Carrito carrito;

    /**
     * Los clientes premium del supermercado.
     */
    private ClientesPremium clientes;

    /**
     * La lista de estrategias de descuento disponibles.
     */
    private ArrayList<DescuentoStrategy> descuentosList;

    /**
     * Constructor de la clase AccionCliente.
     * <p>
     * Precondición: Los parámetros inventario, carrito, clientes y descuentosList
     * deben ser válidos.
     * Postcondición: Se inicializan los atributos de la clase con los parámetros
     * proporcionados.
     *
     * @param inventario     El objeto Inventario que se utilizará en la clase.
     * @param carrito        El objeto Carrito que se utilizará en la clase.
     * @param clientes       El objeto ClientesPremium que se utilizará en la clase.
     * @param descuentosList La lista de objetos DescuentoStrategy que se utilizará
     *                       en la clase.
     */

    public AccionCliente(Inventario inventario, Carrito carrito, ClientesPremium clientes,
                         ArrayList<DescuentoStrategy> descuentosList) {
        this.inventario = inventario;
        this.carrito = carrito;
        this.clientes = clientes;
        this.descuentosList = descuentosList;
    }

    /**
     * Método que ejecuta las acciones del cliente mediante un menu.
     * <p>
     * Postcondición: Se muestra un menú de opciones al cliente y
     * se ejecuta la acción seleccionada.
     */
    @Override
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Eres cliente premium? " + "\n(0) SI" + "\n(1) NO");
        int tipoDeCliente = scanner.nextInt();
        SupermarketApp.verificarDosOpciones(tipoDeCliente);
        if (tipoDeCliente == 0) {
            ingresarComoPremium();
        }

        boolean seguirComprando = true;
        while (seguirComprando) {
            System.out.println("Ingrese 0 si quiere comprar un producto \n"
                    + "Ingrese 1 generar ticket  \n"
                    + "Ingrese 2 si volver al menu principal");
            int opcionesDelCliente = scanner.nextInt();
            SupermarketApp.verificarTresOpciones(opcionesDelCliente);
            switch (opcionesDelCliente) {
                case 0 -> clienteAcciones();
                case 1 -> {
                    seguirComprando = false;
                    Venta reporte = new Venta(inventario, carrito);
                    for (DescuentoStrategy descuento : descuentosList) {
                        reporte.fijarEstrategia(descuento);
                    }
                    System.out.println(reporte.procesarVenta());
                }
                default -> seguirComprando = false;
            }
        }
    }

    /**
     * Método que permite al cliente realizar las acciones de compra.
     * <p>
     * Precondición: Ninguna.
     * Postcondición: Se agregan productos al carrito de compras.
     */

    private void clienteAcciones() {
        Scanner scanner = new Scanner(System.in);
        boolean seguirAgregando = true;

        while (seguirAgregando) {
            System.out.println("\nLista de los productos que ofrece SUPERMARKET: \n"
                    + inventario.toString());
            System.out.println("Ingrese el nombre del producto que quiere agregar al "
                    + "carrito: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la cantidad que quiere del producto: ");
            int cantidad = scanner.nextInt();

            SupermarketApp.agregarProducto(inventario, carrito, nombre, cantidad);

            System.out.println("\nIngrese 1 si quiere agregar otro producto "
                    + "\nIngrese 0 si quiere finalizar la compra ");
            int opcionDelCliente = scanner.nextInt();
            SupermarketApp.verificarDosOpciones(opcionDelCliente);

            if (opcionDelCliente == 0) {
                seguirAgregando = false;
            }
            scanner.nextLine();
        }
    }


    /**
     * Método que permite al cliente ingresar como cliente premium.
     * <p>
     * Precondición: El objeto ClientesPremium debe ser válido.
     * Postcondición: Si el cliente es premium, se agrega una estrategia de
     * descuento por premium a la lista de descuentos.
     */

    private void ingresarComoPremium() {
        Scanner scanner = new Scanner(System.in);
        boolean seguirIntentando = true;

        while (seguirIntentando) {
            System.out.println("Ingrese su DNI: ");
            int dniUser = scanner.nextInt();
            if (clientes.verificarPremium(dniUser)) {
                DescuentoPorPremium descuentoPorPremium = new DescuentoPorPremium();
                descuentosList.add(descuentoPorPremium);
                System.out.println("Ingreso exitoso");
                seguirIntentando = false;
            } else {
                System.out.println("Ingreso erroneo" + "\nQuiere volver a intentarlo? "
                        + "\n(0) SI" + "\n(1) NO");
                int opcion = scanner.nextInt();
                SupermarketApp.verificarDosOpciones(opcion);
                if (opcion == 1) {
                    seguirIntentando = false;
                }
            }
        }
    }
}
