package cz.gyarab.prg.e3.s2;

import java.util.Scanner;

public class MujHash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(;;) {
            String str = sc.nextLine();

            int sum = getSum(str);

            System.out.println(sum);
        }
    }

    private static int getSum(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            sum += ch;
            sum = (sum * sum + 3) % 1013;
        }
        return sum;
    }
}
