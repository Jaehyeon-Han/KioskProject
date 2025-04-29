package hello.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    @Test
    void addToCart() {
        Cart cart = new Cart();
        Item item1 = new Item("Item1", 1, "Item1");
        cart.addToCart(item1);
        assertFalse(cart.getCartItems().isEmpty());
    }

    @Test
    void removeOneFromCart() {
        Cart cart = new Cart();
        Item item1 = new Item("Item1", 1, "Item1");
        Item item2 = new Item("Item1", 1, "Item1");

        cart.addToCart(item1);
        cart.addToCart(item2);
        cart.removeOneFromCart(item1);

        assertFalse(cart.getCartItems().isEmpty());

        cart.removeOneFromCart(item1);
        assertTrue(cart.getCartItems().isEmpty());
    }
}