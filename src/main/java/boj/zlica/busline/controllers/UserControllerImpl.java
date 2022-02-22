package boj.zlica.busline.controllers;


import boj.zlica.busline.dto.UserEntity;
import boj.zlica.busline.securities.PasswordSalt;
import boj.zlica.busline.securities.JWT.TokenRequest;
import boj.zlica.busline.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserControllerImpl implements UserController{

    @Autowired
    UserService userService;


    @Override
    public ResponseEntity<String> registerUser(UserEntity userEntity) {
        String firstName = userEntity.getFirstName();
        String lastName =  userEntity.getLastName();
        int age = userEntity.getAge();
        String email =  userEntity.getEmail();
        String password =  userEntity.getPassword();
        userService.createUser(firstName,lastName,age,email, PasswordSalt.encryptBySalt(password));
        return new ResponseEntity<>("Korisnik uspesno registrovan",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> loginUser(TokenRequest tokenRequest) {
        return new ResponseEntity<>(userService.loginValidation(tokenRequest), HttpStatus.OK);
    }







}
