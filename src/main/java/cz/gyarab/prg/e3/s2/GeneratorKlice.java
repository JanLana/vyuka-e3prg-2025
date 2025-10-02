package cz.gyarab.prg.e3.s2;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class GeneratorKlice {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        Scanner input = new Scanner(System.in);
        String str = input.next();

        KeyGenerator keyGenerator = KeyGenerator.getInstance(str);
        keyGenerator.init(56);
        SecretKey key = keyGenerator.generateKey();

        byte[] keyBytes = key.getEncoded();

        Path jmenoSoboru = Paths.get("klic." + str);
        Files.write(jmenoSoboru, keyBytes);
    }
}
