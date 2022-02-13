package boj.zlica.busline.controllers;

import boj.zlica.busline.dto.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Map;

public interface UserController {

    /**Endpoint za registraciju korisnika, putanja: /api/users/register
     * @param userEntity Podatak dolazi od korisnika u JSON formatu
     * @return ResponseEntity <message,status>
     * */
    @PostMapping("/register")
    ResponseEntity<String> registerUser(@Valid @RequestBody UserEntity userEntity);

    /**Endpoint za login korisnika, putanja: /api/users/login
     * @param userMap Podatak dolazi od korisnika u JSON formatu
     * @return ResponseEntity <message,status>
     * */
    @PostMapping("/login")
    ResponseEntity<String> loginUser(@RequestBody Map<String,Object> userMap);
}
