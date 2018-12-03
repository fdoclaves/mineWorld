package com.faaya.mineWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {

    private List<Player> players;

    public GameController(Player... players1) {
        players = new ArrayList<Player>();
        for (Player player : players1) {
            players.add(player);
        }
    }

    public Player choosePlayer() {
        return players.get(new Random().nextInt(players.size()));
    }

    public void chooseHouses() {
        while (players.size() > 0) {
            Player player = choosePlayer();
            player.chooseHouse();
            players.remove(player);
        }
    }
}
