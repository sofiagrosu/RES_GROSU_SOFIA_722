package org.example.repository;

import org.example.model.MissionEvent;

public class MissionEventRepository extends AbstractJSONRepository<Integer, MissionEvent> {
    public MissionEventRepository(String fileName) {
        super(fileName, MissionEvent.class);
    }


    protected Integer getId(MissionEvent entity) {
        return entity.getId();
    }
}
