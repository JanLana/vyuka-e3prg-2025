package cz.gyarab.prg.e3.s2;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.sql.SQLOutput;
import java.util.Base64;
import java.util.Scanner;

public class GeneratorKlice {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {


        //KeyGenerator keyGenerator = KeyGenerator.getInstance(str);
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("EC");
        keyGenerator.initialize(256);

        //SecretKey key = keyGenerator.generateKey();
        KeyPair keyPair = keyGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();


        String klicStr = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        System.out.println("Verejny klic: " + klicStr);

        klicStr = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        System.out.println("Privatni klic: " + klicStr);



        //Path jmenoSoboru = Paths.get("klic." + str);
        //Files.write(jmenoSoboru, keyBytes);
    }
}
