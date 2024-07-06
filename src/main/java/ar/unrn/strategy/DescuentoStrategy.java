package ar.unrn.strategy;

import ar.unrn.ProductoEnCarrito;

/**
 * Interfaz que define el comportamiento para aplicar descuentos a productos en
 * el carrito.
 */
public interface DescuentoStrategy {
    /**
     * Aplica un descuento a un producto en el carrito.
     * Precondiciones: producto no debe ser null.
     * Postcondiciones: se devuelve el precio con descuento aplicado.
     *
     * @param producto Producto sobre el cual aplicar el descuento.
     * @return El precio del producto después de aplicar el descuento.
     */
    double aplicarDescuento(ProductoEnCarrito producto);

    /**
     * Devuelve una representación en cadena del descuento aplicado a un producto en
     * el carrito.
     * Precondiciones: producto no debe ser null.
     * Postcondiciones: se devuelve una cadena describiendo el descuento aplicado.
     *
     * @param producto Producto sobre el cual describir el descuento.
     * @return Una cadena describiendo el descuento aplicado al producto.
     */
    String toString(ProductoEnCarrito producto);

    /**
     * Devuelve el nombre del descuento.
     * Precondiciones: ninguna.
     * Postcondiciones: se devuelve el nombre del descuento.
     *
     * @return El nombre del descuento.
     */
    String nombreDescuento();

}
