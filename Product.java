package day3;
import java.time.LocalDate;

public class Product {
    private String ner; 
    private String code; 
    private int baraaniiToo; 
    private boolean zaswartaiBaraa; 
    private LocalDate duusahOgnoo; 

    public Product(String ner, String code, int baraaniiToo, boolean zaswartaiBaraa, LocalDate duusahOgnoo) {
        this.ner = ner;
        this.code = code;
        this.baraaniiToo = baraaniiToo;
        this.zaswartaiBaraa = zaswartaiBaraa;
        this.duusahOgnoo = duusahOgnoo;
    }

    public String getCode() {
        return code;
    }

    public int getBaraaniiToo() {
        return baraaniiToo;
    }

    public boolean isZaswartaiBaraa() {
        return zaswartaiBaraa;
    }

    public LocalDate getDuusahOgnoo() {
        return duusahOgnoo;
    }

    public void nemToo(int too) {
        this.baraaniiToo += too;
    }

    public boolean hasahToo(int too) {
        if (too > baraaniiToo) return false;
        this.baraaniiToo -= too;
        return true;
    }

    @Override
    public String toString() {
        return "Code: " + code + " | Ner: " + ner +
               " | Too: " + baraaniiToo +
               " | Zaswartai: " + (zaswartaiBaraa ? "Tiim" : "Ugui") +
               " | Duusah ognoo: " + duusahOgnoo;
    }
}
