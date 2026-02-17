package org.example.service;

import org.example.model.Astronaut;
import org.example.repository.AstronautRepository;

import java.util.List;

public class AstronautService {
    private AstronautRepository repo ;
    public AstronautService(AstronautRepository repo){
        this.repo = repo;
    }

    public Astronaut findById(Integer id){
        return repo.findOne(id);}

    //find all
    public List<Astronaut> findAll(){
        return repo.findAll();
     }
}
