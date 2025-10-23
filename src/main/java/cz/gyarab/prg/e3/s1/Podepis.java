package cz.gyarab.prg.e3.s1;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

//Verejny klic: MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANOisSscUFPEJ6CFUt007owgWoOwVjf3IpJXkZ+TphUMX14m0kVEX8FiuN/jKbOfmBWeSUhQn9jVr69cHB6yp5ECAwEAAQ==
//
//Tajny klic: MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEA06KxKxxQU8QnoIVS3TTujCBag7BWN/cikleRn5OmFQxfXibSRURfwWK43+Mps5+YFZ5JSFCf2NWvr1wcHrKnkQIDAQABAkAGnyAA881VmZ0Nyi4aCrZt/vMmDKXd8WcNAh1ly0ZWgTKGNeO9n/gnfqyRf317thcdp8mwlT1WI+emWiBi91wDAiEA4dJ0IPj3PRPXsU2MMT6GihmwS9COMquIOT1NgseNZgsCIQDv6ueyS4anxRkpIlgYtJLdczvKG/FhFO1bMlmqPuT2UwIhAIGm7eu8ZV7Y1J7EcjgXuPDzHMf6fpnS6AxNCQKMBb/PAiBljOydj1Jj2Q2ZV6wqaORxT8FS/xjgmtcM7vb9FLodeQIhANFDvyNziUVo4hdCodBwqy3opCJlQTkmuu32ewrHsE3e

public class Podepis {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        String klic = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEA06KxKxxQU8QnoIVS3TTujCBag7BWN/cikleRn5OmFQxfXibSRURfwWK43+Mps5+YFZ5JSFCf2NWvr1wcHrKnkQIDAQABAkAGnyAA881VmZ0Nyi4aCrZt/vMmDKXd8WcNAh1ly0ZWgTKGNeO9n/gnfqyRf317thcdp8mwlT1WI+emWiBi91wDAiEA4dJ0IPj3PRPXsU2MMT6GihmwS9COMquIOT1NgseNZgsCIQDv6ueyS4anxRkpIlgYtJLdczvKG/FhFO1bMlmqPuT2UwIhAIGm7eu8ZV7Y1J7EcjgXuPDzHMf6fpnS6AxNCQKMBb/PAiBljOydj1Jj2Q2ZV6wqaORxT8FS/xjgmtcM7vb9FLodeQIhANFDvyNziUVo4hdCodBwqy3opCJlQTkmuu32ewrHsE3e";
        byte[] bytes = Base64.getDecoder().decode(klic);
        PrivateKey privateKey =
                KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bytes));

        Signature signGenerator = Signature.getInstance("SHA256withRSA");
        signGenerator.initSign(privateKey);

        String msg = "Dneska neprsi\na zitra nebude\nLalalala";

        signGenerator.update(msg.getBytes());

        byte[] sign = signGenerator.sign();
        String signBase64 = Base64.getEncoder().encodeToString(sign);

        System.out.println(msg);
        System.out.println(signBase64);




    }
}
