package cl.praxis.JPARental.model.service;

import cl.praxis.JPARental.model.entities.Role;
import cl.praxis.JPARental.model.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Role findOneP(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean update(Role r) {
        Role result = repository.save(r);
        return true;
    }

    @Override
    public boolean create(Role r) {
        repository.save(r);
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
