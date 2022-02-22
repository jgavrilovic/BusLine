package boj.zlica.busline.controllers;

import boj.zlica.busline.dto.UserEntity;
import boj.zlica.busline.securities.JWT.TokenRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


public interface UserController {

    /**Endpoint za registraciju korisnika, putanja: /api/users/register
     * @param userEntity Podatak dolazi od korisnika u JSON formatu
     * @return ResponseEntity <message,status>
     * */
    @PostMapping("/register")
    ResponseEntity<String> registerUser(@Valid @RequestBody UserEntity userEntity);

    /**Endpoint za login korisnika, putanja: /api/users/login
     * @param tokenRequest tokenRequest Podatak dolazi od korisnika u JSON formatu, atributi: email, password
     * @return TokenRespone <String> vraca token tipa string
     * */
    /*Dakle user salje tokenRequest a vraca mu se zapravo token koji mu omogucava neke privilegije*/
    @PostMapping("/login")
    ResponseEntity<?> loginUser(@RequestBody TokenRequest tokenRequest);
}
