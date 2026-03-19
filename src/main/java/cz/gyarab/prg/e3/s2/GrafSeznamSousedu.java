package cz.gyarab.prg.e3.s2;

import java.util.*;

public class GrafSeznamSousedu {
    Map<Vrchol, Set<Vrchol>> seznamSousedu;

    public GrafSeznamSousedu() {
        this.seznamSousedu = new HashMap<>();
    }

    public void pridejVrchol(Vrchol v) {
        if (!seznamSousedu.containsKey(v)) {
            seznamSousedu.put(v, new HashSet<>());
        }
    }

    public void pridejHranu(Vrchol v1, Vrchol v2) {
        pridejVrchol(v1);
        pridejVrchol(v2);
        seznamSousedu.get(v1).add(v2);
        seznamSousedu.get(v2).add(v1);
    }

}
