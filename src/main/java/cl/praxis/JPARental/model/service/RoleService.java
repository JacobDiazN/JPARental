package cl.praxis.JPARental.model.service;

import cl.praxis.JPARental.model.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findOne(int id);
    Role findOneP(int id);
    boolean update(Role r);
    boolean create(Role r);
    boolean delete(int id);
}
