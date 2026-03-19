package cz.gyarab.prg.e3.s1.graf_prahy;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class GrafSeznamSousednichHran {
    Map<Vrchol, List<Hrana>> seznamSousedu;

    public GrafSeznamSousednichHran() {
        seznamSousedu = new HashMap<>();
    }

    public GrafSeznamSousednichHran(String seznamVrcholu, String seznamHran) throws IOException {
        Map<Long, Vrchol> pomocnySeznam = new HashMap<>();

        Scanner sc = new Scanner(Paths.get(seznamVrcholu));
        while(sc.hasNext()) {
            long id = sc.nextLong();
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            Vrchol v = new Vrchol(id, x, y);

            System.out.println(v);
            seznamSousedu.put(v, new ArrayList<>());
            pomocnySeznam.put(id, v);
        }


        Scanner sc2 = new Scanner(Paths.get(seznamHran));
        while(sc2.hasNext()) {
            long id1 = sc.nextLong();
            long id2 = sc.nextLong();
            double delka = sc.nextDouble();
            String jmeno = sc.nextLine();

            Vrchol va = pomocnySeznam.get(id1);
            Vrchol vb = pomocnySeznam.get(id2);

            Hrana h = new Hrana(va, vb, delka, jmeno);
            seznamSousedu.get(va).add(h);
            seznamSousedu.get(vb).add(h);
        }
    }

    public void pridejHranu(Vrchol v1, Vrchol v2) {
        // TODO...
    }

}
