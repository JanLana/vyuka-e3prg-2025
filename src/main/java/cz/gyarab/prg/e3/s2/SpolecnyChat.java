package cz.gyarab.prg.e3.s2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SpolecnyChat {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql:db3963", "db3963", "programovani")) {
            try (Statement stmt = conn.createStatement()) {
                var rs = stmt.executeQuery("SELECT * FROM msg ORDER BY poradi");
            }
        }  catch (SQLException e) {
            //System.out.println("Chyba:\n\t" + e.getMessage());
            e.printStackTrace();
        }
    }
}
