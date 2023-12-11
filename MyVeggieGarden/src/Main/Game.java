package Main;

import Player.*;
import Garden.*;
import Time.*;

public class Game {
    Player player;
    Garden garden;
    Timer timer;

    public Game() {
        this.player = new Player();
        this.garden = new Garden();
        this.timer = new Timer();
    }
    public Garden getGarden() {
        return garden;
    }
    public Player getPlayer() {
        return player;
    }

    public Timer getTimer() {
        return timer;
    }
}
