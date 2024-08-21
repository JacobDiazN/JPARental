package cl.praxis.JPARental.model.service;

import cl.praxis.JPARental.model.entities.User;
import cl.praxis.JPARental.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;


    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User findOneP(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean update(User u) {
        User result = repository.save(u);
        return true;
    }

    @Override
    public boolean create(User u) {
        repository.save(u);
        return true;
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
