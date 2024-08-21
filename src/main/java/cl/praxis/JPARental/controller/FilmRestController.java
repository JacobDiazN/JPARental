package cl.praxis.JPARental.controller;

import cl.praxis.JPARental.model.entities.Film;
import cl.praxis.JPARental.model.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmRestController {

    private final FilmService service;

    public FilmRestController(FilmService service) {
        this.service = service;
    }

    private HttpStatus status = HttpStatus.OK;

    @GetMapping
    public ResponseEntity<List<Film>> findAll(){
        List<Film> films = service.findAll();
        if(films == null || films.isEmpty()){
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(films, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> findOne(@PathVariable("id") int id){
        Film film = service.findOne(id);
        if(film == null){
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(film, status);
    }

    @PostMapping
    public ResponseEntity<Film> create(@RequestBody Film f){
        Film film = service.create(f);
        if(film == null){
            status = HttpStatus.CONFLICT;
        }else{
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(film, status);
    }

    @PutMapping
    public ResponseEntity<Film> update(@RequestBody Film f){
        Film film = service.update(f);
        if(film == null){
            status = HttpStatus.CONFLICT;
        }else{
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(film, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = service.delete(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }

}
