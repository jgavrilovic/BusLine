package boj.zlica.busline.controllers;


import boj.zlica.busline.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/users")
public class UserControllerImpl implements UserController{

    @Autowired
    UserService userService;


    @Override
    public ResponseEntity<String> registerUser(Map<String, Object> userMap) {
        String firstName = (String) userMap.get("first_name");
        String lastName = (String) userMap.get("last_name");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");

        if(userService.registerValidation(firstName,lastName,email,password).equals(HttpStatus.OK))
            userService.createUser(firstName,lastName,email,password);
        else
            return new ResponseEntity<>("Korisnik nije kreiran, doslo je do greske!",HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>("Korisnik uspesno registrovan",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> loginUser(Map<String, Object> userMap) {
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");

        HttpStatus status = userService.loginValidation(email,password);
        if(!status.equals(HttpStatus.ACCEPTED))
            return new ResponseEntity<>("Korisnik nije registrovan", status);
        return new ResponseEntity<>("Korisnik uspesno loginovan", status);
    }







}
