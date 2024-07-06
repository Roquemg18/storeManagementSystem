package ar.unrn.excepciones;

/**
 * Tipo de Excepción para indicar problemas de elementos nulos.
 * De momento, será uno solo para todos los problemas juntos.
 */
public class ElementoNullException extends RuntimeException {
    /**
     * Encadenamiento de problemas.
     * En algunos casos, el problema se origina desde otro,
     * esta es la forma de conectar uno con otro, de forma
     * de conocer "la razón" por la cual estamos viendo este
     * problema.
     *
     * @param razon la excepción causante del problema.
     */
    public ElementoNullException(Throwable razon) {
        super(razon);
    }

    /**
     * Excepción con un mensaje.
     * En otros casos, solo queremos saber que pasó, siendo
     * la razón algo que nosotros originamos.
     *
     * @param mensaje la descripción textual del problema.
     */
    public ElementoNullException(String mensaje) {
        super(mensaje);
    }

    /**
     * Cuando queremos saber la razón de manera detallada.
     * La combinación de los dos casos anteriores, cuando queremos
     * una descripción que y porque pasó algo.
     *
     * @param mensaje la descripción textual del problema.
     * @param razon   la causa del problema
     */
    public ElementoNullException(String mensaje, Throwable razon) {
        super(mensaje, razon);
    }
}
