package test;

import main.Inventory;
import main.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;

public class InventoryTest {
    Inventory inventory;
    Product product1;
    Product product2;
    Product product3;

    @BeforeEach
    void setup() {
        inventory = new Inventory();
        product1 = new Product(12, "Ferrari", "Car", 190000, 2);
        product2 = new Product(54321, "Ferrari", "Car", 100000, 3);
        product3 = new Product(8256, "Döner", "Food", 3.5, 55);
    }

    @Test
    void testAddProduct() {
        inventory.addProduct(product1);
        Assertions.assertEquals("Ferrari", inventory.findProductById(12).getName());
    }

    @Test
    void testRemoveProduct() {
        inventory.addProduct(product1);
        Assertions.assertTrue(inventory.removeProduct(12));
    }

    @Test
    void testFindProductsById() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        Assertions.assertEquals(product1, inventory.findProductById(12));
    }

    @Test
    void testFindProductsByCategory() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        List<Product> expectedList = List.of(product2, product1);
        Assertions.assertEquals(expectedList, inventory.findProductsByCategory("Car"));
    }

    @Test
    void testGetAllProducts() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        List<Product> expectedList = List.of(product3, product2, product1);
        Assertions.assertEquals(expectedList, inventory.getAllProducts());
    }

    @Test
    void testSortProductsByName() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        List<Product> expectedList = List.of(product3, product2, product1);
        Assertions.assertEquals(expectedList, inventory.sortProductsByName());
    }

    @Test
    void testSortProductByPrice() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        List<Product> expectedList = List.of(product3, product2, product1);
        Assertions.assertEquals(expectedList, inventory.sortProductsByPrice());
    }

    @Test
    void testGetLowStockProducts() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        List<Product> expectedList = List.of(product2, product1);
        Assertions.assertEquals(expectedList, inventory.getLowStockProducts(5));
    }

    @Test
    void testFilterProducts() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        List<Product> expectedList = List.of(product3);
        Assertions.assertEquals(expectedList, inventory.filterProducts(p -> p.getPrice() < 4));
    }

    @Test
    void testApplyToProducts() {
        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.addProduct(product3);

        inventory.applyToProducts(p -> p.setPrice(p.getPrice() + 1));

        Assertions.assertEquals(190001.0, product1.getPrice());
        Assertions.assertEquals(100001.0, product2.getPrice());
        Assertions.assertEquals(4.5, product3.getPrice());
    }
}
