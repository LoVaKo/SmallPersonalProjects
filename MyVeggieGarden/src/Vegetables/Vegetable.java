package Vegetables;

import Player.InventoryItem;
import Player.Player;

public abstract class Vegetable implements InventoryItem {
    int sellPrice;
    int energy;

    public void eat(Player player) {
        player.inventory.remove(this);

        if (player.getEnergy() < (100 - this.energy)) {
            player.setEnergy(player.getEnergy() + this.energy);
        } else if (player.getEnergy() >= (100 - this.energy)) {
            player.setEnergy(100);
        }
    }

    @Override
    public void sellItem(Player player) {
        player.inventory.remove(this);
        player.setGold(player.getGold() + this.sellPrice);
    }
}
