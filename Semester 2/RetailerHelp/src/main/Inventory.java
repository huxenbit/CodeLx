package main;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Inventory implements Iterable<Product>{
    private Map<Integer, Product> products;

    public Inventory() {
        products = new LinkedHashMap<>();
    }

    @Override
    public Iterator<Product> iterator() {
        return products.values().iterator();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public boolean removeProduct(int productId) {
        return products.remove(productId) != null;
    }

    public Product findProductById(int productId) {
        return products.get(productId);
    }

    public List<Product> findProductsByCategory(String searchedCategory) {
        return products.values().stream().filter(s -> s.getCategory().equalsIgnoreCase(searchedCategory)).toList();
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public List<Product> sortProductsByName() {
        return products.values().stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
    }

    public List<Product> sortProductsByPrice() {
        return products.values().stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
    }

    public List<Product> getLowStockProducts(int threshold) {
        return products.values().stream().filter(p -> p.getQuantity() < threshold).collect(Collectors.toList());
    }

    public List<Product> filterProducts(Predicate<Product> predicate) {
        return products.values().stream().filter(predicate).collect(Collectors.toList());
    }

    public void applyToProducts(Consumer<Product> consumer) {
        products.values().forEach(consumer);
    }
}
