package cz.gyarab.prg.e3.s2;

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
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String verejnyKlicVBase64 = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJ0aq4p+aR2+t/RLy1ZoE/pPswffo2JsbvtDFhE5RnH/TJXCZgSHMxhB39bIMOn2ElXeEHPcyV9m4LR/Mu35+8MCAwEAAQ==";
        byte[] verejnyKlicVBajtech = Base64.getDecoder().decode(verejnyKlicVBase64);
        PublicKey verejnyKlic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(verejnyKlicVBajtech));


        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, verejnyKlic);

        String zprava = "toto je strasne tajna zprava ze je dneska hezky";
        byte[] zpravaVBytes = zprava.getBytes();


        byte[] zasifrovanaZpravaVBajtech = cipher.doFinal(zpravaVBytes);
        //String zasifrovanaZpravaVBase64 = Base64.getDecoder().encode(zasifrovanaZpravaVBajtech);
        String zasifrovanaZpravaVBase64 = Base64.getEncoder().encodeToString(zasifrovanaZpravaVBajtech);


        System.out.println(zasifrovanaZpravaVBase64);
    }
}
