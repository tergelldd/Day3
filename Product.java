import java.time.LocalDate;
import java.util.Scanner;

public class Product {

    String fromName; //Хэн нэмсэн
    LocalDate date; //Хэзээ нэмсэн
    String productName; //Барааны нэр
    String code; //Барааны код
    double quantity; //Тоо ширхэг
    double price; //Барааны үнэ

    public Product(String fromName, String productName, String code, double quantity, double price) {
        this.fromName = fromName;
        this.productName = productName;
        this.code = code;
        this.quantity = quantity;
        this.price = price;
        this.date = LocalDate.now();
    }

    public String getFromName() {  return fromName;}
    public LocalDate getDate() {   return date;}
    public String getProductName() {   return productName;}
    public String getCode() {   return code;}
    public double getQuantity() {   return quantity;}
    public double getPrice() {   return price;}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\n1. Бараа нэмэх");
            System.out.println("2. Бараа авах");
            System.out.println("3. Нөөц харах");
            System.out.println("0. Гарах");
            System.out.print("Сонголтоо хийнэ үү: ");
            int choice = sc.nextInt();
            sc.nextLine(); // newline авах

            if (choice == 1) {
                AddProduct addProduct = new AddProduct();
                Product product = addProduct.addProduct();
                inventory.addProduct(product);
            } 
            else if (choice == 2) {
                GetProduct getProduct = new GetProduct();
                Product product = getProduct.getProduct();
                inventory.getProduct(product);
            } 
            else if (choice == 3) {
                inventory.listInventory();

            } else if (choice == 0) {
                System.out.println("Системээс гарлаа.");
                break;

            } else {
                System.out.println("Буруу сонголт.");
            }
        }
        sc.close();
    }
}