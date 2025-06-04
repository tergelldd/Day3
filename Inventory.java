import java.util.*;

public class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProductById(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    public Product findProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public void listAllProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    // Other methods like updateProduct(), filterByCategory() etc.
}
