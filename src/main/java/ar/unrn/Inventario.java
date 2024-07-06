package ar.unrn;

import ar.unrn.excepciones.ElementoNullException;
import ar.unrn.excepciones.ParametroNoValidoException;

import java.util.ArrayList;


/**
 * Clase que representa un inventario de productos.
 * Proporciona métodos para agregar, eliminar, y gestionar productos en el inventario.
 */
public class Inventario {

    /**
     * Lista que contiene los productos en el inventario.
     */
    private ArrayList<Producto> inventario;

    /**
     * Constructor que inicializa la lista de productos.
     * Precondiciones: ninguna.
     * Postcondiciones: se crea una instancia de Inventario con una lista vacía
     * de productos.
     */
    public Inventario() {
        this.inventario = new ArrayList<>();
    }

    /**
     * Agrega un producto al inventario.
     * Precondiciones: producto no debe ser null.
     * Postcondiciones: el producto es añadido al inventario.
     *
     * @param producto Producto a agregar.
     */
    public void agregarProducto(Producto producto) {
        inventario.add(producto);
    }

    /**
     * Agrega una cantidad específica de un producto al inventario.
     * Precondiciones: producto no debe ser null, cantidad debe ser mayor o igual a 0.
     * Postcondiciones: el producto es añadido al inventario con la cantidad especificada.
     *
     * @param producto Producto a agregar.
     * @param cantidad Cantidad a agregar.
     */
    public void agregarProducto(Producto producto, int cantidad) {
        inventario.add(producto);
        aumentarCantidad(producto, cantidad);
    }

    /**
     * Elimina un producto del inventario.
     * Precondiciones: producto debe existir en el inventario.
     * Postcondiciones: el producto es eliminado del inventario.
     *
     * @param producto Producto a eliminar.
     */
    public void eliminarProducto(Producto producto) {
        inventario.remove(producto);
    }

    /**
     * Aumenta la cantidad de un producto en el inventario.
     * Precondiciones: producto debe existir en el inventario, cantidad debe ser
     * mayor que 0.
     * Postcondiciones: la cantidad del producto en el inventario es aumentada.
     *
     * @param producto Producto cuyo stock aumentar.
     * @param cantidad Cantidad a aumentar.
     * @throws ParametroNoValidoException si la cantidad es menor que cero.
     */
    public void aumentarCantidad(Producto producto, int cantidad)
            throws ParametroNoValidoException {
        verificarParametro(cantidad);
        int posicion = buscarProductoEnInventario(producto);
        inventario.get(posicion).aumentarStock(cantidad);
    }

    /**
     * Disminuye la cantidad de un producto en el inventario.
     * Precondiciones: producto debe existir en el inventario, cantidad
     * debe ser mayor que 0.
     * Postcondiciones: la cantidad del producto en el inventario es disminuida.
     *
     * @param producto Producto cuyo stock disminuir.
     * @param cantidad Cantidad a disminuir.
     * @throws ParametroNoValidoException si la cantidad es menor que cero.
     */
    public void disminuirCantidad(Producto producto, int cantidad)
            throws ParametroNoValidoException {
        verificarParametro(cantidad);
        int posicion = buscarProductoEnInventario(producto);
        inventario.get(posicion).disminuirStock(cantidad);
    }

    /**
     * Imprime los detalles de un producto específico del inventario.
     * Precondiciones: producto no debe ser null y debe existir en el inventario.
     * Postcondiciones: se devuelve una cadena con los detalles del producto.
     *
     * @param producto Producto a imprimir.
     * @return Una cadena con los detalles del producto.
     * @throws ElementoNullException si el producto es null.
     */
    public String imprimirProducto(Producto producto) throws ElementoNullException {
        if (producto == null) {
            throw new ElementoNullException("producto igual a null");
        }
        int posicion = buscarProductoEnInventario(producto);
        return inventario.get(posicion).toString();
    }

