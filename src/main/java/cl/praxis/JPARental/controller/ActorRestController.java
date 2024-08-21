package cl.praxis.JPARental.controller;

import cl.praxis.JPARental.model.entities.Actor;
import cl.praxis.JPARental.model.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorRestController {

    private final ActorService service;

    public ActorRestController(ActorService service) {
        this.service = service;
    }

    private HttpStatus status = HttpStatus.OK;

    @GetMapping
    public ResponseEntity<List<Actor>> findAll(){
        List<Actor> actors = service.findAll();
        if(actors == null || actors.isEmpty()){
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(actors, status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findOne(@PathVariable("id") int id){
        Actor actor = service.findOne(id);
        if(actor == null){
            status = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(actor, status);
    }

    @PostMapping
    public ResponseEntity<Actor> create(@RequestBody Actor a){
        Actor actor = service.create(a);
        if(actor == null){
            status = HttpStatus.CONFLICT;
        }else{
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(actor, status);
    }

    @PutMapping
    public ResponseEntity<Actor> update(@RequestBody Actor a){
        Actor actor = service.update(a);
        if(actor == null){
            status = HttpStatus.CONFLICT;
        }else{
            status = HttpStatus.OK;
        }
        return new ResponseEntity<>(actor, status);
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
