import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Амжилттай нэмлээ.");
    }

    public void getProduct(Product product) {
        String code = product.getCode();
        double quantity = product.getQuantity();
        boolean found = false;

        for (Product p : products) {
            if (p.code.equals(code)) {
                if (p.quantity >= quantity) {
                    found = true;
                    p.quantity -= quantity;
                    System.out.printf("%s кодтой %.1f ширхэг %s бараа нөөцөөс хасагдлаа.\n",
                            p.code, quantity, p.productName);
                    return;
                } else {
                    System.out.println("Хангалттай тоо ширхэг байхгүй байна.");
                    return;
                }
            }
        }
        if (!found) {
            System.out.println("Бараа олдсонгүй.");
        }
    }
    

    public void listInventory() {
        System.out.println("\nНөөцийн жагсаалт:");
        for (Product p : products) {
            System.out.printf("- %s (%s): %.1f ширхэг, үнэ: %.2f төгрөг, нэмсэн: %s\n", p.productName, p.code, p.quantity, p.price, p.fromName);        
        }
    }
}
