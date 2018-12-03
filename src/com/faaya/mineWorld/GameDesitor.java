package com.faaya.mineWorld;

import com.faaya.mineWorld.enums.LocationProperty;

public class GameDesitor {

    private PropertiesGameCodes[][] board;

    public GameDesitor(PropertiesGameCodes[][] board) {
        this.board = board;
    }

    public PropertiesGameCodes chooseHouse() {
        PropertiesGameCodes mayorMinePropertiesGameCodes = board[0][0];
        int maxMines = mayorMinePropertiesGameCodes.getCloseLocationProperty(LocationProperty.MINE);
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                PropertiesGameCodes propertiesGameCodes = board[y][x];
                int mines = propertiesGameCodes.getCloseLocationProperty(LocationProperty.MINE);
                if (mines >= maxMines && propertiesGameCodes.isFree()) {
                    mayorMinePropertiesGameCodes = propertiesGameCodes;
                    maxMines = mines;
                }
            }
        }
        return mayorMinePropertiesGameCodes;
    }

}
