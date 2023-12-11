package Seeds;

import Player.InventoryItem;
import Player.Player;
import Vegetables.*;

public abstract class Seed implements InventoryItem {
    int buyPrice;
    int sellPrice;
    int numSeeds;

    public abstract Vegetable getVegetableSpecies();
    public abstract int getNumSeeds();

    @Override
    public void sellItem(Player player) {
        player.inventory.remove(this);
        player.setGold(player.getGold() + this.sellPrice);
    }
}

