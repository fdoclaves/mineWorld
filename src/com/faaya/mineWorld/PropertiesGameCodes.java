package com.faaya.mineWorld;

import java.util.ArrayList;
import java.util.List;

public class PropertiesGameCodes {

    private GameCode gameCode;
    private TableUtils tableUtils;
    private List<String> locationProperties = new ArrayList<>();

    public PropertiesGameCodes(final TableUtils tableUtils, final GameCode gameCode) {
        this.gameCode = gameCode;
        this.tableUtils = tableUtils;
    }

    public GameCode getGameCode() {
        return gameCode;
    }

    public int getCloseLocationProperty(String locationProperty) {
        return tableUtils.countForValue(locationProperty, gameCode);
    }

    public boolean isFree() {
        return locationProperties.isEmpty();
    }

    public void set(String locationProperty) {
        locationProperties.add(locationProperty);
    }

    public boolean is(String locationProperty) {
        for (String property : locationProperties) {
            if (property.equals(locationProperty)) {
                return true;
            }
        }
        return false;
    }

    public boolean isType(String house) {
        for (String property : locationProperties) {
            if (property.contains(house)) {
                System.out.println(property);
                return true;
            }
        }
        return false;
    }
}
