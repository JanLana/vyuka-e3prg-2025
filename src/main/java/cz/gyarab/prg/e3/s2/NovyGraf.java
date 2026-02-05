package cz.gyarab.prg.e3.s2;

import lombok.Data;

import java.io.File;
import java.nio.channels.NotYetBoundException;
import java.util.*;

@Data
public class NovyGraf {
    List<NovyVrchol> vrcholy = new LinkedList<>();
    List<NovaHrana> hrany = new ArrayList<>();

    public NovyGraf(String jmenoSouboru) {
        Map<Integer, NovyVrchol> mapaIdVrchol = new HashMap<>();

        try(Scanner sc = new Scanner(new File(jmenoSouboru))) {
            while (sc.hasNext()) {
                switch (sc.next()) {
                    case "v":
                        mapaIdVrchol.put(sc.nextInt(), new NovyVrchol(sc.next()));
                        break;
                    case "e":
                        hrany.add(new NovaHrana(mapaIdVrchol.get(sc.nextInt()), mapaIdVrchol.get(sc.nextInt())));
                        break;
                    default:
                        throw new NoSuchElementException();
                }
            }
           vrcholy.addAll(mapaIdVrchol.values());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<NovyVrchol> getVrcholy() {}

    public void projdiDoHloubky(NovyVrchol zacatek) {
        ArrayDeque<NovyVrchol> zasobnik = new ArrayDeque();
        Set<NovyVrchol> navstiveneVrcholy = new HashSet<>();

        zasobnik.add(zacatek);
        navstiveneVrcholy.add(zacatek);

        while(!zasobnik.isEmpty()) {
            NovyVrchol vrchol = zasobnik.poll();
            System.out.println(vrchol);

            for (NovyVrchol soused : seznamVsechSousedu(vrchol)) {
                if (!navstiveneVrcholy.contains(soused)) {
                    zasobnik.add(soused);
                    navstiveneVrcholy.add(soused);
                }
            }
        }

    }

    public static void main(String[] args) {
        NovyGraf g = new NovyGraf("elSit.txt");
        System.out.println(g);
    }
}
