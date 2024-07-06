package ar.unrn.estructura;

import ar.unrn.excepciones.ElementoNullException;
import ar.unrn.excepciones.PosicionFueraDeLugarException;

/**
 * Clase que representa una lista de clientes premium del supermercado.
 */
public class ClientesPremium {
    /**
     * Referencia al primer nodo de la lista enlazada de clientes premium.
     */
    protected Nodo inicio;

    /**
     * Constructor de la clase ClientesPremium.
     * Inicializa la lista enlazada de clientes premium con un valor nulo.
     */

    public ClientesPremium() {
        inicio = null;
    }

    /**
     * Método que calcula el tamaño de la lista enlazada de clientes premium.
     * Postcondición: Se retorna el tamaño de la lista enlazada.
     *
     * @return El tamaño de la lista enlazada de clientes premium.
     */
    public int largo() {
        int contador = 0;
        Nodo actual = inicio;
        while (actual != null) {
            actual = actual.siguiente;
            contador++;
        }
        return contador;
    }

    /**
     * Método privado que verifica si una posición dada se encuentra dentro de los
     * límites de la lista enlazada de clientes premium.
     * Precondición: La posición debe ser un valor válido.
     * Postcondición: Si la posición no es válida, se lanza una excepción.
     *
     * @param posicion La posición a verificar.
     * @throws PosicionFueraDeLugarException Si la posición está fuera de los
     *                                       límites de la lista.
     */
    private void verificarPosicion(int posicion) throws PosicionFueraDeLugarException {
        if (posicion < 0 || posicion > largo()) {
            throw new PosicionFueraDeLugarException("La posición indicada se "
                    + "encuentra fuera de los límites de la lista");
        }
    }

    /**
     * Método privado que verifica si un elemento dado no es nulo.
     * Precondición: El elemento debe ser un valor válido.
     * Postcondición: Si el elemento es nulo, se lanza una excepción.
     *
     * @param cliente El elemento a verificar.
     * @throws ElementoNullException Si el elemento es nulo.
     */
    private void verificarElemento(Cliente cliente) throws ElementoNullException {
        if (cliente == null) {
            throw new ElementoNullException("El elemento dado no debe ser null");
        }
    }

    /**
     * Método que agrega un cliente a la lista enlazada de clientes premium.
     * Precondición: El cliente debe ser un valor válido.
     * Postcondición: Se agrega el cliente a la lista enlazada.
     *
     * @param cliente El cliente a agregar.
     * @throws ElementoNullException Si el cliente es nulo.
     */
    public void agregar(Cliente cliente) {
        verificarElemento(cliente);
        Nodo nuevoNodo = new Nodo(cliente);
        nuevoNodo.siguiente = inicio;
        inicio = nuevoNodo;
    }

    /**
     * Método que elimina un cliente de la lista enlazada de clientes premium.
     * Precondición: La posición debe ser un valor válido.
     * Postcondición: Se elimina el cliente de la lista enlazada.
     *
     * @param posicion La posición del cliente a eliminar.
     * @throws PosicionFueraDeLugarException Si la posición está fuera de los límites
     *                                       de la lista.
     */
    public void remover(int posicion) throws PosicionFueraDeLugarException {
        if (inicio == null) {
            throw new PosicionFueraDeLugarException("El tamaño del arreglo es cero, "
                    + "no hay elementos que remover");
        }
        verificarPosicion(posicion + 1);
        if (largo() == 1) {
            inicio = null;
        } else {
            if (posicion == 0) {
                inicio = inicio.siguiente;
            } else {
                Nodo actual = inicio;
                for (int i = 0; i < posicion - 1; i++) {
                    actual = actual.siguiente;
                }
                actual.siguiente = actual.siguiente.siguiente;
            }
        }
    }

    /**
     * Método que obtiene un cliente de la lista enlazada de clientes premium.
     * Precondición: La posición debe ser un valor válido.
     * Postcondición: Se retorna el cliente de la posición indicada.
     *
     * @param posicion La posición del cliente a obtener.
     * @return El cliente en la posición indicada.
     * @throws PosicionFueraDeLugarException Si la posición está fuera de los límites
     *                                       de la lista.
     */
    public Cliente obtener(int posicion) throws PosicionFueraDeLugarException {
        verificarPosicion(posicion);
        Nodo retorno = inicio;
        for (int i = 0; i < posicion; i++) {
            retorno = retorno.siguiente;
        }
        return retorno.actual;
    }

    /**
     * Método que verifica si un cliente con el DNI dado es un cliente premium.
     * Precondición: El DNI debe ser un valor válido.
     * Postcondición: Se retorna true si el cliente es premium, false en caso contrario.
     *
     * @param dni El DNI del cliente a verificar.
     * @return true si el cliente es premium, false en caso contrario.
     */
    public boolean verificarPremium(int dni) {
        boolean resultado = false;
        boolean seguirBuscando = true;
        Nodo actual = inicio;
        while (actual != null && seguirBuscando) {
            if (actual.actual.compararDNI(dni)) {
                resultado = true;
                seguirBuscando = false;
            }
            actual = actual.siguiente;
        }
        return resultado;
    }

    /**
     * Método que genera una representación en forma de cadena de los clientes premium.
     * Postcondición: Se retorna una cadena con la representación de los clientes premium
     *
     * @return Una cadena con la representación de los clientes premium.
     */
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("(");
        Nodo actual = inicio;
        for (int i = 0; i < largo(); i++) {
            cadena.append(actual.actual.toString());
            if (i < (largo() - 1)) {
                cadena.append(", ");
            }
            actual = actual.siguiente;
        }
        cadena.append(")");
        return cadena.toString();
    }

    /**
     * Clase privada que representa un nodo de la lista enlazada de clientes premium.
     */
    private static class Nodo {
        /**
         * El cliente premium almacenado en el nodo.
         */
        protected Cliente actual;

        /**
         * El siguiente nodo de la lista enlazada.
         */
        protected Nodo siguiente;

        /**
         * Constructor de la clase Nodo.
         * Precondición: El cliente debe ser un valor válido.
         * Postcondición: Se crea un nuevo nodo con el cliente y el siguiente nodo nulo.
         *
         * @param cliente El cliente premium a almacenar en el nodo.
         */

        public Nodo(Cliente cliente) {
            this.actual = cliente;
            this.siguiente = null;
        }
    }
}
