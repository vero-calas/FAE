package Taller1db.TBD.rest;

import Taller1db.TBD.Entities.Actor;
import Taller1db.TBD.Entities.Film;
import Taller1db.TBD.repository.ActorRepository;
import Taller1db.TBD.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/films")
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ActorRepository actorRepository;

    // retorna todas las peliculas de la base de datos, se llama con la ruta /films
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Film> getAllFilm() {
        return filmRepository.findAll();
    }


    // retorna todos los actores que participan en una determinada pelicula, se llama con la ruta /films/idFilms/actors
    @GetMapping("{id}/actors")
    @ResponseBody
    public Set<Actor> actorTheMovie (@PathVariable("id") Long id){
        return  filmRepository.findFilmsById(id).getActors();

    }

    // permite agregar un nuevo actor a una determinada pelicula, se llama con la ruta /films/idFilm/actors/idActor
    @PostMapping("{idFilm}/actors/{idActor}")
    @ResponseBody
    public HttpStatus matchFilm(@PathVariable("idFilm") Long idFilm, @PathVariable("idActor") Long  idActor){

        Actor actor = actorRepository.findActorById(idActor);
        Film film = filmRepository.findFilmsById(idFilm);
        if(actor != null && film != null){
            film.getActors().add(actor);
            actor.getFilms().add(film);
            filmRepository.save(film);
            return HttpStatus.OK;
        }
        else
            return HttpStatus.NOT_ACCEPTABLE;

    }

    // Permite registrar un nuevo films en la base de datos, se llama con la ruta /films/create
    @PostMapping("/create")
    @ResponseBody
    public Film create(@RequestBody Film resource)  {

        return filmRepository.save(resource);
    }


}
