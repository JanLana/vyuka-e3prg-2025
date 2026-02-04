package cz.gyarab.prg.e3.graf;

import lombok.Data;

import java.io.File;
import java.util.*;

@Data
public class Graf {
    private Map<String, Vrchol> v = new HashMap<>();
    private Collection<Hrana> e = new ArrayList<>();

    public void addVrchol(String jmeno, int x, int y) {
        v.put(jmeno, new Vrchol(jmeno, x, y));
    }

    public void addHrana(String v1, String v2) {
        var a = v.get(v1);
        var b = v.get(v2);
        e.add(new Hrana(a,b));
    }

    public Collection<Vrchol> getV() {
        return v.values();
    }

    public static Graf nactiZeSouboru(String soubor) {
        Graf g = new Graf();
        try (Scanner sc = new Scanner(new File(soubor))) {
            while (sc.hasNext()) {
                switch (sc.next()) {
                    case "V" -> g.addVrchol(sc.next(), sc.nextInt(), sc.nextInt());
                    case "E" -> g.addHrana(sc.next(), sc.next());
                    default -> throw new IllegalStateException("chyba formatu");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return g;
    }
}
