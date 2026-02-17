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


    public List<Astronaut> findAll(){
        return repo.findAll();
     }

     public List<Astronaut> filterBySpacecraft(String spacecraft) {

            return repo.findAll().stream()
                    .filter(astronaut -> astronaut.getSpacecraft().equalsIgnoreCase(spacecraft) && astronaut.getStatus().toString().equalsIgnoreCase("ACTIVE"))
                    .toList();
     }

}
