package Seeds;

import Vegetables.Carrot;

public class CarrotSeeds extends Seed{
    public CarrotSeeds() {
        buyPrice = 10;
        sellPrice = 5;
        numSeeds = 10;
    }

    @Override
    public String toString() {
        return "Carrot seeds";
    }

    @Override
    public Carrot getVegetableSpecies() {
        return new Carrot();
    }

    @Override
    public int getNumSeeds() {
        return this.numSeeds;
    }
}

