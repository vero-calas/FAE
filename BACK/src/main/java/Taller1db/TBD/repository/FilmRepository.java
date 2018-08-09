package Taller1db.TBD.repository;

import Taller1db.TBD.Entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmRepository extends JpaRepository<Film, Long>{

    Film findFilmsById(Long id);
}
