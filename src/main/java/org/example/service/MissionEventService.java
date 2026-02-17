package org.example.service;

import org.example.model.Astronaut;
import org.example.model.MissionEvent;
import org.example.repository.MissionEventRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void calculatePoints() {
        List<MissionEvent> events = this.findAll();
        for (MissionEvent event : events) {
            int basePoints = event.getBasePoints();
            int day = event.getDay();
            int computedPoints = 0;

            switch (event.getType()) {
                case EVA:
                    computedPoints = basePoints + 2 * day;
                    break;
                case SYSTEM_FAILURE:
                    computedPoints = basePoints - 3 - day;
                    break;
                case SCIENCE:
                    computedPoints = basePoints + (day % 4);
                    break;
                case MEDICAL:
                    computedPoints = basePoints - 2 * (day % 3);
                    break;
                case COMMUNICATION:
                    computedPoints = basePoints + 5;
                    break;
            }
            event.setComputedPoints(computedPoints);
        }


    }


    public Map<Integer, Integer> calculateTotalScores() {
        Map<Integer, Integer> totalScores = new HashMap<>();
         this.calculatePoints();
        for (MissionEvent e : findAll()) {
           Integer astronaut = e.getAstronautId();
            int computedPoints = e.getBasePoints();

            totalScores.put(astronaut, totalScores.getOrDefault(astronaut, 0) + computedPoints);
        }

        return totalScores;
    }

    public void saveReport(String outputFilePath) {
        List<MissionEvent> events = this.findAll();

        repo. generateMissionReport( outputFilePath);
    }}










