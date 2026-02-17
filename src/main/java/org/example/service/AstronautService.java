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

     public List<Astronaut> sortAstronautsByExperience() {

            return repo.findAll().stream()
                    .sorted((a1, a2) -> {
                        int experienceComparison = Integer.compare(a2.getExperienceLevel(), a1.getExperienceLevel());
                        if (experienceComparison != 0) {
                            return experienceComparison;
                        } else {
                            return a1.getName().compareToIgnoreCase(a2.getName()); }
                    })
                    .toList();
     }
}
