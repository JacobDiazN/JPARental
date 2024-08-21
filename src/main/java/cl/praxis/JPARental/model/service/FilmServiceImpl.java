package cl.praxis.JPARental.model.service;

import cl.praxis.JPARental.model.entities.Actor;
import cl.praxis.JPARental.model.entities.Category;
import cl.praxis.JPARental.model.entities.Film;
import cl.praxis.JPARental.model.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository repository;

    public FilmServiceImpl(FilmRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Film> findAll() {
        return repository.findAll();
    }

    @Override
    public Film findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Film> findByActors(Actor actor) {
        return repository.findByActors(actor);
    }

    @Override
    public List<Film> findByCategories(Category category) {
        return repository.findByCategories(category);
    }

    @Override
    public Film findOneP(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Film update(Film f) {
        return repository.save(f);
    }

    @Override
    public Film create(Film f) {
        return repository.save(f);
    }

    @Override
    public boolean delete(int id) {
        boolean exist = repository.existsById(id);
        if(exist){
            repository.deleteById(id);
        }
        return exist;
    }
}
