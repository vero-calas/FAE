package Taller1db.TBD.repository;

import Taller1db.TBD.Entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    Actor findActorById(Long id);
    Actor findActorByFirstNameAndAndLastName(String firstname, String lastname);
}
