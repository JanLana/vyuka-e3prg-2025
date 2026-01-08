package cz.gyarab.prg.e3.s2;

import java.sql.*;

public class VypisChat extends Thread {

    public void run() {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql:db3963", "db3963", "programovani")) {
            vypisChat(conn);

        } catch (SQLException | InterruptedException e) {
            //System.out.println("Chyba:\n\t" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void vypisChat(Connection conn) throws SQLException, InterruptedException {
        int posledniPoradi = 0;

        for(;;) {
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM zprava WHERE poradi > " + posledniPoradi);

                while (rs.next()) {
                    String msg = rs.getString("msg");
                    int poradi = rs.getInt("poradi");
                    posledniPoradi = poradi;

                    System.out.println("" + poradi + ". " + msg);
                }
            }

            Thread.sleep(3000);
        }
    }
}
