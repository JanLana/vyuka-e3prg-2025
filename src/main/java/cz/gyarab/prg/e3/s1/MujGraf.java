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
        VrcholStary vrcholA = new VrcholStary("A",0,0);
        VrcholStary vrcholB =new VrcholStary("B",0,0);
        vrcholy.add(vrcholA);
        vrcholy.add(vrcholB);
        vrcholy.add(new VrcholStary("C", 0,0));
        vrcholy.add(new VrcholStary("D", 0,0));
        vrcholy.add(new VrcholStary("E", 0,0));

        //hrany.add(new Hrana(vrcholA,vrcholB));
    }

    public static void main(String[] args) {
        MujGraf g = new MujGraf();
        g.vyrobDomecek();

        System.out.println("Hrany grafu:");



    }
}
