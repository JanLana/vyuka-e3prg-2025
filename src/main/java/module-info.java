module cz.gyarab.prg.e3.graf {
    requires javafx.controls;
    requires javafx.fxml;

    requires static lombok;
    requires java.sql;

    opens cz.gyarab.prg.e3.graf to javafx.fxml;
    exports cz.gyarab.prg.e3.graf;
}