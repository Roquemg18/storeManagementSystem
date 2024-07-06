package ar.unrn;

import ar.unrn.excepciones.ParametroNoValidoException;

/**
 * Esta clase contiene los atributos y métodos que se utilizarán relacionados con los
 * productos del supermercado.
 */
public class Producto {
    /**
     * Cantidad de unidades disponibles del producto.
     */
    private int stock;

    /**
     * Precio del producto.
     */
    private double precio;

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Tipo de producto.
     */
    private String tipo;

    /**
     * Este constructor público recibe como argumento un precio, un nombre y un tipo
     * que se lo asigna a los atributos de la clase. Lanza una excepción en caso de que
     * el precio dado sea menor a 0.
     * POST: Los atributos del nuevo objeto tendrán los valores pasados como argumento.
     *
     * @param precio es una variable double que debe ser mayor o igual a 0.
     * @param nombre es la variable de tipo String que se le asignará al atributo
     *               nombre de esta clase.
     * @param tipo   es la variable de tipo String que se le asignará al atributo tipo de
     *               esta clase.
     * @throws ParametroNoValidoException cuando el precio dado es menor a 0.
     */
    public Producto(double precio, String nombre, String tipo)
            throws ParametroNoValidoException {
        if (precio < 0) {
            throw new ParametroNoValidoException("El precio no puede ser negativo");
        }
        this.stock = 0;
        this.precio = precio;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    /**
     * Este método devuelve un String que contiene la información del producto sin su
     * stock. Como su nombre lo indica, solo se usa al momento de imprimir el ticket.
     *
     * @return retornará una cadena que representa el producto sin mostrar su stock.
     */
    public String ticketStringProduct() {
        return "Producto:" +
                " Nombre: " + nombre +
                ", Tipo: " + tipo +
                ", Precio: " + precio;
    }

    /**
     * Este método devuelve un String que contiene la información completa del producto.
     *
     * @return retornará una cadena que representa el producto.
     */
    public String toString() {
        return "Producto:" +
                " Nombre: " + nombre +
                ", Tipo: " + tipo +
                ", Stock: " + stock +
                ", Precio: " + precio;
    }

    /**
     * Este método recibe como argumento una cantidad y aumenta el valor del atributo
     * stock de este objeto en la cantidad dada.
     * POST: El valor del atributo stock será mayor.
     *
     * @param cantidad es la cantidad en que se desea que aumente el valor del atributo
     *                 stock de este objeto.
     * @throws ParametroNoValidoException cuando la cantidad pasada como argumento es
     *                                    menor a 0.
     */
    public void aumentarStock(int cantidad) throws ParametroNoValidoException {
        if (cantidad < 0) {
            throw new ParametroNoValidoException("La cantidad no puede ser negativa");
        }
        this.stock = stock + cantidad;
    }

    /**
     * Este método recibe como argumento una cantidad y disminuye el valor del atributo
     * stock de este objeto en la cantidad dada.
     * POST: El valor del atributo stock será menor.
     *
     * @param cantidad es la cantidad en que se desea que disminuya el valor del
     *                 atributo stock de este objeto.
     * @throws ParametroNoValidoException cuando la cantidad pasada como argumento es
     *                                    menor a 0 o mayor a la cantidad ya almacenado.
     */
    public void disminuirStock(int cantidad) throws ParametroNoValidoException {
        if (cantidad < 0 || cantidad > this.stock) {
            throw new ParametroNoValidoException("La cantidad no puede ser negativa "
                    + "ni mayor al stock del producto");
        }
        this.stock = stock - cantidad;
    }

    /**
     * Este método recibe como argumento un valor y aumenta el valor del atributo
     * precio de este objeto en la cantidad dada.
     * POST: El valor del atributo precio será mayor.
     *
     * @param valor es la cantidad en que se desea que aumente el valor del atributo
     *              precio de este objeto.
     * @throws ParametroNoValidoException cuando la cantidad pasada como argumento es
     *                                    menor a 0.
     */
    public void aumentarPrecio(double valor) throws ParametroNoValidoException {
        if (valor < 0) {
            throw new ParametroNoValidoException("El valor no puede ser negativo");
        }
        this.precio = precio + valor;
    }

    /**
     * Este método recibe como argumento un valor y disminuye el valor del atributo
     * precio de este objeto en la cantidad dada.
     * POST: El valor del atributo precio será menor.
     *
     * @param valor es la cantidad en que se desea que disminuya el valor del atributo
     *              precio de este objeto.
     * @throws ParametroNoValidoException cuando la cantidad pasada como argumento es
     *                                    menor a 0 o mayor al precio ya almacenado.
     */
    public void disminuirPrecio(double valor) throws ParametroNoValidoException {
        if (valor < 0 || valor > this.precio) {
            throw new ParametroNoValidoException("El valor no puede ser negativo ni "
                    + "mayor al precio del producto");
        }
        this.precio = precio - valor;
    }

    /**
     * Este método recibe una cantidad y devuelve verdadero en caso de que esta sea
     * menor o igual al stock del producto. En caso contrario, devuelve falso. Dará una
     * excepción en caso de que la cantidad dada sea menor a 0.
     *
     * @param cantidad es una variable int que debe ser mayor a 0.
     * @return devuelve un valor booleano que indica si la cantidad pasada como
     * argumento es mayor o igual al stock o no.
     * @throws ParametroNoValidoException cuando la cantidad dada es menor a 0.
     */
    public boolean disponibilidad(int cantidad) throws ParametroNoValidoException {
        if (cantidad < 0) {
            throw new ParametroNoValidoException("La cantidad no puede ser negativa");
        }

        boolean resultado = true;

        if (cantidad > this.stock) {
            resultado = false;
        }

        return resultado;
    }

    /**
     * Este método recibe un String y lo compara con el atributo tipo almacenado en
     * este objeto. Devolverá true si son iguales y false si son distintos.
     *
     * @param otroTipo es un String que representa el tipo de un Producto.
     * @return devolverá true si son iguales o false en caso de ser distintos.
     */
    public boolean compararTipo(String otroTipo) {
        boolean resultado = false;
        if (this.tipo.equalsIgnoreCase(otroTipo)) {
            resultado = true;
        }
        return resultado;
    }

    /**
     * Este método recibe un String y lo compara con el atributo nombre almacenado en
     * este objeto. Devolverá true si son iguales y false si son distintos.
     *
     * @param otroNombre es un String que representa el nombre de un Producto.
     * @return devolverá true si son iguales o false en caso de ser distintos.
     */
    public boolean compararNombre(String otroNombre) {
        boolean resultado = false;
        if (this.nombre.equalsIgnoreCase(otroNombre)) {
            resultado = true;
        }
        return resultado;
    }

    /**
     * Este método recibe una cantidad y la multiplica por el precio almacenado en este
     * objeto para devolver el resultado.
     *
     * @param cantidad es el número no negativo que se multiplicará por el precio
     *                 almacenado en este objeto.
     * @return Devolverá el resultado de la multiplicación.
     * @throws ParametroNoValidoException cuando la cantidad sea menor a 0.
     */
    public double determinarPrecio(int cantidad) throws ParametroNoValidoException {
        if (cantidad < 0) {
            throw new ParametroNoValidoException("La cantidad no puede ser negativa");
        }
        return this.precio * cantidad;
    }
}
