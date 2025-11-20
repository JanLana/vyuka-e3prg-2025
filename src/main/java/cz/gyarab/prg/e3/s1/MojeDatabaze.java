package cz.gyarab.prg.e3.s1;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MojeDatabaze {
    public static void main(String[] args) {
        List<Clovek> lidi = new ArrayList<>();
        lidi.add(new Clovek("Jan", "Lana", 3));
        lidi.add(new Clovek("Maria", "Lanova", 4));
        lidi.add(new Clovek("Pepa", "Zdepa", 1));

        System.out.println(lidi);


        try (Connection conn = DriverManager.getConnection("jdbc: ......", null, null);
             Statement stmt = conn.createStatement()) {
            String sqlPrikaz = "INSERT INTO clovek(jmeno, prijmeni, rocnik) VALUES ('"
                        + lidi.get(0).getJmeno() + "', '"
                        + lidi.get(0).getPrimeni() + "',"
                        + lidi.get(0).getRocnik() + ")";
            System.out.println(sqlPrikaz);
            stmt.executeUpdate(sqlPrikaz);
        } catch (SQLException e) {
            System.out.println("Nastala vyjimka");
            throw new RuntimeException(e);
        }
    }
}
