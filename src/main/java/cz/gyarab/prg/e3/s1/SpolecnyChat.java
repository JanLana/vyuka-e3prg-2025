package cz.gyarab.prg.e3.s1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SpolecnyChat {

        public static void main(String[] args) {

            try (Connection conn = DriverManager.getConnection("jdbc:postgresql:db3963", "db3963", "programovani")) {

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
