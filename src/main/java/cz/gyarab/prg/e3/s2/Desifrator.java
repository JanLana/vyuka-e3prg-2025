package cz.gyarab.prg.e3.s2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Desifrator {
    public static void main(String[] args) throws IOException {

        String vstup = Files.readString(Paths.get("zprava.txt"));

        Map<Character, Character> map = Map.of(
                'v', 'E',
                'z', 'A',
                'l', 'O'
        );


        for(char ch: vstup.toCharArray()) {
            if (map.containsKey(ch)) {
                System.out.println(map.get(ch));
            } else {
                System.out.println(ch);
            }
            /*
            if (ch == 'v')
                System.out.print("E");
            else if (ch == 'z')
                System.out.print("A");
            else if (ch == 'l')
                System.out.print("O");
            else
                System.out.print(ch);

             */
        }

    }
}
