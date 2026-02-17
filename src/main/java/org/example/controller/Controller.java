package org.example.controller;
import org.example.service.AstronautService;
import org.example.service.MissionEventService;
import org.example.service.SupplyService;

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
            System.out.print("Alege opțiunea: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                handleOption(option);
            } catch (NumberFormatException e) {
                System.out.println("Te rog să introduci un număr valid.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Show all");
        System.out.println("2. Filter active astronauts by spacecraft");
        System.out.println("3. Sort by Experience");
        System.out.println("4. Save Vehicles to file");
        System.out.println("5. Show first 5 risk scores");
        System.out.println("6. Show risks");
        System.out.println("7. Save report");
        System.out.println("0. Exit");
    }

    private void handleOption(int option) {
        switch (option) {
            case 1 -> showAll();
            case 2 -> filterAstronautBySpacecraft();
            case 3 -> sortByExperience();
//            case 4 -> saveVehiclesToFile();
//            case 5 -> showFirst5Events();
//            case 6 -> showRisks();
//            case 7 -> saveReport();
            case 0 -> System.out.println("Exit");
            default -> System.out.println("Invalid Option");
        }
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
