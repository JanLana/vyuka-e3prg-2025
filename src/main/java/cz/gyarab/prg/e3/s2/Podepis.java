package cz.gyarab.prg.e3.s2;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;


//Verejny klic: MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKEg57FXfTazh5aNnEx02t5mA+8024EtkppN705qs046jJEGoBdYxrU2QkKwbC0RUZ8WCtM175nfWkI1kRG4SVMCAwEAAQ==
//
//Tajny klic: MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAoSDnsVd9NrOHlo2cTHTa3mYD7zTbgS2Smk3vTmqzTjqMkQagF1jGtTZCQrBsLRFRnxYK0zXvmd9aQjWREbhJUwIDAQABAkAw6PGbqfCGycFHKI5AwRns92+LTXKyCBjfwPd6yLXL8UtvpOkXkp9kzU7/Y9ryIyOKvRRtIYmDDpdZqMsnzK65AiEA097B0onSyxynNgTsyYz9CSH2sVI/NIqs1+fPSQQ1HLsCIQDCsIbswLYrXw2cwjjJNjCCCdNJv/6KQRf7XzeJ9tPISQIhAJkjp6EQMabR/SKUiLpeB/9z5yXgNwM5QRmF2lQCkIlFAiBL2bSndqlCmoTWJwEyu08IysUrvYZw3M14HO+pa6W1KQIgMxivu9HmHbwx8XiqrPxVbf7jF83dCI86ziisa5bEkLA=

public class Podepis {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        String klic = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAoSDnsVd9NrOHlo2cTHTa3mYD7zTbgS2Smk3vTmqzTjqMkQagF1jGtTZCQrBsLRFRnxYK0zXvmd9aQjWREbhJUwIDAQABAkAw6PGbqfCGycFHKI5AwRns92+LTXKyCBjfwPd6yLXL8UtvpOkXkp9kzU7/Y9ryIyOKvRRtIYmDDpdZqMsnzK65AiEA097B0onSyxynNgTsyYz9CSH2sVI/NIqs1+fPSQQ1HLsCIQDCsIbswLYrXw2cwjjJNjCCCdNJv/6KQRf7XzeJ9tPISQIhAJkjp6EQMabR/SKUiLpeB/9z5yXgNwM5QRmF2lQCkIlFAiBL2bSndqlCmoTWJwEyu08IysUrvYZw3M14HO+pa6W1KQIgMxivu9HmHbwx8XiqrPxVbf7jF83dCI86ziisa5bEkLA=";
        byte[] bytes = Base64.getDecoder().decode(klic);
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bytes));

        Signature signGenerator = Signature.getInstance("SHA1withRSA");
        signGenerator.initSign(privateKey);

        String msg = "Toto je sek na 10,- Kc";
        signGenerator.update(msg.getBytes());

        byte[] sign = signGenerator.sign();
        String signBase64 = Base64.getEncoder().encodeToString(sign);

        System.out.println(msg);
        System.out.println(signBase64);



    }

}
