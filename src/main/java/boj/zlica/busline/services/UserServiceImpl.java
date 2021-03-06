package boj.zlica.busline.services;


import boj.zlica.busline.dto.UserEntity;
import boj.zlica.busline.dto.UserRole;
import boj.zlica.busline.exceptions.UserAuthException;
import boj.zlica.busline.repositories.UserRepository;
import boj.zlica.busline.securities.PasswordSalt;
import boj.zlica.busline.securities.JWT.TokenRequest;
import boj.zlica.busline.securities.JWT.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{



    private final UserRepository userRepository;
    private final TokenService tokenService;

    /**Metoda se ne koristi jer, postoji validacije iz javax.validation() */
    @Override
    /*validacija usera*/
    public HttpStatus registerValidation(String firstName, String lastName, String email, String password) throws UserAuthException {
        /*

        //Validacije imena
        Pattern patternName = Pattern.compile("^([A-Z])([a-z]+)$");
        if(!patternName.matcher(firstName).matches()) throw new UserAuthException("Los format imena");


        //Validacije prezimena
        Pattern patternLast = Pattern.compile("^([A-Z])([a-z]+)$");
        if(!patternLast.matcher(lastName).matches()) throw new UserAuthException("Los format prezimena");

        //Validacije emaila
        Pattern patternEmail = Pattern.compile("^(.+)@([a-z]+).(.+)$");
        if(email==null) throw new UserAuthException("Email je obavezno polje");
        email=email.toLowerCase();

        if(!patternEmail.matcher(email).matches()) throw new UserAuthException("Los format email adrese");

        if(userRepository.findByEmail(email)!=null) throw new UserAuthException("Email adresa vec postoji");


        //Validacije passworda
        Pattern patternPassword = Pattern.compile("^(?=.*[A-Z][a-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        if(!patternPassword.matcher(password).matches()) throw new UserAuthException("Los format passworda ");

        */
        return HttpStatus.OK;
    }

    @Override
    public void createUser(String firstName,String lastName,Integer age, String email,String password) throws UserAuthException {
        /*Pravi se novi userEntity od prosledjenih podataka kako bi se sacuvao u bazi*/
        String uuid = UUID.randomUUID().toString();
        UserEntity entity = new UserEntity();
        entity.setUid(uuid);
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setAge(age);
        entity.setEmail(email);
        entity.setPassword(password);
        entity.setRole(UserRole.GUEST);

        userRepository.save(entity);
    }

    @Override
    public TokenResponse loginValidation(TokenRequest tokenRequest)  {
        UserEntity userEntity = userRepository.findByEmail(tokenRequest.getEmail())
                .filter(user -> PasswordSalt.decryptBySalt(tokenRequest.getPassword(),user.getPassword()))
                .orElseThrow(() -> new UserAuthException("Invalid email or password"));
        return tokenService.generateTokenFor(userEntity);

    }
}
