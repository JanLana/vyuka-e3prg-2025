package cz.gyarab.prg.e3.s1;

import java.lang.reflect.Array;
import java.sql.*;
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


        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db")) {
            vytvorTabulku(conn, "CREATE TABLE IF NOT EXISTS clovek (jmeno VARCHAR, prijmeni INT, rocnik VARCHAR)");

            for (Clovek c : lidi) {
                vlozDoTabulkyClovek(c, conn);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /*
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

         */
    }

    private static void vlozDoTabulkyClovek(Clovek c, Connection conn) throws SQLException {
        if (! existujeClovekVDB(c, conn)) {
            String sql = "INSERT INTO clovek VALUES ('" + c.getJmeno() + "', '" + c.getPrimeni() + "', " + c.getRocnik() + ")";
            //System.out.println(sql);

            try (Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
            }
        }
    }

    private static boolean existujeClovekVDB(Clovek c, Connection conn) throws SQLException {
        String sql = "SELECT * FROM clovek WHERE  jmeno = '" + c.getJmeno() + "' AND prijmeni = '" + c.getPrimeni() + "'";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return false;
            } else {
                return true;
            }

        }
    }


    private static void vytvorTabulku(Connection conn, String sql) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } /*catch (SQLException e) {
            if (e.getMessage().contains("table clovek already exists")) {
                // vse v poradku
            } else {
                throw e;
            }
        } */
    }
}
