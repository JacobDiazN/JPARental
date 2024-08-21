package cl.praxis.JPARental.model.repository;

import cl.praxis.JPARental.model.entities.Actor;
import cl.praxis.JPARental.model.entities.Category;
import cl.praxis.JPARental.model.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FilmRepository extends JpaRepository<Film, Integer> {
    List<Film> findByActors(Actor actor);
    List<Film> findByCategories(Category category);
}
