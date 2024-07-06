package ar.unrn.estructura;

/**
 * Esta clase contiene la información básica a utilizar de un cliente del supermercado
 */
public class Cliente {
    /**
     * El nombre del cliente.
     */
    protected String nombre;

    /**
     * El DNI del cliente.
     */
    protected int dni;

    /**
     * La edad del cliente.
     */
    protected int edad;

    /**
     * Este constructor público recibe un String y dos variables int para instanciar
     * los atributos de esta clase.
     * POST: Los atributos quedarán instanciados con las variables pasadas como
     * argumentos.
     *
     * @param nombre es el String que se desea almacenar en el atributo nombre dentro
     *               del nuevo objeto.
     * @param dni    es la variable de tipo int que se desea almacenar en el atributo dni
     *               dentro del nuevo objeto.
     * @param edad   es la variable de tipo edad que se desea almacenar en el atributo
     *               edad dentro del nuevo objeto.
     */
    public Cliente(String nombre, int dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    /**
     * Este método recibe una variable de tipo int que se compara con el dni dentro de
     * este objeto y devuelve una variable boolean que lo indica.
     *
     * @param dni es el número entero con el que se desea comparar el dni almacenado
     *            dentro de este objeto.
     * @return Devolverá true en caso de que el número pasado como argumento sea igual
     * al dni almacenado en este objeto.
     */
    public boolean compararDNI(int dni) {
        boolean resultado = false;
        if (this.dni == dni) {
            resultado = true;
        }
        return resultado;
    }

    /**
     * Este método devuelve un String que representa este objeto de tipo Cliente.
     *
     * @return Devolverá un String que representa este objeto.
     */
    public String toString() {
        return "[Nombre: " + nombre +
                ", DNI: " + dni +
                ", Edad: " + edad + "]";
    }
}
