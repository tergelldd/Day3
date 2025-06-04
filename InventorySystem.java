import java.util.*;
import java.time.LocalDate;

public class InventorySystem {
    private Map<String, Product> productMap = new HashMap<>();
    private Map<String, Product> archiveMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            System.out.println("\n--- Барааны бүртгэлийн систем ---");
            System.out.println("1. Бараа нэмэх");
            System.out.println("2. Бараа хасах");
            System.out.println("3. Барааны жагсаалт харах");
            System.out.println("4. Архивлах");
            System.out.println("5. Гарах");
            System.out.print("Сонголтоо оруулна уу: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // newline алгасах

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> removeProduct();
                case 3 -> listProducts();
                case 4 -> archiveProducts();
                case 5 -> System.out.println("Системээс гарч байна...");
                default -> System.out.println("Буруу сонголт. Дахин оролдоно уу.");
            }
        } while (choice != 5);
    }

    private void addProduct() {
        System.out.print("Барааны нэр: ");
        String name = scanner.nextLine();
        System.out.print("Барааны код: ");
        String code = scanner.nextLine();
        System.out.print("Тоо ширхэг: ");
        int qty = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Засвартай юу? (true/false): ");
        boolean underRepair = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Дуусах огноо (жишээ: 2025-12-31): ");
        String dateStr = scanner.nextLine();
        LocalDate expirationDate = LocalDate.parse(dateStr);

        if (productMap.containsKey(code)) {
            productMap.get(code).addQuantity(qty);
            System.out.println("Тоо ширхэг нэмэгдлээ.");
        } else {
            Product product = new Product(name, code, qty, underRepair, expirationDate);
            productMap.put(code, product);
            System.out.println("Шинэ бараа амжилттай бүртгэгдлээ.");
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
        scanner.nextLine();

        Product product = productMap.get(code);
        if (product.removeQuantity(qty)) {
            System.out.println("Бараанаас амжилттай хаслаа.");
            if (product.getQuantity() == 0) {
                System.out.println("Үлдэгдэл дууссан.");
            }
        } else {
            System.out.println("Хасах тоо ширхэг нь үлдэгдлээс их байна.");
        }
    }

    private void listProducts() {
        if (productMap.isEmpty()) {
            System.out.println("Одоогоор бүртгэлтэй бараа алга.");
        } else {
            System.out.println("\n--- Барааны жагсаалт ---");
            for (Product p : productMap.values()) {
                System.out.println(p);
            }
        }
    }

    private void archiveProducts() {
        LocalDate today = LocalDate.now();
        List<String> toArchive = new ArrayList<>();

        for (Product p : productMap.values()) {
            if (p.getQuantity() == 0 || p.isUnderRepair() || p.getExpirationDate().isBefore(today)) {
                archiveMap.put(p.getCode(), p);
                toArchive.add(p.getCode());
            }
        }

        for (String code : toArchive) {
            productMap.remove(code);
        }

        if (toArchive.isEmpty()) {
            System.out.println("Архивлах шаардлагатай бараа олдсонгүй.");
        } else {
            System.out.println("Архивласан бараанууд:");
            for (Product p : archiveMap.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        new InventorySystem().start();
    }
}