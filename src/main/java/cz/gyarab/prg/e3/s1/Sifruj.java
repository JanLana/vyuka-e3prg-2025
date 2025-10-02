package cz.gyarab.prg.e3.s1;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Sifruj {
    public static void main(String[] args) throws IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException {
        Path fileName = Paths.get("klic.dat");
        byte[] keyBytes = Files.readAllBytes(fileName);
        SecretKey key =  new SecretKeySpec(keyBytes, "DES");

        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        byte[] messageInBytes = msg.getBytes();

        System.out.println(messageInBytes.length);

        String a = new String(messageInBytes);
        System.out.println(a);

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] out = cipher.doFinal(messageInBytes);

        Files.write(Paths.get("zprava.dat"), out);

    }
}
