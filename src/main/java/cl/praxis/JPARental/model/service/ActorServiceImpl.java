package cl.praxis.JPARental.model.service;
import cl.praxis.JPARental.model.entities.Actor;
import cl.praxis.JPARental.model.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository repository;

    public ActorServiceImpl(ActorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Actor> findAll() {
        return repository.findAll();
    }

    @Override
    public Actor findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Actor findOneP(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Actor update(Actor a) {
        return repository.save(a);
    }

    @Override
    public Actor create(Actor a) {
        return repository.save(a);
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
