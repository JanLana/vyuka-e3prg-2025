package cz.gyarab.prg.e3.s1;

import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
public class MujGraf2 {
    List<Uzel> uzly = new ArrayList<>();
    List<Hrana> hrany = new ArrayList<>();

    public void vyrobDomecek() {
        var u1 = new Uzel();
        var u2 = new Uzel();
        var u3 = new Uzel();
        var u4 = new Uzel();
        var u5 = new Uzel();
        var u6 = new Uzel();
        var u7 = new Uzel();
        var u8 = new Uzel();
        var u9 = new Uzel();

        var h1 = new Hrana(u1, u2);
        var h2 = new Hrana(u1, u3);
        var h3 = new Hrana(u2, u4);
        var h4 = new Hrana(u3, u5);
        var h5 = new Hrana(u4, u5);
        var h6 = new Hrana(u4, u6);
        var h7 = new Hrana(u4, u7);


        uzly.add(u1);
        uzly.add(u2);
        uzly.add(u3);
        uzly.add(u4);
        uzly.add(u5);
        uzly.add(u6);
        uzly.add(u7);
        uzly.add(u8);

        hrany.add(h1);
        hrany.add(h2);
        hrany.add(h3);
        hrany.add(h4);
        hrany.add(h5);
        hrany.add(h6);
        hrany.add(h7);
    }

    List<Uzel> kamMuzuJit(Uzel u) {
        List<Uzel> result = new ArrayList();
        for (Hrana h : hrany) {
            if (h.getVrcholA() == u) {
                result.add(h.getVrcholB());
            }
            if (h.getVrcholB() == u) {
                result.add(h.getVrcholA());
            }
        }
        return result;
    }

    void projdiGraf(Uzel zacatek) {
        System.out.println(zacatek);
        zacatek.navstiven = true;

        List<Uzel> kamMuzuJit = kamMuzuJit(zacatek);
        for (Uzel u : kamMuzuJit) {
            if (u.navstiven == false) {
                projdiGraf(u);
            }
        }
    }

    public static void main(String[] args) {
        MujGraf2 graf = new MujGraf2();
        graf.vyrobDomecek();
        //System.out.println(graf);

        Uzel u1 = graf.uzly.get(0);
        graf.projdiGraf(u1);

        System.out.println("====");
        graf.projdiGraf(graf.uzly.get(5));
        System.out.println(" ====");
    }
}
