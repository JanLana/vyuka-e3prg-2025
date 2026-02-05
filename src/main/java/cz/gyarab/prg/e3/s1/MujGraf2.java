package cz.gyarab.prg.e3.s1;

import lombok.ToString;

import java.util.*;

@ToString
public class MujGraf2 {
    List<Vrchol> vrcholy = new ArrayList<>();
    List<Hrana> hrany = new ArrayList<>();

    public void vyrobDomecek() {
        var u1 = new Vrchol();
        var u2 = new Vrchol();
        var u3 = new Vrchol();
        var u4 = new Vrchol();
        var u5 = new Vrchol();
        var u6 = new Vrchol();
        var u7 = new Vrchol();
        var u8 = new Vrchol();
        var u9 = new Vrchol();

        var h1 = new Hrana(u1, u2);
        var h2 = new Hrana(u1, u3);
        var h3 = new Hrana(u2, u4);
        var h4 = new Hrana(u3, u5);
        var h5 = new Hrana(u4, u5);
        var h6 = new Hrana(u4, u6);
        var h7 = new Hrana(u4, u7);
        hrany.add(new Hrana(u5, u8));



        vrcholy.add(u1);
        vrcholy.add(u2);
        vrcholy.add(u3);
        vrcholy.add(u4);
        vrcholy.add(u5);
        vrcholy.add(u6);
        vrcholy.add(u7);
        vrcholy.add(u8);

        hrany.add(h1);
        hrany.add(h2);
        hrany.add(h3);
        hrany.add(h4);
        hrany.add(h5);
        hrany.add(h6);
        hrany.add(h7);
    }

    List<Vrchol> kamMuzuJit(Vrchol u) {
        List<Vrchol> result = new ArrayList();
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


    void projdiGraf(Vrchol zacatek) {
        System.out.println(zacatek);
        zacatek.navstiven = true;

        List<Vrchol> kamMuzuJit = kamMuzuJit(zacatek);
        for (Vrchol u : kamMuzuJit) {
            if (u.navstiven == false) {
                projdiGraf(u);
            }
        }
    }

    void projdiGrafDoHloubky(Vrchol zacatek) {
        Set<Vrchol> navstiveno = new HashSet<>();
        Deque<Vrchol> vrcholyKNavstiveni = new ArrayDeque<>();

        vrcholyKNavstiveni.add(zacatek);

        while(!vrcholyKNavstiveni.isEmpty()) {
            Vrchol u = vrcholyKNavstiveni.poll();
            navstiveno.add(u);

            System.out.print(u.id + " ");

            for (Vrchol soused: kamMuzuJit(u)) {
                if (!navstiveno.contains(soused)) {
                    vrcholyKNavstiveni.add(soused);
                }
            }
        }

        System.out.println();
    }

    void projdiGrafDoSirky(Vrchol zacatek) {
        Set<Vrchol> navstiveno = new HashSet<>();
        Queue<Vrchol> vrcholyKNavstiveni = new LinkedList<>();

        vrcholyKNavstiveni.add(zacatek);

        while(!vrcholyKNavstiveni.isEmpty()) {
            Vrchol u = vrcholyKNavstiveni.remove();
            navstiveno.add(u);

            System.out.print(u.id + " ");

            for (Vrchol soused: kamMuzuJit(u)) {
                if (!navstiveno.contains(soused)) {
                    vrcholyKNavstiveni.add(soused);
                }
            }
        }
        System.out.println();
    }



    public static void main(String[] args) {
        MujGraf2 graf = new MujGraf2();
        graf.vyrobDomecek();
        //System.out.println(graf);

        Vrchol u1 = graf.vrcholy.get(0);
        System.out.print("Do hloubky: ");
        graf.projdiGrafDoHloubky(u1);
        System.out.print("Do sirky: ");
        graf.projdiGrafDoSirky(u1);

    }
}
