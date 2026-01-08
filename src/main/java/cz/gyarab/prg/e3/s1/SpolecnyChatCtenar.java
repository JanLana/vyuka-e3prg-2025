package cz.gyarab.prg.e3.s1;

import java.sql.*;

public class SpolecnyChatCtenar extends Thread {
    @Override
    public void run() {
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql:db3963", "db3963", "programovani")) {
            sledujChat(conn);

        }  catch (SQLException | InterruptedException e) {
            //System.out.println("Chyba:\n\t" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void sledujChat(Connection conn) throws SQLException, InterruptedException {
        int posledniId = 0;
        for(;;) {
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM zprava WHERE poradi > " + posledniId + " ORDER BY poradi";
                //System.out.println(sql);

                try (ResultSet rs = stmt.executeQuery(sql)) {
                    while (rs.next()) {
                        String autor = rs.getString("autor");
                        String zprava = rs.getString("msg");
                        posledniId = rs.getInt("poradi");

                        System.out.println(autor + ": " + zprava);
                    }
                }
            }

            Thread.sleep(3000);
        }
    }
}
