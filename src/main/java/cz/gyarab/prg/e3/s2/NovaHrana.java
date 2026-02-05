package cz.gyarab.prg.e3.s2;


import lombok.Data;

@Data
public class NovaHrana {
    private final NovyVrchol vrcholA;
    private final NovyVrchol vrcholB;

    public boolean jsemTvujVrchol(NovyVrchol v) {
        return v == vrcholA || v == vrcholB;
    }

    public NovyVrchol dejMiSouseda(NovyVrchol v) {
        /*
        if (!jsemTvujVrchol(v)) {
            return null;
        } else {
        */
        return v == vrcholA ? vrcholB : vrcholA;
    }
}
