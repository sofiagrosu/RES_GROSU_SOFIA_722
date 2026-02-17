package org.example.service;
import org.example.model.MissionEvent;
import org.example.repository.SupplyRepository;
import org.example.model.Supply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplyService {
    private SupplyRepository repo ;
    public SupplyService(SupplyRepository repo) {
        this.repo = repo;
    }


    public Supply findById(Integer id) {
        return repo.findOne(id);
    }
public List<Supply> findAll(){
        return repo.findAll();
    }


    public Map<Integer, Integer> calculateTotalScores() {
        Map<Integer, Integer> totalScores = new HashMap<>();

        for (Supply s : findAll()) {
            Integer astronaut =s .getAstronautId();
            int computedPoints = s.getValue();

            totalScores.put(astronaut, totalScores.getOrDefault(astronaut, 0) + computedPoints);
        }

        return totalScores;
    }
}
