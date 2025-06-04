package day3;

import java.util.ArrayList;
import java.util.List;

public class ZasvarUdirdaadag {
    private List<Baraa> zasvartai;

    public ZasvarUdirdaadag() {
        zasvartai = new ArrayList<>();
    }

    public void zasvartOruul(Baraa baraa) {
        baraa.zasvartOruul();
        zasvartai.add(baraa);
    }

    public void zasvarDuussan(Baraa baraa) {
        baraa.zasvarDuussan();
        zasvartai.remove(baraa);
    }

    public void haruulah() {
        if (zasvartai.isEmpty()) {
            System.out.println("Засвартай бараа байхгүй.");
        } else {
            for (Baraa b : zasvartai) {
                System.out.println(b);
            }
        }
    }
}

