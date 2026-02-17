package org.example.repository;

import org.example.model.Astronaut;

import java.util.List;

public class AstronautRepository extends AbstractJSONRepository<Integer, Astronaut> {
    public AstronautRepository(String fileName) {
        super(fileName, Astronaut.class);
    }
    //findAll - returneaza toate entitatile din repository

    public List<Astronaut> findAll() {
        return super.findAll();
    }
}
