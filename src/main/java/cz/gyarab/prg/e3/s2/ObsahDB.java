package cz.gyarab.prg.e3.s2;

import cz.gyarab.prg.e3.s1.SpolecnyChatCtenar;

import java.sql.*;
import java.util.Scanner;

public class ObsahDB {

    public static void main(String[] args) {
        VypisChat vlakno = new VypisChat();
        vlakno.start();
        
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql:db3963", "db3963", "programovani")) {
            conn.setAutoCommit(false);
            for (; ; ) {
                String msg = sc.nextLine();
                ulozDoDB(conn, msg);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void ulozDoDB(Connection conn, String msg) throws SQLException {
        int posledniPoradi = 0;
        insertMsg(conn, posledniPoradi, msg);
        conn.commit();
    }

    private static void insertMsg(Connection conn, int posledniPoradi, String msg) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            String sql = "INSERT INTO zprava (poradi, autor, msg) VALUES (" + (posledniPoradi + 1) + ", 'ja', '" + msg + "')";
            System.out.println(sql);
            stmt.executeUpdate(sql);
        }
    }
}

