import java.time.LocalDate;

public class Product {
    private String name;
    private String code;
    private int quantity;
    private boolean underRepair;
    private LocalDate expirationDate;

    public Product(String name, String code, int quantity, boolean underRepair, LocalDate expirationDate) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.underRepair = underRepair;
        this.expirationDate = expirationDate;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isUnderRepair() {
        return underRepair;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
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
        return "Код: " + code + " | Нэр: " + name +
               " | Үлдэгдэл: " + quantity +
               " | Засвартай: " + (underRepair ? "Тийм" : "Үгүй") +
               " | Дуусах огноо: " + expirationDate;
    }
}