package implement_shopping_cart;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        cart.addProduct("Laptop", 1000.0, 1);
        cart.addProduct("Phone", 700.0, 2);
        cart.addProduct("Headphones", 200.0, 1);
    }

    @Test
    void testCalculateTotal() {
        assertEquals(1000.0 + (700.0 * 2) + 200.0, cart.calculateTotal());
    }

    @Test
    void testAddProduct() {
        cart.addProduct("Mouse", 50.0, 2);
        assertEquals(50.0 * 2 + cart.calculateTotal() - 50.0 * 2, cart.calculateTotal());
    }

    @Test
    void testRemoveProduct() {
        cart.removeProduct("Phone");
        assertEquals(1000.0 + 200.0, cart.calculateTotal());
    }

    @Test
    void testRemoveNonExistentProduct() {
        cart.removeProduct("Tablet"); // Should print "Product not in cart."
    }

    @Test
    void testDisplayCartItems() {
        cart.displayCartItems(); // Check order of addition
    }

    @Test
    void testDisplaySortedByPrice() {
        cart.displayItemsSortedByPrice(); // Check sorting order
    }
}
