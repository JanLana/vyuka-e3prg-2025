package cz.gyarab.prg.e3.s1;

import java.util.Scanner;

public class Halda {
    int[] halda;
    int zaplnenost;

    public Halda(int velikost) {
        halda = new int[velikost];
        zaplnenost = 0;
    }

    p

    public void pridej(int hodnota) {
        halda[zaplnenost] = hodnota;
        int mujIndex = zaplnenost;


        while (mujIndex > 0) {
            int indexOtce = ((mujIndex + 1) / 2) - 1;
            if (halda[mujIndex] < halda[indexOtce]) {
                int temp = halda[mujIndex];
                halda[mujIndex] = halda[indexOtce];
                halda[indexOtce] = temp;
            }
            mujIndex = indexOtce;
        }

        zaplnenost++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pocet = 0;
        for(;;) {
            int i = sc.nextInt();
            if (i == 0) {
                break;
            }
            pocet++;
        }
        System.out.println(pocet);


    }
}
