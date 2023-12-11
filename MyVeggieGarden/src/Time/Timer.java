package Time;
import Garden.*;
import Player.*;
import java.util.Random;
public class Timer {
    private Day currentDay;

    // Setters
    public void setCurrentDay(Day currentDay) {
        this.currentDay = currentDay;
    }

    // Getters
    public Day getNextDay() {
        return Day.values()[(currentDay.ordinal() + 1) % Day.values().length];
    }
    public Day getCurrentDay() {
        return currentDay;
    }

    // Other methods
    public void endDay(Player player, Garden garden) {
        Random random = new Random();

        // Setting player energy back to 100
        player.setEnergy(100);

        // Updating garden: Progress growth if conditions are met. Set to not watered. 70% change to regrow weeds.
        for (GardenBed bed : garden.getGarden()) {
            if( bed.isPlanted() &&
                bed.isWeeded() &&
                bed.isWatered() &&
                bed.getGrowthstage() != Growthstage.HARVEST) {
                bed.setGrowthstage(Growthstage.values()[bed.getGrowthstage().ordinal() + 1]);
            }
            bed.setWatered(false);
            if (random.nextDouble() <= 0.7) bed.setWeeded(false);
        }
        // Next Day
        setCurrentDay(getNextDay());
    }
}
