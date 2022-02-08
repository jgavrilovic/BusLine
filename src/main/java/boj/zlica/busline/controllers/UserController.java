package boj.zlica.busline.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface UserController {

    /**Endpoint za registraciju korisnika, putanja: /api/users/register
     * @param userMap Podatak dolazi od korisnika u JSON formatu
     * @return ResponseEntity <message,status>
     * */
    @PostMapping("/register")
    ResponseEntity<String> registerUser(@RequestBody Map<String,Object> userMap);

    /**Endpoint za login korisnika, putanja: /api/users/login
     * @param userMap Podatak dolazi od korisnika u JSON formatu
     * @return ResponseEntity <message,status>
     * */
    @PostMapping("/login")
    ResponseEntity<String> loginUser(@RequestBody Map<String,Object> userMap);
}
