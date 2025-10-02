package cz.gyarab.prg.e3.s1;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class GeneratorKlice {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        KeyGenerator keyGenerator = KeyGenerator.getInstance(str);
        keyGenerator.init(56);
        SecretKey key = keyGenerator.generateKey();

        byte[] keyBytes = key.getEncoded();

        System.out.println(Arrays.toString(keyBytes));

        Files.write(Paths.get("klic.dat"), keyBytes);
    }
}
