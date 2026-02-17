package org.example.repository;

import org.example.model.Astronaut;
import org.example.model.MissionEvent;

import java.util.List;

public class MissionEventRepository extends AbstractJSONRepository<Integer, MissionEvent> {
    public MissionEventRepository(String fileName) {
        super(fileName, MissionEvent.class);
    }


    protected Integer getId(MissionEvent entity) {
        return entity.getId();
    }
    public List<MissionEvent> findAll() {
        return super.findAll();
    }
//    Abschlussbericht
//Erstellen Sie die Datei mission_report.txt, welche die
//Anzahl der MissionEvents pro MissionEventType (basierend
//auf events.json) enthält.
//Sortierung:
//● zuerst nach Anzahl absteigend
//● bei Gleichstand nach Name aufsteigend
//Ausgabeformat:
//<TYPE> -> <ANZAHL>

    public void generateMissionReport(String outputFilePath) {
        java.util.Map<String, Long> eventCount = this.findAll().stream()
                .collect(java.util.stream.Collectors.groupingBy(event -> event.getType().toString(), java.util.stream.Collectors.counting()));

       java.util.List<java.util.Map.Entry<String, Long>> sortedEventCount = eventCount.entrySet().stream()
                .sorted((e1, e2) -> {
                    int compare = Long.compare(e2.getValue(), e1.getValue());
                    if (compare == 0) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return compare;
                })
                .toList();

        // Schreibe die Ergebnisse in die Datei
//        //Ausgabeformat:
//<TYPE> -> <ANZAHL>
        try (java.io.PrintWriter writer = new java.io.PrintWriter(outputFilePath)) {
            sortedEventCount.forEach(entry -> writer.println(entry.getKey() + " -> " + entry.getValue()));
            System.out.println("The mission report has been generated: " + outputFilePath);
        } catch (java.io.IOException e) {
            System.err.println("Error " + e.getMessage());
        }
    }
}
