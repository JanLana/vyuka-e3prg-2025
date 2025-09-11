package cz.gyarab.prg.e3.s2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Median {
    public static void main(String[] args) throws FileNotFoundException {
        //File file = new File("vstup.txt");
        //Scanner input = new Scanner(file);

        var pole = new ArrayList<Integer>();
        var soubor = new File("vstup.txt");
        var input = new Scanner(soubor);

        while (input.hasNext()) {
            pole.add(input.nextInt());
        }

        //pole.sort((a, b) -> a - b);
        //pole.sort(null);
        setridPole(pole);


        System.out.println(pole.get((pole.size() - 1) / 2));
    }

    private static void setridPole(ArrayList<Integer> pole) {
        for (int i = 0; i < pole.size(); i++) {
            int mistoKdeJe = najdiNejmensi(pole, i);

            //pole[i] <-> pole[mistoKdeJe]
        }
    }

    private static int najdiNejmensi(ArrayList<Integer> pole, int from) {
        int mistoKdeJeNejmensiPrvek = from;

        for(int i = from+1; i < pole.size(); i++) {
            if (pole.get(i) < pole.get(mistoKdeJeNejmensiPrvek)) {
                mistoKdeJeNejmensiPrvek = i;
            }
        }
        return mistoKdeJeNejmensiPrvek;
    }


}
