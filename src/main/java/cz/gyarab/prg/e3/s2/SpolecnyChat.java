package cz.gyarab.prg.e3.s2;

import cz.gyarab.prg.e3.s1.SpolecnyChatCtenar;

import java.sql.*;
import java.util.Scanner;

public class SpolecnyChat {
    public static void main(String[] args) {
        SpolecnyChatCtenar ctenar = new SpolecnyChatCtenar();
        ctenar.start();

        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql:db3963", "db3963", "programovani")) {
            System.out.println("cekam na vstup z klavesnice ....");

            for(;;) {
                String zprava = sc.nextLine();
                ulozZpravuDoDB(conn, zprava);
            }

        }  catch (SQLException  e) {
            //System.out.println("Chyba:\n\t" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void ulozZpravuDoDB(Connection conn, String zprava) throws SQLException {
        System.out.println("ukladam zpravu");

        int poradi = najdiPosledniPoradi(conn);

        System.out.println("poradi: " + poradi);
    }

    private static int najdiPosledniPoradi(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT MAX(poradi) FROM zprava";

            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
            return 0;
        }
    }
}

