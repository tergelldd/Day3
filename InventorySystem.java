package day3;
import java.time.LocalDate;
import java.util.*;

public class InventorySystem {
    private Map<String, Product> productMap = new HashMap<>();
    private Map<String, Product> archiveMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int songolt;
        do {
            System.out.println("\n--- Baraanii Burtgeliin System ---");
            System.out.println("1. Baraa nemeh");
            System.out.println("2. Baraa hasah");
            System.out.println("3. Jagsaalt harah");
            System.out.println("4. Arhiwlah");
            System.out.println("5. Garah");
            System.out.print("Songoltoo oruulna uu: ");
            songolt = scanner.nextInt();
            scanner.nextLine();

            switch (songolt) {
                case 1 -> nemBaraa();
                case 2 -> hasahBaraa();
                case 3 -> harahJagsaalt();
                case 4 -> archiwlahBaraa();
                case 5 -> System.out.println("Sistem haagdaj baina...");
                default -> System.out.println("Buruu songolt.");
            }
        } while (songolt != 5);
    }

    private void nemBaraa() {
        System.out.print("Baraanii ner: ");
        String ner = scanner.nextLine();

        System.out.print("Code: ");
        String code = scanner.nextLine();

        System.out.print("Too shirheg: ");
        int too = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Zaswartai yu? (true/false): ");
        boolean zaswartai = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Duusah ognoo (yyyy-mm-dd): ");
        String ognooStr = scanner.nextLine();
        LocalDate ognoo = LocalDate.parse(ognooStr);

        if (productMap.containsKey(code)) {
            productMap.get(code).nemToo(too);
            System.out.println("Too nemegdsen.");
        } else {
            Product p = new Product(ner, code, too, zaswartai, ognoo);
            productMap.put(code, p);
            System.out.println("Shine baraa burtgegdlee.");
        }
    }

    private void hasahBaraa() {
        System.out.print("Hasah baraanii code: ");
        String code = scanner.nextLine();

        if (!productMap.containsKey(code)) {
            System.out.println("Iim code-toi baraa oldsongui.");
            return;
        }

        System.out.print("Hasah shirheg: ");
        int too = scanner.nextInt();
        scanner.nextLine();

        Product p = productMap.get(code);
        if (p.hasahToo(too)) {
            System.out.println("Amjilttai hasagdlaa.");
            if (p.getBaraaniiToo() == 0) {
                System.out.println("Uldegdel duussan.");
            }
        } else {
            System.out.println("Hangalttai shirheg baihgui.");
        }
    }

    private void harahJagsaalt() {
        if (productMap.isEmpty()) {
            System.out.println("Baraa burtgel hooson baina.");
        } else {
            System.out.println("--- Baraa Jagsaalt ---");
            for (Product p : productMap.values()) {
                System.out.println(p);
            }
        }
    }

    private void archiwlahBaraa() {
        LocalDate unuudur = LocalDate.now();
        List<String> archiwlahCodes = new ArrayList<>();

        for (Product p : productMap.values()) {
            if (p.getBaraaniiToo() == 0 || p.isZaswartaiBaraa() || p.getDuusahOgnoo().isBefore(unuudur)) {
                archiveMap.put(p.getCode(), p);
                archiwlahCodes.add(p.getCode());
            }
        }

        for (String code : archiwlahCodes) {
            productMap.remove(code);
        }

        if (archiwlahCodes.isEmpty()) {
            System.out.println("Arhiwlah baraa alga.");
        } else {
            System.out.println("Arhiwlagsan baraanuud:");
            for (Product p : archiveMap.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        new InventorySystem().start();
    }
}
