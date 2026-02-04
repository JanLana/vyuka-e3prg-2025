package cz.gyarab.prg.e3.graf;

import lombok.Data;

@Data
public class Vrchol {
    private final String jmeno;
    private final int x;
    private final int y;

    private boolean navstiven;
}
