package cl.praxis.JPARental.model.service;

import cl.praxis.JPARental.model.entities.Actor;
import cl.praxis.JPARental.model.entities.Category;
import cl.praxis.JPARental.model.entities.Film;

import java.util.List;

public interface FilmService {
    List<Film> findAll();
    Film findOne(int id);
    List<Film> findByActors(Actor actor);
    List<Film> findByCategories(Category category);
    Film findOneP(int id);
    Film update(Film f);
    Film create(Film f);
    boolean delete(int id);
}
