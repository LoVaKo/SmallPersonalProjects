package Player;

import java.util.ArrayList;

public class Player {
    int energy;
    int gold;
    public ArrayList<InventoryItem> inventory;

    public Player() {
        this.energy = 50;
        this.gold = 100;
        this.inventory = new ArrayList<>();
    }
    // Getters
    public int getEnergy() {
        return energy;
    }
    public int getGold() {
        return gold;
    }

    // Setters
    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }

    // Inventory methods
    public boolean checkInventory(InventoryItem item) {
        for (InventoryItem item2 : inventory) {
            if (item.equals(item2)) return true;
        }
        return false;
    }
    public InventoryItem getFromInventory(InventoryItem requestedItem) {
        InventoryItem fromInventory = null;
        for (InventoryItem storedItem : inventory) {
            if (storedItem.equals(requestedItem)) {
                fromInventory = storedItem;
                inventory.remove(storedItem);
            } else {
                System.out.println("Item not in inventory");
            }
        }
        return fromInventory;
    }

    public void getReport() {
        System.out.println("Current energylevel: " + energy + "/100");
        System.out.println("Current gold: " + gold);
        System.out.println("Current inventory: " + inventory);
    }

}
