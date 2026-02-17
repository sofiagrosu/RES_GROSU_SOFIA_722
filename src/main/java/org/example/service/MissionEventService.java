package org.example.service;

import org.example.model.MissionEvent;
import org.example.repository.MissionEventRepository;

import java.util.List;

public class MissionEventService {

    private MissionEventRepository repo ;
    public MissionEventService(MissionEventRepository repo){
        this.repo = repo;
    }

    public MissionEvent findById(Integer id) {
        return repo.findOne(id);
    }

    public List<MissionEvent> findAll() {
        return repo.findAll();
    }
}
