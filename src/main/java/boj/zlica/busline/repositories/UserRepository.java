package boj.zlica.busline.repositories;


import boj.zlica.Avio.kompanija.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    @UserRepository nasledjuje JpaRepository, koji vec sadrzi funkcije koje su potrebne

*/
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    UserEntity findByEmailAndPassword(String email,String password);
    UserEntity findByEmail(String email);
}
