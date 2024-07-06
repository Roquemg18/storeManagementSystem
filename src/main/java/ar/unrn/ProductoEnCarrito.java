package ar.unrn;

import ar.unrn.excepciones.ParametroNoValidoException;

/**
 * Esta clase representa los productos que se almacenan en el carrito del supermercado.
 */
public class ProductoEnCarrito {
    /**
     * Producto que se encuentra en el carrito.
     */
    private Producto producto;
    //Intentamos cambiar esto para que la clase extienda de Producto, pero nos generó
    // muchos problemas y no teníamos tanto tiempo para resolverlo.
    /**
     * Cantidad del producto en el carrito.
     */
    private Integer cantidad;

    /**
     * Este constructor público toma como argumento un objeto de tipo Producto y una
     * variable de tipo Integer para instanciar los atributos producto y cantidad
     * respectivamente.
     * POST: Los atributos de la clase pasarán a almacenar las variables pasadas como
     * argumentos.
     *
     * @param producto es el objeto de tipo Producto que se desea almacenar en el objeto
     * @param cantidad es la variable de tipo Integer que se desea almacenar en el
     *                 objeto
     * @throws ParametroNoValidoException cuando la cantidad dada es menor a 0.
     */
    public ProductoEnCarrito(Producto producto, Integer cantidad)
            throws ParametroNoValidoException {
        if (cantidad < 0) {
            throw new ParametroNoValidoException("Cantidad negativa");
        }

        this.producto = producto;
        this.cantidad = cantidad;
    }

    /**
     * Este método devuelve la multiplicación del precio almacenado en el Producto del
     * objeto con la cantidad almacenada en este objeto.
     *
     * @return Devuelve el resultado de multiplicar el precio del Producto con la
     * cantidad dentro de este objeto.
     */
    public double calcularPrecio() {
        return producto.determinarPrecio(cantidad);
    }

    /**
     * Este método recibe un String que representa el tipo de otro Producto y lo
     * compara con el tipo del Producto almacenado en este objeto, con el método dentro
     * del mismo.
     *
     * @param otroTipo es un String que representa el tipo de otro Producto
     * @return devolverá true en caso de que el tipo pasado como argumento sea igual al
     * tipo del producto almacenado en este objeto. Devolverá false en caso contrario.
     */
    public boolean compararTipoEnCarrito(String otroTipo) {
        boolean resultado = false;
        if (producto.compararTipo(otroTipo)) {
            resultado = true;
        }
        return resultado;
    }

    /**
     * Este método recibe un número entero que representa la canitdad mínima de un
     * producto para cumplir cierto requisito. Devuelve 1 en caso de que la cantidad
     * almacenada en este objeto sea mayor a la cantidad pasada como argumento, -1 en
     * caso contrario y 0 en caso de que sean iguales.
     *
     * @param cantidadMinima es un número entero que representa la cantidad mínima que
     *                       se necesita de un producto para cumplir cierto requisito.
     * @return Devolverá 1 si la cantidad almacenada en este objeto es mayor a la
     * pasada como argumento, -1 si es menor y 0 si son iguales.
     */
    public int comparaCantidad(int cantidadMinima) {
        int resultado = 0;
        if (this.cantidad > cantidadMinima) {
            resultado = 1;
        } else if (this.cantidad < cantidadMinima) {
            resultado = -1;
        }
        return resultado;
    }

    /**
     * Este método devuelve una variable booleana que indica si la cantidad dentro del
     * objeto es menor al stock del Producto.
     *
     * @return Devolverá true en caso de que el método disponibilidad de Producto
     * devuelva true, es decir, cuando la cantidad almacenada dentro de este objeto sea
     * menor o igual al stock del producto almacenado dentro del mismo. En caso
     * contrario, devolverá false.
     */
    public boolean verificarStock() {
        return producto.disponibilidad(cantidad);
    }

    /**
     * Este método devuelve un String que representa este objeto de tipo
     * ProductoEnCarrito.
     *
     * @return Devuelve un String que representa este objeto de tipo ProductoEnCarrito.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(producto.ticketStringProduct());
        builder.append(", Cantidad : " + cantidad);

        return builder.toString();
    }

    /**
     * Este método recibe la referencia a un inventario para disminuir el Producto
     * almacenado en este objeto del inventario en la cantidad almacenada por este
     * mismo objeto.
     *
     * @param inventario es la referencia al inventario con el que se está trabajando.
     */
    public void actualizarInventario(Inventario inventario) {
        inventario.disminuirCantidad(producto, cantidad);
    }
}