import java.util.*;

public class NootsUdirdaadag {
    private Map<String, Baraa> baraanuud;

    public NootsUdirdaadag() {
        baraanuud = new HashMap<>();
    }

    public void baraaNemeh(Baraa baraa) {
        if (baraanuud.containsKey(baraa.avKod())) {
            baraanuud.get(baraa.avKod()).shirhegNem(baraa.avShirheg());
        } else {
            baraanuud.put(baraa.avKod(), baraa);
        }
    }

    public boolean borluulah(String kod, int shirheg) {
        Baraa b = baraanuud.get(kod);
        if (b != null && !b.zasvartUu()) {
            return b.shirhegHas(shirheg);
        }
        return false;
    }

    public void haruulah() {
        if (baraanuud.isEmpty()) {
            System.out.println("Нөөцөд бараа байхгүй.");
        } else {
            for (Baraa b : baraanuud.values()) {
                System.out.println(b);
            }
        }
    }

    public Baraa avBaraa(String kod) {
        return baraanuud.get(kod);
    }

    public boolean ustgah(String kod) {
        return baraanuud.remove(kod) != null;
    }

    public Collection<Baraa> buhBaraaAvah() {
        return baraanuud.values();
    }
}
