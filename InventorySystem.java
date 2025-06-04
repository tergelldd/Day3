import java.util.*;

public class InventorySystem {
    private Map<String, Product> productMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            System.out.println("\n--- Барааны бүртгэлийн систем ---");
            System.out.println("1. Бараа нэмэх");
            System.out.println("2. Бараа хасах");
            System.out.println("3. Барааны жагсаалт харах");
            System.out.println("4. Гарах");
            System.out.print("Сонголтоо оруулна уу: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // newline алгасах

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> removeProduct();
                case 3 -> listProducts();
                case 4 -> System.out.println("Системээс гарав.");
                default -> System.out.println("Буруу сонголт. Дахин оролдоно уу.");
            }
        } while (choice != 4);
    }

    private void addProduct() {
        System.out.print("Барааны нэр: ");
        String name = scanner.nextLine();
        System.out.print("Барааны код: ");
        String code = scanner.nextLine();
        System.out.print("Тоо ширхэг: ");
        int qty = scanner.nextInt();
        scanner.nextLine(); // newline

        if (productMap.containsKey(code)) {
            productMap.get(code).addQuantity(qty);
            System.out.println("Тоо ширхэг нэмэгдлээ.");
        } else {
            productMap.put(code, new Product(name, code, qty));
            System.out.println("Шинэ бараа бүртгэгдлээ.");
        }
    }

    private void removeProduct() {
        System.out.print("Хасах барааны код: ");
        String code = scanner.nextLine();
        if (!productMap.containsKey(code)) {
            System.out.println("Ийм кодтой бараа олдсонгүй.");
            return;
        }

        System.out.print("Хасах тоо ширхэг: ");
        int qty = scanner.nextInt();
        scanner.nextLine(); // newline

        Product product = productMap.get(code);
        if (product.removeQuantity(qty)) {
            System.out.println("Амжилттай хаслаа.");
            if (product.getQuantity() == 0) {
                productMap.remove(code);
                System.out.println("Үлдэгдэл дууссан тул бүртгэлээс устгалаа.");
            }
        } else {
            System.out.println("Хасах тоо нь үлдэгдлээс их байна.");
        }
    }

    private void listProducts() {
        if (productMap.isEmpty()) {
            System.out.println("Барааны жагсаалт хоосон байна.");
        } else {
            System.out.println("=== Барааны жагсаалт ===");
            for (Product p : productMap.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        new InventorySystem().start();
    }
}
