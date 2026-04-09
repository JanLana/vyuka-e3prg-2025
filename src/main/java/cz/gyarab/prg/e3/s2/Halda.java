package cz.gyarab.prg.e3.s2;

public class Halda {
    int[] halda;
    int pocetPrvku;

    public Halda(int maxVelikost) {
        halda = new int[maxVelikost];
        pocetPrvku = 0;
    }

    public int dejNejmensi() {
        if (pocetPrvku == 0) {
            throw new IndexOutOfBoundsException();
        }
        return halda[0];
    }

    public void pridej(int prvek) {
        int indexNovehoPrvku = pocetPrvku;
        halda[indexNovehoPrvku] = prvek;

        while (indexNovehoPrvku > 0) {
            int indexPredka = ((indexNovehoPrvku + 1) / 2) - 1;

            if (halda[indexNovehoPrvku] < halda[indexPredka]) {
                int tmp = halda[indexNovehoPrvku];
                halda[indexNovehoPrvku] = halda[indexPredka];
                halda[indexPredka] = tmp;
            }
            indexNovehoPrvku = indexPredka;
        }


        pocetPrvku++;
    }
}
