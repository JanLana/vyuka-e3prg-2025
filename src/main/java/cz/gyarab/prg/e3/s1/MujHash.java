package cz.gyarab.prg.e3.s1;

import java.util.Scanner;

public class MujHash {
    static String abeceda = "aábcčdďeáěfghiíjklmnoópqrřsštťuúůvwxyýzž";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                for (char k = 'a'; k <= 'z'; k++) {
                    String slovo = i + "" + j + "" + k;
                    long vysledek = getSum(slovo);
                    if (vysledek == 221) {
                        System.out.println(slovo);
                    }
                }
            }
        }
    }

    private static long getSum(String vstup) {
        long sum = 0;
        for (char ch : vstup.toCharArray()) {
            sum += (long)ch;
            sum = (sum*sum+3) % 1013;
        }
        return sum;
    }
}
