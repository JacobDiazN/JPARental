package cl.praxis.JPARental.model.service;

import cl.praxis.JPARental.model.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findOne(int id);
    User findOneP(int id);
    boolean update(User u);
    boolean create(User u);
    boolean delete(int id);

}
