package cl.praxis.JPARental.model.service;

import cl.praxis.JPARental.model.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findOne(int id);
    boolean update(Category c);
    boolean create(Category c);
    boolean delete(int id);
}
