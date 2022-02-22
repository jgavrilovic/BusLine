package boj.zlica.busline.securities;

import org.mindrot.jbcrypt.BCrypt;



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

    public static String encryptBySalt(String pass){
        return BCrypt.hashpw(pass, BCrypt.gensalt(10));
    }

    public static Boolean decryptBySalt(String dbPass, String userPass){
        return BCrypt.checkpw(dbPass, userPass);
    }


}
