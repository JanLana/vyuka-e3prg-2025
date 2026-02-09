package cz.gyarab.prg.e3.s1;

import java.util.ArrayList;

public class MujGraf {
    ArrayList<VrcholStary> vrcholy;
    ArrayList<Hrana> hrany;

    public MujGraf() {
        vrcholy = new ArrayList<>();
        hrany = new ArrayList<>();
    }

    public void vyrobDomecek() {
        VrcholStary vrcholA = new VrcholStary("A");
        VrcholStary vrcholB =new VrcholStary("B");
        vrcholy.add(vrcholA);
        vrcholy.add(vrcholB);
        vrcholy.add(new VrcholStary("C"));
        vrcholy.add(new VrcholStary("D"));
        vrcholy.add(new VrcholStary("E"));

        //hrany.add(new Hrana(vrcholA,vrcholB));
    }

    public static void main(String[] args) {
        MujGraf g = new MujGraf();
        g.vyrobDomecek();

        System.out.println("Hrany grafu:");



    }
}
