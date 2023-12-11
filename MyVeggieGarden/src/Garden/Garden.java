package Garden;

import java.util.ArrayList;

public class Garden {
    ArrayList<GardenBed> garden;

    public Garden() {
        this.garden = new ArrayList<>();
    }
    public ArrayList<GardenBed> getGarden() {
        return garden;
    }
    public GardenBed getGardenBed(int index) {
        return garden.get(index);
    }
    public void newGardenBed() {
        GardenBed gardenBed = new GardenBed();
        garden.add(gardenBed);
    }

    @Override
    public String toString() {
        return "Garden{" +
                "garden=" + garden +
                '}';
    }
}
