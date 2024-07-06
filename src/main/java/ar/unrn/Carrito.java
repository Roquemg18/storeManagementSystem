package ar.unrn;

import ar.unrn.excepciones.ParametroNoValidoException;

import java.util.ArrayList;

/**
 * Clase que representa un carrito de productosEnCarrito.
 * Proporciona métodos para agregar, eliminar, obtenerCarrito, largo, calcularTotal y
 * toString.
 */
public class Carrito {
    /**
     * El ArrayList que contiene los ProductoEnCarrito en el carrito.
     * Postcondición: El carrito se inicializa como un ArrayList vacío.
     */
    private ArrayList<ProductoEnCarrito> carrito;

    /**
     * Constructor de la clase Carrito.
     * Inicializa el ArrayList carrito.
     * Postcondición: Se crea una nueva instancia de Carrito con un ArrayList
     * carrito vacío.
     */
    public Carrito() {
        this.carrito = new ArrayList<>();
    }

    /**
     * Busca la posición de un ProductoEnCarrito en el carrito.
     * Precondición: El parámetro producto debe ser un ProductoEnCarrito válido.
     * Postcondición: Devuelve la posición del ProductoEnCarrito en el carrito,
     * o -1 si no se encuentra.
     *
     * @param producto El ProductoEnCarrito a buscar en el carrito.
     * @return La posición del ProductoEnCarrito en el carrito, o -1 si no se encuentra.
     */
    private int buscarProductoEnCarrito(ProductoEnCarrito producto) {
        int resultado = -1;
        for (int i = 0; i < carrito.size(); i++) {
            if (carrito.get(i).equals(producto)) {
                resultado = i;
            }
        }
        return resultado;
    }

    /**
     * Agrega un ProductoEnCarrito al carrito.
     * Precondición: El parámetro producto debe ser un ProductoEnCarrito válido.
     * Postcondición: El ProductoEnCarrito se agrega al carrito.
     *
     * @param producto El ProductoEnCarrito a agregar al carrito.
     */
    public void agregarProducto(ProductoEnCarrito producto) {
        carrito.add(producto);
    }

    /**
     * Elimina un ProductoEnCarrito del carrito.
     * Precondición: El parámetro producto debe ser un ProductoEnCarrito válido y
     * estar en el carrito.
     * Postcondición: El ProductoEnCarrito se elimina del carrito.
     *
     * @param producto El ProductoEnCarrito a eliminar del carrito.
     * @throws ParametroNoValidoException Si el ProductoEnCarrito no se encuentra
     *                                    en el carrito.
     */
    public void eliminarProducto(ProductoEnCarrito producto)
            throws ParametroNoValidoException {
        int posicion = buscarProductoEnCarrito(producto);

        if (posicion == -1) {
            throw new ParametroNoValidoException("No se encontró el producto");
        }

        carrito.remove(producto);
    }

    /**
     * Devuelve una copia del carrito.
     * Precondición: Ninguna.
     * Postcondición: Se devuelve una nueva instancia de ArrayList<ProductoEnCarrito>
     * con los mismos elementos que carrito.
     *
     * @return Una nueva instancia de ArrayList<ProductoEnCarrito>
     * con los mismos elementos que carrito.
     */
    public ArrayList<ProductoEnCarrito> obtenerCarrito() {
        return new ArrayList<>(carrito);
    }

    /**
     * Devuelve el número de elementos en el carrito.
     * Postcondición: Se devuelve un entero que representa la cantidad de elementos
     * en el carrito.
     *
     * @return Un entero que representa la cantidad de elementos en el carrito.
     */
    public int largo() {
        return carrito.size();
    }

    /**
     * Calcula el subtotal del carrito sumando los precios de todos los ProductoEnCarrito
     * Postcondición: Se devuelve un valor double que representa el subtotal del carrito.
     *
     * @return Un valor double que representa el subtotal del carrito.
     */
    public double calcularSubTotal() {
        double total = 0.0;
        for (int i = 0; i < carrito.size(); i++) {
            ProductoEnCarrito producto = carrito.get(i);
            total = total + producto.calcularPrecio();
        }
        return total;
    }

    /**
     * Devuelve una representación en cadena de texto del carrito.
     * Postcondición: Se devuelve una cadena de texto que representa el carrito.
     *
     * @return Una cadena de texto que representa el carrito.
     */
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("[");
        for (int i = 0; i < largo(); i++) {
            ProductoEnCarrito producto = carrito.get(i);
            cadena.append(producto.toString());
            if (i < (largo() - 1)) {
                cadena.append("\n");
            }
        }
        cadena.append("]");
        return cadena.toString();
    }
}

