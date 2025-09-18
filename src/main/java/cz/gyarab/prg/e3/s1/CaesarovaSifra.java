package cz.gyarab.prg.e3.s1;

import java.util.Scanner;

public class CaesarovaSifra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int klic = sc.nextInt();
        String vstup = sc.next();

        for(char znak :  vstup.toCharArray()){
            char novyZnak;

            int k = (int) znak;
            k = k + klic;
            if (k > (int)'z') {
                k = k - 26;
            }
            novyZnak = (char)k;

            System.out.print(novyZnak);
        }
        System.out.println();

    }
}
