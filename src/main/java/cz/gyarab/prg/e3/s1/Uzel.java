package cz.gyarab.prg.e3.s1;

import lombok.Data;

@Data
public class Uzel {
     static int pocitadlo = 1;
     int id;
     boolean navstiven = false;

    public Uzel() {
        id = pocitadlo;
        pocitadlo++;
    }
}
