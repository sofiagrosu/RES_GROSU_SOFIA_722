package org.example.repository;

import org.example.model.Astronaut;

public class AstronautRepository extends AbstractJSONRepository<Integer, Astronaut> {
    public AstronautRepository(String fileName) {
        super(fileName, Astronaut.class);
    }
}
