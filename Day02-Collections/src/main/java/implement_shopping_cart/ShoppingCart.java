package implement_shopping_cart;
import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices; // Stores product -> price
    private LinkedHashMap<String, Integer> cartItems; // Maintains order of added items
    private TreeMap<String, Double> sortedByPrice; // Sorts items by price

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cartItems = new LinkedHashMap<>();
        sortedByPrice = new TreeMap<>(Comparator.comparingDouble(productPrices::get));
    }

    // Add a product to the cart
    public void addProduct(String product, double price, int quantity) {
        productPrices.put(product, price);
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
        sortedByPrice.put(product, price);
    }

    // Remove a product from the cart
    public void removeProduct(String product) {
        if (cartItems.containsKey(product)) {
            cartItems.remove(product);
            sortedByPrice.remove(product);
        } else {
            System.out.println("Product not in cart.");
        }
    }

    // Display items in the order they were added
    public void displayCartItems() {
        System.out.println("Shopping Cart (Order Added): " + cartItems);
    }

    // Display items sorted by price
    public void displayItemsSortedByPrice() {
        System.out.println("Items Sorted by Price: " + sortedByPrice);
    }

    // Calculate total price of the cart
    public double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1000.0, 1);
        cart.addProduct("Phone", 700.0, 2);
        cart.addProduct("Headphones", 200.0, 1);
        cart.addProduct("Mouse", 50.0, 2);

        cart.displayCartItems();
        cart.displayItemsSortedByPrice();
        System.out.println("Total Price: $" + cart.calculateTotal());
    }
}
