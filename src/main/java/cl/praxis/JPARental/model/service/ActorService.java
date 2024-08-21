package cl.praxis.JPARental.model.service;

import cl.praxis.JPARental.model.entities.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    Actor findOne(int id);
    Actor findOneP(int id);
    Actor update(Actor a);
    Actor create(Actor a);
    boolean delete(int id);
}
