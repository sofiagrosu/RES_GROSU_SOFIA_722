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
    //Punktberechnung
    //Implementieren Sie die Berechnung der computedPoints für
    //jedes MissionEvent gemäß den folgenden Regeln:
    //● EVA → computedPoints = basePoints + 2 * day
    //● SYSTEM_FAILURE → computedPoints = basePoints - 3 - day
    //● SCIENCE → computedPoints = basePoints + (day % 4)
    //● MEDICAL → computedPoints = basePoints - 2 * (day % 3)
    //● COMMUNICATION → computedPoints = basePoints + 5

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
}
