package cz.gyarab.prg.e3.s1.matice;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Graf {
    private final List<Vrchol> vrcholy = Arrays.asList(
            new Vrchol("A", 1),
            new Vrchol("B", 2),
            new Vrchol("C", 3),
            new Vrchol("D", 4));

    private final List<Hrana> hrany = Arrays.asList(
            new Hrana(vrcholy.get(0), vrcholy.get(1)),
            new Hrana(vrcholy.get(1), vrcholy.get(2)));


    public static void main(String[] args) {
        Graf g = new Graf();

        int size = g.getVrcholy().size();
        int[][] maticeSouslednosti = new int[size][size];


    }

    private static int[][] vytvorPole(int size) {
        return null;
    }

}