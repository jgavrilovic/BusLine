package boj.zlica.busline.repositories;


import boj.zlica.busline.dto.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
    UserRepository nasledjuje JpaRepository, koji vec sadrzi funkcije koje su potrebne
*/
/*TODO
 *  Implementiraj metode koje pomazu u searchu
 *  */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmailAndPassword(String email, String password);
    Optional<UserEntity> findByEmail(String email);
}
