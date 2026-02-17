package org.example.service;

import org.example.model.MissionEvent;
import org.example.repository.MissionEventRepository;
public class MissionEventService {

    private MissionEventRepository repo ;
    public MissionEventService(MissionEventRepository repo){
        this.repo = repo;
    }

    public MissionEvent findById(Integer id) {
        return repo.findOne(id);
    }
}
