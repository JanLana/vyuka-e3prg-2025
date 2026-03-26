package cz.gyarab.prg.e3.s1.matice;

import lombok.Data;

@Data
public class Hrana {
    private final Vrchol v1;
    private final Vrchol v2;

    public Vrchol soused(Vrchol v) {
        return v1.equals(v) ? v2 : (v2.equals(v) ? v1 : null);
    }
}
