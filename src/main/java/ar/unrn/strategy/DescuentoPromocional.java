package ar.unrn.strategy;


import ar.unrn.ProductoEnCarrito;
import ar.unrn.excepciones.ParametroNoValidoException;

/**
 * Clase que implementa la estrategia de descuento por promocional.
 */
public class DescuentoPromocional implements DescuentoStrategy {
    /**
     * Porcentaje de descuento aplicado a los productos.
     */
    private double porcentajeDescuento;

    /**
     * Tipo del producto para aplicar el descuento.
     */
    private String tipo;

    /**
     * Constructor que inicializa el tipo y el porcentaje de descuento.
     * Precondiciones: porcentajeDescuento no deben ser negativos.
     * Tipo no deb ser null.
     * Postcondiciones: se crea una instancia de DescuentoPorVolumen con los valores
     * proporcionados.
     *
     * @param tipo                tipo del producto para aplicar el descuento.
     * @param porcentajeDescuento Porcentaje de descuento aplicado.
     * @throws ParametroNoValidoException Si porcentajeDescuento es negativo.
     */
    public DescuentoPromocional(String tipo, double porcentajeDescuento)
            throws ParametroNoValidoException {
        if (porcentajeDescuento < 0) {
            throw new ParametroNoValidoException("porcentaje descuento negativo");
        }
        this.porcentajeDescuento = porcentajeDescuento;
        this.tipo = tipo;
    }

    /**
     * Aplica un descuento a un producto en el carrito si el tipo es igual.
     * Precondiciones: producto no debe ser null.
     * Postcondiciones: se devuelve el precio con descuento aplicado, si se cumple que
     * el tipo del producto es igual.
     *
     * @param producto Producto sobre el cual aplicar el descuento.
     * @return El precio del producto después de aplicar el descuento.
     */
    @Override
    public double aplicarDescuento(ProductoEnCarrito producto) {
        double resultado = 0;

        if (producto.compararTipoEnCarrito(tipo)) {
            resultado = producto.calcularPrecio() * (porcentajeDescuento / 100);
        }

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
        return "Descuento por promocion";
    }
}
