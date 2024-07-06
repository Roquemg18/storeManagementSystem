package ar.unrn.strategy;

import ar.unrn.ProductoEnCarrito;

/**
 * Clase que implementa la estrategia de descuento para clientes premium.
 */
public class DescuentoPorPremium implements DescuentoStrategy {

    /**
     * Porcentaje de descuento aplicado a los productos.
     */
    private double porcentajeDescuento;

    /**
     * Constructor que inicializa el porcentaje de descuento.
     * Precondiciones: ninguna.
     * Postcondiciones: se crea una instancia de DescuentoPorPremium con un
     * porcentaje de descuento del 5%.
     */
    public DescuentoPorPremium() {
        this.porcentajeDescuento = 5;
    }

    /**
     * Aplica un descuento a un producto en el carrito.
     * Precondiciones: producto no debe ser null.
     * Postcondiciones: se devuelve el precio con descuento aplicado.
     *
     * @param producto Producto sobre el cual aplicar el descuento.
     * @return El precio del producto después de aplicar el descuento.
     */
    @Override
    public double aplicarDescuento(ProductoEnCarrito producto) {
        double resultado = producto.calcularPrecio() * (porcentajeDescuento / 100);
        return resultado;
    }

    /**
     * Devuelve una representación en cadena del descuento aplicado a un producto
     * en el carrito.
     * Precondiciones: producto no debe ser null.
     * Postcondiciones: se devuelve una cadena describiendo el descuento aplicado.
     *
     * @param producto Producto sobre el cual describir el descuento.
     * @return Una cadena describiendo el descuento aplicado al producto.
     */
    @Override
    public String toString(ProductoEnCarrito producto) {
        StringBuilder sb = new StringBuilder();
        if (aplicarDescuento(producto) > 0) {
            sb.append(aplicarDescuento(producto));
        }
        return sb.toString();
    }

    /**
     * Devuelve el nombre del descuento.
     * Postcondiciones: se devuelve el nombre del descuento.
     *
     * @return El nombre del descuento.
     */
    @Override
    public String nombreDescuento() {
        return "Descuento por premium";
    }
}
