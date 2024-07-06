package ar.unrn.strategy;

import ar.unrn.Producto;
import ar.unrn.ProductoEnCarrito;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("test de los metodos de descuento por premium")
class DescuentoPorPremiumTest {

    @Test
    @DisplayName("Test de descuento por premium")
    void testDescuentoPorPremium() {
        Producto arroz = new Producto(10.0, "Arroz", "Granos");
        ProductoEnCarrito enCarritoArroz = new ProductoEnCarrito(arroz, 10);

        DescuentoPorPremium descuentoPorPremium = new DescuentoPorPremium();

        double descuentoEsperado = 5;
        Assertions.assertEquals(descuentoEsperado,
                descuentoPorPremium.aplicarDescuento(enCarritoArroz));
    }

    @Test
    @DisplayName("Test del método toString en descuento por premium")
    void testDescuentoPorPremiumToString() {
        Producto arroz = new Producto(10.0, "Arroz", "Granos");
        ProductoEnCarrito enCarritoArroz = new ProductoEnCarrito(arroz, 10);

        DescuentoPorPremium descuentoPorPremium = new DescuentoPorPremium();

        String descuentoEsperado = "5.0";
        Assertions.assertEquals(descuentoEsperado,
                descuentoPorPremium.toString(enCarritoArroz));
    }

    @Test
    @DisplayName("Test método nombre del descuento en descuento por premium")
    void testDescuentoPorPremiumNombreDescuento() {
        DescuentoPorPremium descuentoPorPremium = new DescuentoPorPremium();

        String stringEsperado = "Descuento por premium";

        Assertions.assertEquals(stringEsperado, descuentoPorPremium.nombreDescuento());
    }

}
