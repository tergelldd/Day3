package day3;

import java.util.ArrayList;
import java.util.List;

public class ArchivtHadgalagch {
    private List<Baraa> arhiv;

    public ArchivtHadgalagch() {
        arhiv = new ArrayList<>();
    }

    public void arhivtOruul(Baraa baraa) {
        arhiv.add(baraa);
    }

    public void haruulah() {
        if (arhiv.isEmpty()) {
            System.out.println("Архивт бараа байхгүй.");
        } else {
            for (Baraa b : arhiv) {
                System.out.println(b);
            }
        }
    }
}
