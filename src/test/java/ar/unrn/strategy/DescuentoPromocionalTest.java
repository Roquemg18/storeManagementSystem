package ar.unrn.strategy;

import ar.unrn.Producto;
import ar.unrn.ProductoEnCarrito;
import ar.unrn.excepciones.ParametroNoValidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("test de los metodos de descuento promocional")
class DescuentoPromocionalTest {


    @Test
    @DisplayName("test de descuento por promoción")
    void testDescuentoPromocional() {
        Producto arroz = new Producto(10.0, "Arroz", "Granos");
        ProductoEnCarrito arrozEnCarrito = new ProductoEnCarrito(arroz, 10);

        double porcentajeDeDescuento = 10;
        String tipoDeProducto = "Granos";
        DescuentoPromocional descuentoPromocional =
                new DescuentoPromocional(tipoDeProducto, porcentajeDeDescuento);


        double descuentoEsperado = 10;
        Assertions.assertEquals(descuentoEsperado,
                descuentoPromocional.aplicarDescuento(arrozEnCarrito));
    }

    @Test
    @DisplayName("test del método toString en descuento por promoción")
    void testDescuentoPromocionalToString() {
        Producto arroz = new Producto(10.0, "Arroz", "Granos");
        ProductoEnCarrito enCarritoArroz = new ProductoEnCarrito(arroz, 10);

        double porcentajeDeDescuento = 10;
        String tipoDeProducto = "Granos";
        DescuentoPromocional descuentoPromocional =
                new DescuentoPromocional(tipoDeProducto, porcentajeDeDescuento);


        String descuentoEsperado = "10.0";
        Assertions.assertEquals(descuentoEsperado,
                descuentoPromocional.toString(enCarritoArroz));
    }

    @Test
    @DisplayName("Test método nombre del descuento en descuento por promoción")
    void testDescuentoPromocionalNombreDescuento() {
        double porcentajeDeDescuento = 10;
        String tipoDeProducto = "Granos";
        DescuentoPromocional descuentoPromocional =
                new DescuentoPromocional(tipoDeProducto, porcentajeDeDescuento);


        String stringEsperado = "Descuento por promocion";

        Assertions.assertEquals(stringEsperado, descuentoPromocional.nombreDescuento());
    }

    @Test
    @DisplayName("Test crear un descuento por promoción con porcentaje de "
            + "descuento inválido")
    void testDescuentoPromocionalPorcentajeDeDescuentoInvalida() {
        double porcentajeDeDescuento = -10;
        try {
            new DescuentoPromocional("Granos", porcentajeDeDescuento);
            fail("Debería lanzar ParametroNoValidoException");
        } catch (ParametroNoValidoException e) {
            System.out.println("parametro menor a 0");
        }
    }
}
