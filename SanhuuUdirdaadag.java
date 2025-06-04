package day3;

public class SanhuuUdirdaadag {
    private double orlogo;
    private double zarlaga;

    public void orlogoNemeh(double dun) {
        orlogo += dun;
    }

    public void zarlagaNemeh(double dun) {
        zarlaga += dun;
    }

    public void tailan() {
        System.out.println("Нийт орлого: ₮" + orlogo);
        System.out.println("Нийт зарлага: ₮" + zarlaga);
        System.out.println("Цэвэр ашиг: ₮" + (orlogo - zarlaga));
    }
}
