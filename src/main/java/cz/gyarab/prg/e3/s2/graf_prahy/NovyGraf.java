package cz.gyarab.prg.e3.s2.graf_prahy;

import lombok.Data;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

@Data
public class NovyGraf {
    private final Map<Vrchol, List<Hrana>> seznamSousedu;

    private final Map<Long, Vrchol> seznamVrcholu;

    public NovyGraf() {
        this.seznamSousedu = new HashMap<>();
        this.seznamVrcholu = new HashMap<>();
    }

    public void nactiVrcholy(String soubor) throws IOException {
        Scanner sc = new Scanner(Paths.get(soubor));
        while(sc.hasNext()) {
            long id = sc.nextLong();
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            Vrchol vrchol = new Vrchol(id, x, y);
            seznamSousedu.put(vrchol, new ArrayList<>());
            seznamVrcholu.put(id, vrchol);
        }

    }

    public void nactiHrany(String soubor) throws IOException {
        Scanner sc = new Scanner(Paths.get(soubor));
        while(sc.hasNext()) {
            long id1 = sc.nextLong();
            long id2 = sc.nextLong();
            double delka = sc.nextDouble();
            String jmeno = sc.nextLine();

            Vrchol vA = seznamVrcholu.get(id1);
            Vrchol vB = seznamVrcholu.get(id2);
            Hrana h = new Hrana(vA, vB, delka, jmeno);
            seznamSousedu.get(vA).add(h);
            seznamSousedu.get(vB).add(h);
        }

    }

    public static void main(String[] args) throws IOException {
        NovyGraf g = new NovyGraf();
        g.nactiVrcholy("praha_uzly.csv");
        g.nactiHrany("praha_hrany.csv");
    }
}
