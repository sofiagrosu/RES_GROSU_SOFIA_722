package org.example.controller;
import org.example.model.Astronaut;
import org.example.service.AstronautService;
import org.example.service.MissionEventService;
import org.example.service.SupplyService;

import java.util.Map;
import java.util.Scanner;

public class Controller {
    private AstronautService astronautService;
    private MissionEventService missionEventService;
    private SupplyService supplyService;
    private Scanner scanner;

    public Controller(AstronautService astronautService, MissionEventService missionEventService, SupplyService supplyService) {
        this.astronautService = astronautService;
        this.missionEventService = missionEventService;
        this.supplyService = supplyService;
        this.scanner = new Scanner(System.in);

    }
    public void run() {
        int option = -1;
        while (option != 0) {
            printMenu();
            System.out.print("Chose option: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                handleOption(option);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Show all");
        System.out.println("2. Filter active astronauts by spacecraft");
        System.out.println("3. Sort by Experience");
        System.out.println("4. Save Astronauts to file");
        System.out.println("5. Show first 5 event points");
        System.out.println("6. Show ranking");
        System.out.println("7. Save report");
        System.out.println("0. Exit");
    }

    private void handleOption(int option) {
        switch (option) {
            case 1 -> showAll();
            case 2 -> filterAstronautBySpacecraft();
            case 3 -> sortByExperience();
            case 4 -> saveAstronautsToFile();
            case 5 -> showFirst5Events();
            case 6 -> showRanking();
            case 7 -> saveReport();
            case 0 -> System.out.println("Exit");
            default -> System.out.println("Invalid Option");
        }
    }

    private void saveReport() {
        String outputFilePath = "mission_report.txt";
       missionEventService.saveReport(outputFilePath);
    }

    private void showRanking() {

       Map<Integer,Integer> resutl = missionEventService.calculateTotalScores();
       Map <Integer,Integer>resultSuplies = supplyService.calculateTotalScores();
         for(Map.Entry<Integer,Integer> entry : resultSuplies.entrySet()){
              Integer astronautId = entry.getKey();
              Integer supplyPoints = entry.getValue();
              resutl.put(astronautId, resutl.getOrDefault(astronautId, 0) + supplyPoints);
         }
       Map<Astronaut,Integer> resultWithAstronaut = resutl.entrySet().stream()
               .collect(java.util.stream.Collectors.toMap(
                       e -> astronautService.findById(e.getKey()),
                       Map.Entry::getValue
               ));


        resultWithAstronaut.entrySet().stream()
                .sorted((e1,e2)-> {
                    int scoreComparison = Integer.compare(e2.getValue(), e1.getValue());
                    if(scoreComparison != 0){
                        return scoreComparison;
                    }else{
                        return e1.getKey().getName().compareToIgnoreCase(e2.getKey().getName());
                    }
                })
                .limit(5)
                .forEach(e -> System.out.println(e.toString()));


        var leadingSpacecraft = resultWithAstronaut.entrySet().stream()
                .max((e1,e2)-> Integer.compare(e1.getValue(), e2.getValue()))
                .map(e -> e.getKey().getSpacecraft())
                .orElse("No leading spacecraft found");

        System.out.println("Leading spacecraft: " + leadingSpacecraft);

    }

    private void showFirst5Events() {

            missionEventService.calculatePoints();
            missionEventService.findAll().stream().limit(5).forEach(e -> System.out.println(e.toString()));
    }

    private void saveAstronautsToFile() {
        String outputFilePath = "astronauts_sorted.txt";
        astronautService.saveAstronauts(outputFilePath);
    }

    private void sortByExperience() {
        astronautService.sortAstronautsByExperience().forEach(e -> System.out.println(e.toString()));
    }

    private void filterAstronautBySpacecraft() {

        System.out.print("Enter spacecraft: ");
        String spacecraft = scanner.nextLine();
        astronautService.filterBySpacecraft(spacecraft).forEach(e -> System.out.println(e.toString()));
    }

    private void showAll() {

        System.out.println("Anzahl der Astronauten: " + astronautService.findAll().size());
        System.out.println("Anzahl der Ereignisse: " + missionEventService.findAll().size());
        System.out.println("Anzahl der Supplies: " + supplyService.findAll().size());
        astronautService.findAll().forEach(e -> System.out.println(e.toString()));
    }

}
