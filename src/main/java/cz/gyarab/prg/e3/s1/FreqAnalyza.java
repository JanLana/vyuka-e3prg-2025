package cz.gyarab.prg.e3.s1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FreqAnalyza {
    public static void main(String[] args) throws IOException {
        //String bezHackuACarek = Normalizer.normalize(vstup,Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        //String jenMalaPismena = vstup.toLowerCase();

        String vstup = Files.readString(Paths.get("complet.txt"));
        Map<Character,Integer> map = new HashMap<>();

        for(char ch : vstup.toCharArray()) {
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }

        while(map.size()>0) {
            char znak = ' ';
            int pocet = 0;
            for (Map.Entry<Character,Integer> entry : map.entrySet()) {
                if(entry.getValue()>pocet) {
                    pocet = entry.getValue();
                    znak = entry.getKey();
                }
            }
            System.out.println(znak + " " + pocet);
            map.remove(znak);
        }
    }
}
