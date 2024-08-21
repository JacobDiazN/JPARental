package cl.praxis.JPARental.controller;

import cl.praxis.JPARental.model.entities.Category;
import cl.praxis.JPARental.model.service.CategoryService;
import cl.praxis.JPARental.model.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;
    private final FilmService filmService;

    public CategoryController(CategoryService service, FilmService filmService) {
        this.service = service;
        this.filmService = filmService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("categories", service.findAll());
        return "categoriesList";
    }

    @GetMapping("/{id}/films")
    public String findFilmByActor(@PathVariable("id") int id, Model model){
        Category category = service.findOne(id);
        model.addAttribute("category", category);
        model.addAttribute("films", filmService.findByCategories(category));
        return "filmsByCategory";
    }

}
