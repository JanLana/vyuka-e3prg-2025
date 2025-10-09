package cz.gyarab.prg.e3.s1;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

public class GeneratorKlice {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        try {
            var keyGen = KeyPairGenerator.getInstance("EC");
            keyGen.initialize(256);

            //Key secretKey = keyGen.generateKey();
            KeyPair keyPair = keyGen.generateKeyPair();

            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();


            String str = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            System.out.println("Verejny klic: " + str);
            System.out.println();


            str = Base64.getEncoder().encodeToString(privateKey.getEncoded());
            System.out.println("Tajny klic: " + str);

        } catch (Exception e) {
            System.err.println("Došlo k chybě při generování klíče: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
