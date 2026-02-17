package org.example;
import org.example.repository.SupplyRepository;
import org.example.repository. AstronautRepository;
import org.example.repository. MissionEventRepository;
import org.example.service.*;
import org.example.model.*;
import org.example.controller.Controller;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //create repositories
        var supplyRepo = new SupplyRepository("supplies.json");
        var astronautRepo = new AstronautRepository("astronauts.json");
        var missionEventRepo = new MissionEventRepository("events.json");

        //create services
        var supplyService = new SupplyService(supplyRepo);
        var astronautService = new AstronautService(astronautRepo);
        var missionEventService = new MissionEventService(missionEventRepo);

        //create controller
        var controller = new Controller( astronautService, missionEventService,supplyService);

        controller.run();
        }

}
