package ar.unrn.strategy;

import ar.unrn.Producto;
import ar.unrn.ProductoEnCarrito;
import ar.unrn.excepciones.ParametroNoValidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("test de los metodos de descuento por volumen")
class DescuentoPorVolumenTest {
    @Test
    @DisplayName("test de descuento por volumen")
    void testDescuentoPorVolumen() {

        Producto arroz = new Producto(10.0, "Arroz", "Granos");
        ProductoEnCarrito arrozEnCarrito = new ProductoEnCarrito(arroz, 10);


        int cantidadMinima = 10;
        double porcentajeDeDescuento = 10;

        DescuentoPorVolumen descuentoPorVolumen =
                new DescuentoPorVolumen(cantidadMinima, porcentajeDeDescuento);

        double descuentoEsperado = 10;
        Assertions.assertEquals(descuentoEsperado,
                descuentoPorVolumen.aplicarDescuento(arrozEnCarrito));

    }

    @Test
    @DisplayName("test del metodo toString en descuento por volumen ")
    void testDescuentoPorVolumenToString() {

        Producto arroz = new Producto(10.0, "Arroz", "Granos");
        ProductoEnCarrito arrozEnCarrito = new ProductoEnCarrito(arroz, 10);


        int cantidadMinima = 10;
        double porcentajeDeDescuento = 10;

        DescuentoPorVolumen descuentoPorVolumen =
                new DescuentoPorVolumen(cantidadMinima, porcentajeDeDescuento);

        String descuentoEsperado = "10.0";
        Assertions.assertEquals(descuentoEsperado,
                descuentoPorVolumen.toString(arrozEnCarrito));

    }

    @Test
    @DisplayName("Test metodo nombre del descuento en descuento por volumen")
    void testDescuentoPorVolumenNombreDescuento() {
        int cantidadMinima = 10;
        double porcentajeDeDescuento = 10;

        DescuentoPorVolumen descuentoPorVolumen =
                new DescuentoPorVolumen(cantidadMinima, porcentajeDeDescuento);

        String stringEsperado = "Descuento por volumen";

        Assertions.assertEquals(stringEsperado, descuentoPorVolumen.nombreDescuento());
    }

    @Test
    @DisplayName("Test crear un descuento por volumen con cantidadMinima invalida")
    void testDescuentoPorVolomenCantidadMinimaInvalida() {

        int cantidadMinima = -10;
        double porcentajeDeDescuento = 10;
        try {
            DescuentoPorVolumen descuentoPorVolumen =
                    new DescuentoPorVolumen(cantidadMinima, porcentajeDeDescuento);
            fail("deberia salta ParametroNoValidoException");
        } catch (ParametroNoValidoException e) {
            System.out.println("parametro menor a 0");
        }
    }

    @Test
    @DisplayName("Test crear un descuento por volumen con porcentaje de descuento "
            + "invalida")
    void testDescuentoPorVolomenPorcentajeDeDescuentoInvalida() {

        int cantidadMinima = 10;
        double porcentajeDeDescuento = -10;
        try {
            DescuentoPorVolumen descuentoPorVolumen =
                    new DescuentoPorVolumen(cantidadMinima, porcentajeDeDescuento);
            fail("deberia salta ParametroNoValidoException");
        } catch (ParametroNoValidoException e) {
            System.out.println("parametro menor a 0");
        }
    }
}
