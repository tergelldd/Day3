import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        // Жишээ: Бараа нэмэх
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter category: ");
        String category = scanner.nextLine();
        System.out.println("Enter quantity: ");
        int qty = scanner.nextInt();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();

        Product product = new Product(1, name, category, qty, price);
        inventory.addProduct(product);

        inventory.listAllProducts();
    }
}
