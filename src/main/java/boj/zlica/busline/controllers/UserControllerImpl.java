package boj.zlica.busline.controllers;


import boj.zlica.busline.entities.UserEntity;
import boj.zlica.busline.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;


@RestController
@RequestMapping("/api/users")
public class UserControllerImpl implements UserController{

    @Autowired
    UserService userService;


    @Override
    public ResponseEntity<String> registerUser(UserEntity userEntity) {
        String firstName = userEntity.getFirstName();
        String lastName =  userEntity.getLastName();
        String email =  userEntity.getEmail();
        String password =  userEntity.getPassword();
        userService.createUser(firstName,lastName,email,password);
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
