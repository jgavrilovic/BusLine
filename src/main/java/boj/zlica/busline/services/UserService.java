package boj.zlica.busline.services;



import boj.zlica.busline.exceptions.UserAuthException;
import org.springframework.http.HttpStatus;


public interface UserService {

     /**
      * Izvrsava se validacija atributa dobijenih od korisnika
      * @param firstName ime korisnika
      * @param lastName prezime korisnika
      * @param email email adresa korisnika
      * @param password lozinka korisnika
      *
      * @throws UserAuthException nasledjuje RuntimeException
      * @return HttpStatus.OK u suprotnom BAD_REQUEST
      * */
     HttpStatus registerValidation(String firstName, String lastName, String email, String password) throws UserAuthException;

     /**
      * Metoda createUser pravi novog usera i cuva ga u bazi, pre cuvanja usera izvrsava se 'registerValidation'
      *  @param firstName ime korisnika
      *  @param lastName prezime korisnika
      *  @param email email adresa korisnika
      *  @param password lozinka korisnika
      *  @throws UserAuthException nasledjuje RuntimeException
      * */
     void createUser(String firstName,String lastName,String email,String password) throws UserAuthException;


     /**
      * Metoda proverava prosledjene atribute od korisnika sa podacima iz baze
      *  @param email email adresa korisnika
      *  @param password lozinka korisnika
      *
      *  @return  HttpStatus.ACCEPTED u suprotnom NOT_ACCEPTABLE
      * */
     HttpStatus loginValidation(String email, String password);

}