    /**
     * Imprime todos los productos en el inventario.
     * Precondiciones: ninguna.
     * Postcondiciones: se devuelve una cadena con los detalles de todos los productos.
     *
     * @return Una cadena con los detalles de todos los productos.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Producto producto : inventario) {
            builder.append(producto.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * Devuelve el número de productos en el inventario.
     * Precondiciones: ninguna.
     * Postcondiciones: se devuelve el tamaño del inventario.
     *
     * @return El tamaño del inventario.
     */
    public int largo() {
        return inventario.size();
    }

    /**
     * Verifica la disponibilidad de un producto en el inventario.
     * Precondiciones: producto no debe ser null.
     * Postcondiciones: se devuelve true si el producto está disponible,
     * false en caso contrario.
     *
     * @param producto Producto en el carrito para verificar.
     * @return true si el producto está disponible, false en caso contrario.
     */
    public boolean verificarDisponibilidad(ProductoEnCarrito producto) {
        return producto.verificarStock();
    }

    /**
     * Aumenta el precio de un producto en el inventario.
     * Precondiciones: producto debe existir en el inventario, valor debe ser mayor que 0.
     * Postcondiciones: el precio del producto en el inventario es aumentado.
     *
     * @param producto Producto cuyo precio aumentar.
     * @param valor    Valor a aumentar.
     * @throws ParametroNoValidoException si el valor es menor que cero.
     */
    public void aumentarPrecio(Producto producto, int valor)
            throws ParametroNoValidoException {
        verificarParametro(valor);
        int posicion = buscarProductoEnInventario(producto);
        inventario.get(posicion).aumentarPrecio(valor);
    }

    /**
     * Disminuye el precio de un producto en el inventario.
     * Precondiciones: producto debe existir en el inventario, valor debe ser mayor que 0.
     * Postcondiciones: el precio del producto en el inventario es disminuido.
     *
     * @param producto Producto cuyo precio disminuir.
     * @param valor    Valor a disminuir.
     * @throws ParametroNoValidoException si el valor es menor que cero.
     */
    public void disminuirPrecio(Producto producto, int valor)
            throws ParametroNoValidoException {
        verificarParametro(valor);
        int posicion = buscarProductoEnInventario(producto);
        inventario.get(posicion).disminuirPrecio(valor);
    }

    /**
     * Devuelve una lista de todos los productos en el inventario.
     * Precondiciones: ninguna.
     * Postcondiciones: se devuelve una nueva lista que contiene todos
     * los productos del inventario.
     *
     * @return Lista de productos.
     */
    public ArrayList<Producto> obtenerProductos() {
        return new ArrayList<>(inventario);
    }

    /**
     * Busca un producto por su nombre en el inventario.
     * Precondiciones: nombre no debe ser null o vacío.
     * Postcondiciones: se devuelve el índice del producto si se encuentra,
     * -1 en caso contrario.
     *
     * @param nombre Nombre del producto a buscar.
     * @return El índice del producto si se encuentra, -1 en caso contrario.
     */
    public int buscarPorNombre(String nombre) {
        int resultado = -1;
        boolean seguirBuscando = true;
        for (int i = 0; i < inventario.size() && seguirBuscando; i++) {
            if (inventario.get(i).compararNombre(nombre)) {
                resultado = i;
                seguirBuscando = false;
            }
        }
        return resultado;
    }

    /**
     * Busca un producto en el inventario.
     * Precondiciones: producto no debe ser null.
     * Postcondiciones: se devuelve el índice del producto si se encuentra.
     *
     * @param producto Producto a buscar.
     * @return El índice del producto si se encuentra.
     * @throws IllegalArgumentException si el producto no se encuentra.
     */
    private int buscarProductoEnInventario(Producto producto) {
        int resultado = -1;
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i) == producto) {
                resultado = i;
            }
        }
        if (resultado < 0) {
            throw new IllegalArgumentException("producto no encontrado");
        }
        return resultado;
    }

    /**
     * Verifica si un parámetro es válido.
     * Precondiciones: ninguna.
     * Postcondiciones: lanza una excepción si el parámetro es menor que cero.
     *
     * @param parametro Parámetro a verificar.
     * @throws ParametroNoValidoException si el parámetro es menor que cero.
     */
    private void verificarParametro(int parametro) {
        if (parametro < 0) {
            throw new ParametroNoValidoException("parametro menor a 0");
        }
    }
}
