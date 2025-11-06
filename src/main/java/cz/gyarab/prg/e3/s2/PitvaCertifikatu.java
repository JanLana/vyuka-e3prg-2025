package cz.gyarab.prg.e3.s2;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public class PitvaCertifikatu {
    public static void main(String[] args) throws IOException {
        URL destinationURL = new URL("https://www.google.com");
        HttpsURLConnection conn = (HttpsURLConnection) destinationURL.openConnection();
        conn.connect();
        Certificate[] certs = conn.getServerCertificates();

        System.out.println(certs.length);
        for (Certificate cert : certs) {
            X509Certificate certificate = (X509Certificate)cert;
            System.out.println("============================================");
            System.out.println(cert.toString());
        }
    }
}
