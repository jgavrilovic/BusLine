package boj.zlica.busline.repositories;

import boj.zlica.busline.dto.LineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    LineRepository nasledjuje JpaRepository, koji vec sadrzi funkcije koje su potrebne
*/
/*TODO
 *  Implementiraj metode koje pomazu u searchu
 *  */
@Repository
public interface LineRepository extends JpaRepository<LineEntity,Long> {

}
