package cz.gyarab.prg.e3.s1;

import lombok.Data;

@Data
public class Vrchol {
     static int pocitadlo = 1;
     int id;
     boolean navstiven = false;

    public Vrchol() {
        id = pocitadlo;
        pocitadlo++;
    }

    private final int x;
    private final int y;
}
