package cz.gyarab.prg.e3.s1;

import lombok.ToString;

import java.util.Scanner;

@ToString
public class Halda {
    int[] halda;
    int zaplnenost;

    public Halda(int velikost) {
        halda = new int[velikost];
        zaplnenost = 0;
    }

    public void pridej(int hodnota) {
        halda[zaplnenost] = hodnota;
        int mujIndex = zaplnenost;


        while (mujIndex > 0) {
            int indexOtce = (mujIndex -1) / 2;
            if (halda[mujIndex] < halda[indexOtce]) {
                int temp = halda[mujIndex];
                halda[mujIndex] = halda[indexOtce];
                halda[indexOtce] = temp;
            }
            mujIndex = indexOtce;
        }

        zaplnenost++;
    }

    public int odeberMin() {
        int min = halda[0];


        halda[0] = halda[zaplnenost-1];
        zaplnenost--;

        int aktualniIndex = 0;
        while(true) {
            int indexLeveho = aktualniIndex*2 + 1;
            int indexPraveho = aktualniIndex*2 + 2;
            int indexMensihoSyna =  halda[indexLeveho] < halda[indexPraveho] ? indexLeveho : indexPraveho;
            if (halda[aktualniIndex] > halda[indexMensihoSyna]) {
                int temp = halda[aktualniIndex];
                halda[aktualniIndex] = halda[indexMensihoSyna];
                halda[indexMensihoSyna] = temp;
                aktualniIndex = indexMensihoSyna;
            }

        }


        return min;
    }


    public static void main(String[] args) {
        Halda h = new Halda(10);
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 6; i++) {
            h.pridej(sc.nextInt());

        }
        System.out.println(h);
    }
}
