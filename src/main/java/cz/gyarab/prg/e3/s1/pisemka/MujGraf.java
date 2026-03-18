package cz.gyarab.prg.e3.s1.pisemka;


import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class MujGraf {
    private final List<Vrchol> vrcholy;
    private final List<Hrana> hrany;

    public MujGraf() {
        Vrchol a = new Vrchol("A", 1);
        Vrchol b = new Vrchol("B", 2);
        Vrchol c = new Vrchol("C", 3);
        vrcholy = Arrays.asList(a, b, c);
        hrany = Arrays.asList(
                new Hrana(a, b),
                new Hrana(b, c)
        );
    }

    public String toString() {
        return "Vrcholy: " + vrcholy.stream().map(x -> x.getName()).collect(Collectors.joining(", ")) + "\n"
            + "Hrany: " + hrany.stream().map(x -> x.getV1().getName() + " <-> " + x.getV2().getName()).collect(Collectors.joining(", "));
    }

    public List<Vrchol> sousedi(Vrchol v) {
        return hrany.stream().map(x -> x.soused(v)).filter(Objects::nonNull).toList();
    }

    public static void main(String[] args) {
        MujGraf g = new MujGraf();
        System.out.println(g);
        g.getVrcholy().forEach(v -> System.out.println("sousedi " + v + ": " + g.sousedi(v)));
    }

}
