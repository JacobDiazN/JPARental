package cl.praxis.JPARental.controller;
import cl.praxis.JPARental.model.entities.Actor;
import cl.praxis.JPARental.model.service.ActorService;
import cl.praxis.JPARental.model.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/actors")
public class ActorController {

    private final ActorService service;
    private final FilmService filmService;

    public ActorController(ActorService service, FilmService filmService) {
        this.service = service;
        this.filmService = filmService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("actors", service.findAll());
        return "actorsList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("actor", service.findOne(id));
        return "actorEdit";
    }

    @GetMapping("actor/{id}")
    public String findOneP(@PathVariable("id") int id, Model model){
        model.addAttribute("actor", service.findOne(id));
        return "actorOneList";
    }

    @PostMapping
    public Actor update(@ModelAttribute Actor actor){
        return service.update(actor);
    }

    @GetMapping("/new")
    public String toCreate(Model model){
        return "actorNew";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Actor actor) {
        service.create(actor);
        return "redirect:/actors";
    }

    @GetMapping("/{id}/del")
    public String delete(@PathVariable("id") int id){
        boolean result = service.delete(id);
        return "redirect:/actors";
    }

    @GetMapping("/{id}/films")
    public String findFilmByActor(@PathVariable("id") int id, Model model){
        Actor actor = service.findOne(id);
        model.addAttribute("actor", actor);
        model.addAttribute("films", filmService.findByActors(actor));
        return "filmsByActor";
    }

}
