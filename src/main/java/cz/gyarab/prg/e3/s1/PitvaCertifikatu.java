package cz.gyarab.prg.e3.s1;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;

public class PitvaCertifikatu {
    public static void main(String[] args) throws IOException {
        URL destinationURL = new URL("https://www.google.com");
        HttpsURLConnection conn = (HttpsURLConnection) destinationURL.openConnection();
        conn.connect();
        Certificate[] certs = conn.getServerCertificates();

        for (Certificate cert : certs) {
            System.out.println("=============================================");
            System.out.println(cert);
        }
        System.out.println("pocet:" + certs.length);
    }
}
