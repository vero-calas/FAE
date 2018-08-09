package Taller1db.TBD.Entities;


import java.io.Serializable;
import javax.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Film")
public class Film implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "films_id")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @ManyToMany(mappedBy = "films")
    @JsonIgnore
    private Set<Actor> actors = new HashSet<Actor>();


    public Film() {
    }


    public void setId(Long id) {

        this.id = id;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Set<Actor> getActors() {
        return actors;
    }
}