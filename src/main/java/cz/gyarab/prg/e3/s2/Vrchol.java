package cz.gyarab.prg.e3.s2;

import lombok.Data;

@Data
public class Vrchol {
    static int pocitadlo = 1;
    int id;
    boolean bylJsemTuCimrman = false;

    public Vrchol() {
        id = pocitadlo;
        pocitadlo++;
    }

    @Override
    public String toString() {
        return "Vrchol{" +
                "id=" + id +
                ", pocitadlo=" + pocitadlo +
                '}';
    }
}
