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
    @Test
    void test_add_item_increases_total() {
        Warenkorb cart = new Warenkorb();
        cart.addItem("Apfel", 1.0);
        assertEquals(1.0, cart.getTotal(), DELTA);
    }
    @Test
    void test_add_multiple_items_sums_total() {
        Warenkorb cart = new Warenkorb();
        cart.addItem("Apfel", 1.0);
        cart.addItem("Banane", 2.0);
        assertEquals(3.0, cart.getTotal(), DELTA);
    }
    @Test
    void test_get_quantity_of_item() {
        Warenkorb cart = new Warenkorb();
        cart.addItem("Apfel", 1.0);
        cart.addItem("Apfel", 1.0);
        cart.addItem("Banane", 2.0);
        assertEquals(2, cart.getQuantity("Apfel"));
    }
    @Test
    void test_remove_item() {
        Warenkorb cart = new Warenkorb();
        cart.addItem("Apfel", 1.0);
        cart.addItem("Apfel", 1.0);
        cart.addItem("Banane", 2.0);
        cart.removeItem("Apfel");
        assertEquals(1, cart.getQuantity("Apfel"));
        assertEquals(3.0, cart.getTotal(), DELTA);
    }
}