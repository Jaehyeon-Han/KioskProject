package hello.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Item, Integer> cartItems = new HashMap<>();

    public void addToCart(Item item) {
        int currentQuantity = cartItems.getOrDefault(item, 0);
        cartItems.put(item, currentQuantity + 1);
        System.out.println(item.getName() + " added to cart.");
    }

    public Map<Item, Integer> getCartItems() {
        return cartItems;
    }

    public void removeOneFromCart(Item item) {
        int currentQuantity = cartItems.getOrDefault(item, 0);

        if(currentQuantity == 0) {
            System.out.println("The item is not in cart");
            return;
        }

        if(currentQuantity == 1) {
            cartItems.remove(item);
            System.out.println(item.getName() + " is removed from the cart");
            return;
        }

        cartItems.put(item, currentQuantity - 1);
        System.out.println("One " + item.getName() + " is removed from cart");
    }
}
