package cz.gyarab.prg.e3.s1.pisemka;


import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Data
public class MujGraf2 {
    private final List<Vrchol> vrcholy = Arrays.asList(
            new Vrchol("A", 1),
            new Vrchol("B", 2),
            new Vrchol("C", 3),
            new Vrchol("D", 4));

    private final List<Hrana> hrany = Arrays.asList(
            new Hrana(vrcholy.get(0), vrcholy.get(1)),
            new Hrana(vrcholy.get(1), vrcholy.get(2)));

    public List<Vrchol> sousedi(Vrchol v) {
        return hrany.stream().map(x -> x.soused(v)).filter(Objects::nonNull).toList();
    }

    public static void main(String[] args) {
        MujGraf2 g = new MujGraf2();
        System.out.println(g);
        g.getVrcholy().forEach(v -> System.out.println("sousedi " + v + ": " + g.sousedi(v)));
    }

}
