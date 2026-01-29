package cz.gyarab.prg.e3.s2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MujGraf2 {
    List<Vrchol> vrcholy = new LinkedList<>();
    List<Hrana> hrany = new ArrayList<>();

    public void vyrobKrabici() {
        var v1 = new Vrchol();
        var v2 = new Vrchol();
        var v3 = new Vrchol();
        var v4 = new Vrchol();
        var v5 = new Vrchol();
        var v6 = new Vrchol();
        var v7 = new Vrchol();
        var v8 = new Vrchol();
        vrcholy.add(v1);
        vrcholy.add(v2);
        vrcholy.add(v3);
        vrcholy.add(v4);
        vrcholy.add(v5);
        vrcholy.add(v6);
        vrcholy.add(v7);
        vrcholy.add(v8);

        var h1 = new Hrana(v1, v2);
        var h2 = new Hrana(v1, v3);
        var h3 = new Hrana(v2, v4);
        var h4 = new Hrana(v3, v5);
        var h5 = new Hrana(v3, v6);
        var h6 = new Hrana(v3, v4);
        var h7 = new Hrana(v4, v7);
        var h8 = new Hrana(v4, v8);

        hrany.add(h1);
        hrany.add(h2);
        hrany.add(h3);
        hrany.add(h4);
        hrany.add(h5);
        hrany.add(h6);
        hrany.add(h7);
        hrany.add(h8);
    }

    void projdiGraf(Vrchol zacatek) {
        System.out.println(zacatek);
        zacatek.bylJsemTuCimrman = true;

        List<Vrchol> mojiSousede = seznamSousedu(zacatek);
        for(var v : mojiSousede) {
            if (v.bylJsemTuCimrman == false) {
                projdiGraf(v);
            }
        }
    }

    private List<Vrchol> seznamSousedu(Vrchol zacatek) {
        List<Vrchol> mojiSousede = new LinkedList<>();
        for (Hrana h : hrany) {
            if (h.jsemTvujVrchol(zacatek)) {
                mojiSousede.add(h.dejMiSouseda(zacatek));
            }
        }
        return mojiSousede;
    }

    public static void main(String[] args) {
        MujGraf2 g = new MujGraf2();
        g.vyrobKrabici();

        g.projdiGraf(g.vrcholy.get(5));




    }
}
