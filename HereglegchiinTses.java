package day3;

import java.util.Scanner;

public class HereglegchiinTses {
    private final NootsUdirdaadag noots;
    private final SanhuuUdirdaadag sanhuu;
    private final ZasvarUdirdaadag zasvar;
    private final ArchivtHadgalagch arhiv;
    private final Scanner orolt;

    public HereglegchiinTses() {
        noots = new NootsUdirdaadag();
        sanhuu = new SanhuuUdirdaadag();
        zasvar = new ZasvarUdirdaadag();
        arhiv = new ArchivtHadgalagch();
        orolt = new Scanner(System.in);
    }

    public void ehluleh() {
        while (true) {
            menuHarah();
            int songolt = orolt.nextInt();
            orolt.nextLine(); // newline унших
            songoltAjilluulah(songolt);
        }
    }

    private void menuHarah() {
        System.out.println("\n=== Бараа, Санхүү, Архивын систем ===");
        System.out.println("1. Бараа нэмэх");
        System.out.println("2. Бараа борлуулах");
        System.out.println("3. Нөөц харах");
        System.out.println("4. Санхүүгийн тайлан");
        System.out.println("5. Засварт бараа өгөх");
        System.out.println("6. Архивт бараа илгээх");
        System.out.println("7. Засвартай бараа харах");
        System.out.println("8. Архив харах");
        System.out.println("9. Гарах");
        System.out.print("Сонголт: ");
    }

    private void songoltAjilluulah(int s) {
        switch (s) {
            case 1 -> baraaNemeh();
            case 2 -> borluulah();
            case 3 -> noots.haruulah();
            case 4 -> sanhuu.tailan();
            case 5 -> zasvarOruulah();
            case 6 -> arhivtOruulah();
            case 7 -> zasvar.haruulah();
            case 8 -> arhiv.haruulah();
            case 9 -> {
                System.out.println("Системээс гарлаа.");
                System.exit(0);
            }
            default -> System.out.println("Буруу сонголт.");
        }
    }

    private void baraaNemeh() {
        System.out.print("Код: ");
        String kod = orolt.nextLine();
        System.out.print("Нэр: ");
        String ner = orolt.nextLine();
        System.out.print("Үнэ: ");
        double une = orolt.nextDouble();
        System.out.print("Тоо ширхэг: ");
        int shirheg = orolt.nextInt();

        Baraa baraa = new Baraa(kod, ner, une, shirheg);
        noots.baraaNemeh(baraa);
        sanhuu.zarlagaNemeh(une * shirheg);
        System.out.println("Амжилттай нэмлээ.");
    }

    private void borluulah() {
        System.out.print("Код: ");
        String kod = orolt.nextLine();
        System.out.print("Тоо ширхэг: ");
        int shirheg = orolt.nextInt();

        Baraa b = noots.avBaraa(kod);
        if (b != null && noots.borluulah(kod, shirheg)) {
            sanhuu.orlogoNemeh(b.avUne() * shirheg);
            System.out.println("Борлуулалт амжилттай.");
        } else {
            System.out.println("Бараа олдсонгүй эсвэл хүрэлцэхгүй.");
        }
    }

    private void zasvarOruulah() {
        System.out.print("Засварт оруулах барааны код: ");
        String kod = orolt.nextLine();
        Baraa b = noots.avBaraa(kod);
        if (b != null) {
            zasvar.zasvartOruul(b);
            System.out.println("Засварт илгээлээ.");
        } else {
            System.out.println("Бараа олдсонгүй.");
        }
    }

    private void arhivtOruulah() {
        System.out.print("Архивт оруулах барааны код: ");
        String kod = orolt.nextLine();
        Baraa b = noots.avBaraa(kod);
        if (b != null) {
            noots.ustgah(kod);
            arhiv.arhivtOruul(b);
            System.out.println("Архив руу илгээлээ.");
        } else {
            System.out.println("Бараа олдсонгүй.");
        }
    }
}
