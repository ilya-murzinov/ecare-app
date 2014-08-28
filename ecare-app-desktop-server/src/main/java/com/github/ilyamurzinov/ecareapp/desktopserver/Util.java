package com.github.ilyamurzinov.ecareapp.desktopserver;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ilya-murzinov
 */
public class Util {
    private Util() {}

    public static String getMd5Hash(String input) {
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(input.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            String hashtext = bigInt.toString(16);

            while(hashtext.length() < 32 ){
                hashtext = "0"+hashtext;
            }

            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
