package cz.gyarab.prg.e3.s2;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Sifrovac {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);
        String vstup = scan.nextLine();

        byte[] ulozenyKlic = Files.readAllBytes(Paths.get("klis.DES"));
        SecretKey secretKey = new SecretKeySpec(ulozenyKlic, "DES");


        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] out = cipher.doFinal(vstup.getBytes());

        Path jmenoSoboru = Paths.get("zprava.dat");
        Files.write(jmenoSoboru, out);

    }
}
