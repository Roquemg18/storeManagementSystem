package ar.unrn.strategy;

import ar.unrn.Carrito;
import ar.unrn.Inventario;
import ar.unrn.ProductoEnCarrito;
import ar.unrn.excepciones.ParametroNoValidoException;

/**
 * Esta clase almacena los atributos y métodos que se utilizarán para realizar una
 * venta en nuestro supermercado.
 */
public class Venta {
    /**
     * Almacen donde se guardan los productos del supermercado.
     */
    private Inventario almacen;
    /**
     * Carrito en donde se guardan los productos que se desean comparar.
     */
    private Carrito carrito;
    /**
     * Variable en donde se guarda el total de la venta.
     */
    private double total;
    /**
     * Cadena en donde se concatenarán los distintos descuentos que se apliquen.
     */
    private StringBuilder sb;
    /**
     * Estrategia de descuento que se utilizará en la venta.
     */
    private DescuentoStrategy descuentoStrategy;

    /**
     * Este constructor público recibe como argumento un objeto de tipo Inventario y
     * uno de tipo Carrito para instanciar los atributos almacen y carrito almacenados
     * dentro de esta clase. Inicializa el atributo total con el subtotal calculado del
     * carrito y el atributo sb como un nuevo StringBuilder.
     *
     * @param almacen es el objeto de tipo Inventario que se almacenará en el atributo
     *                almacen dentro de esta clase.
     * @param carrito es el objeto de tipo Carrito que se almacenará en el atributo
     *                carrito dentro de esta clase.
     */
    public Venta(Inventario almacen, Carrito carrito) {
        this.almacen = almacen;
        this.carrito = carrito;
        this.total = carrito.calcularSubTotal();
        this.sb = new StringBuilder();
    }

    /**
     * Este método recibe un objeto de tipo DescuentoStrategy para almacenarlo en el
     * atributo descuentoStrategy de este objeto y luego aplicar el descuento y
     * actualizar el StringBuilder guardado en este mismo objeto.
     *
     * @param descuentoStrategy es la estrategia de descuento que se desea utilizar en
     *                          la venta.
     */
    public void fijarEstrategia(DescuentoStrategy descuentoStrategy) {
        this.descuentoStrategy = descuentoStrategy;
        aplicarDescuento();
        descuentoSting();
    }

    /**
     * Este método se encarga de aplicarle el descuento indicado por el atributo
     * descuentoStrategy almacenado en este objeto a todos los elementos dentro del
     * carrito que cumplan con los requisitos.
     */
    public void aplicarDescuento() {
        double descuento = 0;
        for (ProductoEnCarrito producto : carrito.obtenerCarrito()) {
            if (descuentoStrategy != null) {
                descuento = descuentoStrategy.aplicarDescuento(producto);
                this.total = total - descuento;
            }
        }
    }

    /**
     * Este método actualiza el StringBuilder almacenado en este objeto agregando el
     * nombre del descuento que se está utilizando y el importe del mismo.
     */
    private void descuentoSting() {
        for (ProductoEnCarrito producto : carrito.obtenerCarrito()) {
            if (descuentoStrategy != null) {
                if (descuentoStrategy.toString(producto) != "") {
                    sb.append(descuentoStrategy.nombreDescuento() + ": ");
                    sb.append(descuentoStrategy.toString(producto) + "\n");
                }
            }
        }
    }

    /**
     * Este método devuelve un String que representa el atributo total almacenado en
     * este objeto.
     *
     * @return retornará un String que representa el atributo total almacenado en este
     * objeto.
     */
    public String totalString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.total);
        return builder.toString();
    }

    /**
     * Este método se encarga de procesar la venta que se está realizando, es decir,
     * asegurarse de que los productos pedidos estén disponibles, actualizar el
     * inventario, llamar a la función que genera un ticket y vaciar el carrito al final.
     *
     * @return Devolverá el String que devuelva el método generarTicket, es decir,
     * devolverá un String que represente el ticket de la compra realizada.
     * @throws ParametroNoValidoException cuando el Producto solicitado o la cantidad
     *                                    solicitada no se encuentran disponibles en
     *                                    el almacen.
     */
    public String procesarVenta() throws ParametroNoValidoException {
        for (ProductoEnCarrito producto : carrito.obtenerCarrito()) {

            boolean productoEnAlmacen = almacen.verificarDisponibilidad(producto);

            if (!productoEnAlmacen) {
                throw new ParametroNoValidoException("La cantidad deseada del producto "
                        + "no esta disponible");
            }

            producto.actualizarInventario(almacen);

        }

        String resultado = generarTicket();
        carrito = new Carrito(); // Vaciar el carrito después de la venta
        return resultado;
    }

    /**
     * Este método devuelve un String que representa el ticket de la compra realizada.
     *
     * @return Devolverá un String que representa el ticket de la compra realizada.
     */
    private String generarTicket() {
        StringBuilder builder = new StringBuilder();

        builder.append("----- Ticket de Compra -----\n");

        for (ProductoEnCarrito producto : carrito.obtenerCarrito()) {
            builder.append(producto + "\n");
        }

        double subTotal = carrito.calcularSubTotal();
        builder.append("subTotal: " + subTotal + "\n");
        builder.append("---------Descuento--------\n");


        builder.append(sb.toString() + "\n");

        builder.append("---------Total--------\n");
        builder.append("Total: " + (totalString()) + "\n");
        builder.append("----------------------------\n");

        return builder.toString();
    }
}

