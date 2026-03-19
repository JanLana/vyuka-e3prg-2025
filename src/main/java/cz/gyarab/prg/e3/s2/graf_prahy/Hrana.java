package cz.gyarab.prg.e3.s2.graf_prahy;

import lombok.Data;

@Data
public class Hrana {
    private final Vrchol vrcholA;
    private final Vrchol vrcholB;
    private final double delkaVMetrech;
    private final String jmeno;
}
