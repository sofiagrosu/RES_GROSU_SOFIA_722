package org.example.repository;

import org.example.model.Astronaut;
import org.example.model.MissionEvent;

import java.util.List;

public class MissionEventRepository extends AbstractJSONRepository<Integer, MissionEvent> {
    public MissionEventRepository(String fileName) {
        super(fileName, MissionEvent.class);
    }


    protected Integer getId(MissionEvent entity) {
        return entity.getId();
    }
    public List<MissionEvent> findAll() {
        return super.findAll();
    }
}
