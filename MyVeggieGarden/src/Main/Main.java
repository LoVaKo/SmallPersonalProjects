package Main;

import Garden.*;
import Player.*;
import Seeds.*;
import Time.*;
import Vegetables.Carrot;

public class Main {
    public static void main(String[] args) {
        // Setting up a new game with 1 gardenbed and carrotseeds in inventory.
        Game game = new Game();
        Player player = game.getPlayer();
        Garden garden = game.getGarden();
        Timer timer = game.getTimer();
        timer.setCurrentDay(Day.MONDAY);
        CarrotSeeds carrotSeeds1 = new CarrotSeeds();
        player.inventory.add(carrotSeeds1);
        garden.newGardenBed();

        // Planting, watering and weeding current garden bed.
        garden.getGardenBed(0).plantWith(carrotSeeds1, player);
        garden.getGardenBed(0).water(player);
        garden.getGardenBed(0).weed(player);

        // Ending day and reporting changes
        timer.endDay(player, garden);
        System.out.println(timer.getCurrentDay());
        player.getReport();
        System.out.println(garden);
        System.out.println();

        garden.getGardenBed(0).water(player);
        garden.getGardenBed(0).weed(player);

        // Ending day and reporting changes
        timer.endDay(player, garden);
        System.out.println(timer.getCurrentDay());
        player.getReport();
        System.out.println(garden);
        System.out.println();

        garden.getGardenBed(0).water(player);
        garden.getGardenBed(0).weed(player);

        // Ending day and reporting changes
        timer.endDay(player, garden);
        System.out.println(timer.getCurrentDay());
        player.getReport();
        System.out.println(garden);
        System.out.println();

        garden.getGardenBed(0).water(player);
        garden.getGardenBed(0).weed(player);

        // Ending day and reporting changes
        timer.endDay(player, garden);
        System.out.println(timer.getCurrentDay());
        player.getReport();
        System.out.println(garden);
        System.out.println();

        // Harvesting
        garden.getGardenBed(0).harvest(player);

        player.getReport();
        System.out.println(garden);
        System.out.println();

        player.getFromInventory(new Carrot());
        player.getReport();

    }
}
