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

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:lide.db")) {
            vytvorTabulku(conn);

            for (Clovek c : lidi) {
                vlozCloveka(c, conn);
            }
        }  catch (SQLException e) {
            System.out.println("udelal jsem vse co muzu, takze to ignoruju, ze\n\t" + e.getMessage());
        }
    }

    private static void vlozCloveka(Clovek c, Connection conn) throws SQLException {
        if (existujeClovekDB(c, conn) == false) {
            String sql2 = "INSERT INTO clovek VALUES ('" + c.getJmeno() + "','" + c.getPrijmeni() + "'," + c.getRokNarozeni() + ")";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(sql2);
            }
        }
    }

    private static boolean existujeClovekDB(Clovek c, Connection conn) {
        return false;
    }


    private static void vytvorTabulku(Connection conn) throws SQLException {
        String sql = "CREATE TABLE clovek (jmeno INT, prijmeni DATE, rokNarozeni INTEGER)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            if (e.getMessage().contains("table clovek already exists")) {
                // uz tabulka existuje, je to ok!
            } else {
                throw e;
            }
        }
    }
}
