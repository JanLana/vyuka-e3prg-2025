package cz.gyarab.prg.e3.s2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MujGraf {
    List<String> vrcholy;
    List<Hrana> hrany;

    public MujGraf() {
        vrcholy  = new ArrayList<>();
        hrany = new ArrayList<>();
    }

    public void vytvorDomecek() {
        vrcholy = Arrays.asList("A", "B", "C", "D", "E");
        hrany = Arrays.asList(
                new Hrana("A", "B"),
                new Hrana("A", "C"),
                new Hrana("A", "D"),
                new Hrana("B", "C"),
                new Hrana("B", "D"),
                new Hrana("C", "D"),
                new Hrana("C", "E"));



    }


    public static void main(String[] args) {
        var g = new  MujGraf();

        System.out.println("Seznam hran:");
        System.out.println("A - B");


    }
}
