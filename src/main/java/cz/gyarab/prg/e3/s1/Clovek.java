package cz.gyarab.prg.e3.s1;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Clovek {
    private final String jmeno;
    private final String primeni;
    private final int rocnik;

    //private final LocalDate datumNarozeni;
}
