package de.projekt.a2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WarenkorbTest {

    private static final double DELTA = 1e-9;

    @Test
    void test_empty_cart_has_zero_total() {
        Warenkorb cart = new Warenkorb();
        assertEquals(0.0, cart.getTotal(), DELTA);
    }
}