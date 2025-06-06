import java.util.Scanner;

public class GetProduct {
    public Product getProduct() {
        Scanner read = new Scanner(System.in);

        System.out.print("Авж буй хүний нэр: ");
        String fName = read.nextLine();
        System.out.print("Барааны нэр: ");
        String pName = read.nextLine();
        System.out.print("Барааны код: ");
        String code = read.nextLine();
        System.out.print("Тоо ширхэг: ");
        double quantity = read.nextDouble();
        System.out.print("Барааны үнэ: ");
        double price = read.nextDouble();

        return new Product(fName, pName, code, quantity, price);
    }
}
