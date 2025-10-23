package cz.gyarab.prg.e3.s1;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SchrankaDuvery {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String klic = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJ0aq4p+aR2+t/RLy1ZoE/pPswffo2JsbvtDFhE5RnH/TJXCZgSHMxhB39bIMOn2ElXeEHPcyV9m4LR/Mu35+8MCAwEAAQ==";
        byte[] bytes = Base64.getDecoder().decode(klic);
        PublicKey publicKey =
                KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bytes));

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] encryptedBytes = cipher.doFinal("Ahoj trido 3.E".getBytes());
        String str = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println(str);


    }
}
