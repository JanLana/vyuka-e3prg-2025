package cz.gyarab.prg.e3.s2;

import java.util.Scanner;

public class CaesarovaSifra {
    static String abeceda = "aábcčdďeáěfghiíjklmnoópqrřsštťuúůvwxyýzž";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int klic = sc.nextInt();
        String vstup = sc.next();

        for(char znak : vstup.toCharArray()) {
            int k = abeceda.indexOf(znak);
            //int k = (int)znak;
            k = k + klic;

            if (k >= abeceda.length()) {
                k -= abeceda.length();
            }
            if (k < 0) {
                k += abeceda.length();
            }

            //k = k % abeceda.length();

            char novyZnak = abeceda.charAt(k);

            System.out.print(novyZnak);
        }
        System.out.println();
    }
}
