package day3;

import java.time.LocalDate;

public class Baraa {
    private String kod;
    private String ner;
    private double une;
    private int shirheg;
    private boolean zasvartai;
    private LocalDate ognoo;

    public Baraa(String kod, String ner, double une, int shirheg) {
        this.kod = kod;
        this.ner = ner;
        this.une = une;
        this.shirheg = shirheg;
        this.zasvartai = false;
        this.ognoo = LocalDate.now();
    }

    public String avKod() { return kod; }
    public String avNer() { return ner; }
    public double avUne() { return une; }
    public int avShirheg() { return shirheg; }
    public boolean zasvartUu() { return zasvartai; }
    public LocalDate avOgnoo() { return ognoo; }

    public void zasvartOruul() { zasvartai = true; }
    public void zasvarDuussan() { zasvartai = false; }
    public void shirhegNem(int too) { shirheg += too; }
    public boolean shirhegHas(int too) {
        if (shirheg >= too) {
            shirheg -= too;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %dш @ ₮%.2f (%s)",
            kod, ner, shirheg, une, zasvartai ? "Засвартай" : "Ашиглаж болно");
    }
}
