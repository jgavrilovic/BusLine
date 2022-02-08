package boj.zlica.busline.repositories;

import boj.zlica.busline.entities.LineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<LineEntity,Long> {

}
