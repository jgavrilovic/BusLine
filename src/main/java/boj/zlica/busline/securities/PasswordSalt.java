package boj.zlica.busline.securities;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**TODO
 *  Dakle ovo je koncept vrste enkripcije, pored passworda dodajem svoju sifru,
 *  appendujem na password i tako hashiram.
 *  Moguca implementacija RSA enkripcije kao zanimljivijeg koncepta ili
 *  AES ili DES
 *
 *
 * generisemo salt -> SALT;
 * hashiramo salt -> SALT.HashCode()
 * dodamo korisnicki password -> SALT.HashCode().append(user_password) (60h9passw1234)
 * hashiramo sve zajedno -> 869bkd04m
 *
 *
 * */
public class PasswordSalt {


    private static final String SALT_CODE = "SALT1234";

    private static String getSalt()
            throws NoSuchAlgorithmException, NoSuchProviderException
    {
        // Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

        // Create array for salt
        byte[] salt = new byte[16];

        // Get a random salt
        sr.nextBytes(salt);

        // return salt
        return salt.toString();
    }
}
