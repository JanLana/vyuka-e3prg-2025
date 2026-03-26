package cz.gyarab.prg.e3.s2;

public class Pole2D {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 5, 7, 0},
                {2, 4, 16, 0},
                {3, 8, 3, 0},
        };
        
        vypis(arr);
        
        doplnPosledniSloupec(arr);
        
        vypis(arr);



    }

    private static void doplnPosledniSloupec(int[][] arr) {
    }

    private static void vypis(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
