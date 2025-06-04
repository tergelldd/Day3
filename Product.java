public class Product {
    private String name;
    private String code;
    private int quantity;

    public Product(String name, String code, int quantity) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int qty) {
        this.quantity += qty;
    }

    public boolean removeQuantity(int qty) {
        if (qty > quantity) return false;
        this.quantity -= qty;
        return true;
    }

    @Override
    public String toString() {
        return code + " - " + name + " | Үлдэгдэл: " + quantity + " ширхэг";
    }
}