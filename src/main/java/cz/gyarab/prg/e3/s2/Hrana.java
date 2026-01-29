package cz.gyarab.prg.e3.s2;


import lombok.Data;

@Data
public class Hrana {
    private final Vrchol vrcholA;
    private final Vrchol vrcholB;

    public boolean jsemTvujVrchol(Vrchol v) {
        return v == vrcholA || v == vrcholB;
    }

    public Vrchol dejMiSouseda(Vrchol v) {
        /*
        if (!jsemTvujVrchol(v)) {
            return null;
        } else {
        */
        return v == vrcholA ? vrcholB : vrcholA;
    }
}
