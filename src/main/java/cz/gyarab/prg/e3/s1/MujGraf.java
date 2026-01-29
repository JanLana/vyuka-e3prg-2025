package cz.gyarab.prg.e3.s1;

import java.util.ArrayList;

public class MujGraf {
    ArrayList<Vrchol> vrcholy;
    ArrayList<Hrana> hrany;

    public MujGraf() {
        vrcholy = new ArrayList<>();
        hrany = new ArrayList<>();
    }

    public void vyrobDomecek() {
        Vrchol vrcholA =new Vrchol("A");
        Vrchol vrcholB =new Vrchol("B");
        vrcholy.add(vrcholA);
        vrcholy.add(vrcholB);
        vrcholy.add(new Vrchol("C"));
        vrcholy.add(new Vrchol("D"));
        vrcholy.add(new Vrchol("E"));

        //hrany.add(new Hrana(vrcholA,vrcholB));
    }

    public static void main(String[] args) {
        MujGraf g = new MujGraf();
        g.vyrobDomecek();

        System.out.println("Hrany grafu:");



    }
}
