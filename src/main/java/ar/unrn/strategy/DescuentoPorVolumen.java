package ar.unrn.strategy;


import ar.unrn.ProductoEnCarrito;
import ar.unrn.excepciones.ParametroNoValidoException;

/**
 * Clase que implementa la estrategia de descuento por volumen.
 */
public class DescuentoPorVolumen implements DescuentoStrategy {

    /**
     * Cantidad mínima de productos para aplicar el descuento.
     */
    private int cantidadMinima;

    /**
     * Porcentaje de descuento aplicado a los productos.
     */
    private double porcentajeDescuento;

    /**
     * Constructor que inicializa la cantidad mínima y el porcentaje de descuento.
     * Precondiciones: cantidadMinima y porcentajeDescuento no deben ser negativos.
     * Postcondiciones: se crea una instancia de DescuentoPorVolumen con los valores
     * proporcionados.
     *
     * @param cantidadMinima      Cantidad mínima de productos para aplicar el descuento.
     * @param porcentajeDescuento Porcentaje de descuento aplicado.
     * @throws ParametroNoValidoException Si cantidadMinima o porcentajeDescuento
     *                                    son negativos.
     */
    public DescuentoPorVolumen(int cantidadMinima, double porcentajeDescuento)
            throws ParametroNoValidoException {
        if (cantidadMinima < 0) {
            throw new ParametroNoValidoException("cantidad minima negativa");
        }
        if (porcentajeDescuento < 0) {
            throw new ParametroNoValidoException("porcentaje descuento negativo");
        }

        this.cantidadMinima = cantidadMinima;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    /**
     * Aplica un descuento a un producto en el carrito si la cantidad mínima es alcanzada.
     * Precondiciones: producto no debe ser null.
     * Postcondiciones: se devuelve el precio con descuento aplicado, si se cumple la
     * cantidad mínima.
     *
     * @param producto Producto sobre el cual aplicar el descuento.
     * @return El precio del producto después de aplicar el descuento, o 0 si no se
     * cumple la cantidad mínima.
     */
    @Override
    public double aplicarDescuento(ProductoEnCarrito producto) {
        double resultado = 0;

        if (producto.comparaCantidad(cantidadMinima) != -1) {
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
        return "Descuento por volumen";
    }
}
