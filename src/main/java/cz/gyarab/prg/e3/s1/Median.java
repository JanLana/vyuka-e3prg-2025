package cz.gyarab.prg.e3.s1;

import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Median {

    static class Prvek {
        private int hodnota;
        private Prvek dalsi;

        public Prvek(int hodnota, Prvek dalsi) {
            this.hodnota = hodnota;
            this.dalsi = dalsi;
        }
    }


    public static void main(String[] args) throws FileNotFoundException {

        var file = new File("vstup.txt");
        var input = new Scanner(file);

        var list = new ArrayList<Integer>();
        while (input.hasNext()) {
            list.add(input.nextInt());
        }

        //list.sort(null);
        setridPole(list);

        System.out.println(list.get(list.size() / 2));

    }

    public static void setridPole(List<Integer> arr) {
        Prvek hlava = new Prvek(arr.get(0), null);

        for (int i = 1; i < arr.size(); i++) {
            int hodnota = arr.get(i);



        }


    }

}
