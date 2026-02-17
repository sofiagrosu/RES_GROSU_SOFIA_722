package org.example.service;

import org.example.model.Astronaut;
import org.example.repository.AstronautRepository;
public class AstronautService {
    private AstronautRepository repo ;
    public AstronautService(AstronautRepository repo){
        this.repo = repo;
    }

    public Astronaut findById(Integer id){
        return repo.findOne(id);}

}
