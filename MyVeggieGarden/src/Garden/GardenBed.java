package Garden;

import Seeds.Seed;
import Player.Player;
import Vegetables.Vegetable;

import java.lang.reflect.InvocationTargetException;

public class GardenBed {
    boolean isPlanted;
    boolean isWatered;
    boolean isWeeded;
    Seed isPlantedWith;
    Growthstage growthstage;

    // Constructor
    public GardenBed() {
        isPlanted = false;
        isWatered = false;
        isWeeded = false;
        isPlantedWith = null;
        growthstage = null;
    }

    @Override
    public String toString() {
        return "GardenBed{" +
                "isPlanted=" + isPlanted +
                ", isWatered=" + isWatered +
                ", isWeeded=" + isWeeded +
                ", isPlantedWith=" + isPlantedWith +
                ", growthstage=" + growthstage +
                '}';
    }

    // Setters
    public void setWeeded(boolean weeded) {
        isWeeded = weeded;
    }
    public void setWatered(boolean watered) {
        isWatered = watered;
    }
    public void setGrowthstage(Growthstage growthstage) {
        this.growthstage = growthstage;
    }
    public void setPlanted(boolean planted) {
        isPlanted = planted;
    }
    public void setIsPlantedWith(Seed isPlantedWith) {
        this.isPlantedWith = isPlantedWith;
    }

    // Getters
    public boolean isPlanted() {
        return isPlanted;
    }
    public boolean isWatered() {
        return isWatered;
    }
    public boolean isWeeded() {
        return isWeeded;
    }
    public Growthstage getGrowthstage() {
        return growthstage;
    }
    public Seed getIsPlantedWith() {
        return isPlantedWith;
    }

    // Other methods
    public void plantWith(Seed seed, Player player) {
        if (player.getEnergy() < 3) {
            System.out.println("You don't have enough energy to plant seeds.");
            return;
        }

        if (player.checkInventory(seed)) {
            player.inventory.remove(seed);
            player.setEnergy(player.getEnergy()-3);
            isPlanted = true;
            growthstage = Growthstage.PLANTED;
            isPlantedWith = seed;
        } else {
            System.out.println("You don't currently have that type of seed.");
        }
    }
    public void water(Player player) {
        if (player.getEnergy() < 5) {
            System.out.println("You don't have enough energy to water the garden.");
            return;
        }
        isWatered = true;
        player.setEnergy(player.getEnergy()-5);
    }
    public void weed(Player player) {
        if (player.getEnergy() < 5) {
            System.out.println("You don't have enough energy to weed the garden.");
        } else if (this.isWeeded){
            System.out.println("The garden is already weeded.");
        } else {
            isWeeded = true;
            player.setEnergy(player.getEnergy() - 5);
        }
    }
    public void harvest(Player player) {
        if (player.getEnergy() < 5) {
            System.out.println("You don't have enough energy to harvest this bed.");
            return;
        } else if (!this.getGrowthstage().equals(Growthstage.HARVEST)){
            System.out.println("The crop is not ready yet.");
            return;
        }

        if (this.isPlantedWith != null) {
            int numVegetables = this.isPlantedWith.getNumSeeds();
            String typeOfVegetable = this.isPlantedWith.getVegetableSpecies().toString();

            try {
                Class<?> vegetableClass = Class.forName("Vegetables." + typeOfVegetable);
                for (int i = 0; i < numVegetables; i++) {
                    Vegetable vegetable = (Vegetable) vegetableClass.getDeclaredConstructor().newInstance();
                    player.inventory.add(vegetable);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException |
                     InvocationTargetException e) {
                e.printStackTrace();
            }
            this.setPlanted(false);
            this.setGrowthstage(null);
            this.setIsPlantedWith(null);
            player.setEnergy(player.getEnergy() - 5);
        }
    }
}
