package cz.gyarab.prg.e3.s1.graf_prahy;

import lombok.Data;

@Data
public class Hrana {
    private final Vrchol vrcholA;
    private final Vrchol vrcholB;
    private final double delka;
    private final String jmeno;
}
