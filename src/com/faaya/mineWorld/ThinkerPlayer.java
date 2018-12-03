package com.faaya.mineWorld;

import com.faaya.mineWorld.enums.ColorPlayer;
import com.faaya.mineWorld.enums.LocationProperty;

import java.util.Calendar;

public class ThinkerPlayer implements Player {

    private long finalTime;

    private GameDesitor gameDesitor;
    private String colorHouse;

    public ThinkerPlayer(GameDesitor gameDesitor, String colorHouse) {
        this.gameDesitor = gameDesitor;
        this.colorHouse = colorHouse;
    }

    public void start(int secondsTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, secondsTime);
        finalTime = calendar.getTimeInMillis();
    }

    public long getTimeLeft() {
        return finalTime - Calendar.getInstance().getTimeInMillis();
    }

    @Override
    public void chooseHouse() {
        PropertiesGameCodes propertiesGameCodes = gameDesitor.chooseHouse();
        propertiesGameCodes.set(colorHouse);
    }
}
