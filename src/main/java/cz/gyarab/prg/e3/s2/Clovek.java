package cz.gyarab.prg.e3.s2;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Clovek {
    private final String jmeno;
    private final String prijmeni;
    private final int rokNarozeni;

    public static void main(String[] args) {
        List<Clovek> lidi = Arrays.asList(
                new Clovek("Jan", "Lana", 1974),
                new Clovek("Pepa", "Zdepa", 2000),
                new Clovek("Jara", "Cimrman", 1800));

        System.out.println(lidi);

        Connection conn = null;
        Statement stmt = null;

        try (Connection conn = DriverManager.getConnection("jdbc: ......", null, null)) {
            try (var stmt = conn.createStatement()) {
                String sqlPrikaz = "INSERT INTO clovek (jmeno, prijmeni, rok_narozeni) VALUES ('"
                        + lidi.get(0).getJmeno() + "', '"
                        + lidi.get(0).getPrijmeni() + "', " + lidi.get(0).getRokNarozeni() + ")";

                stmt.executeUpdate(sqlPrikaz);
            }
        }  catch (SQLException e) {
            System.out.println("udelal jsem vse co muzu, takze to ignoruju...");
        }

    }
}
