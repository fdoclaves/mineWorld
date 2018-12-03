package com.faaya.mineWorld;

import com.faaya.mineWorld.enums.LocationProperty;

public class UtilsTest {

    public static PropertiesGameCodes[][] convert(String[][] table){
        PropertiesGameCodes[][] board = new PropertiesGameCodes[table.length][table[0].length];
        TableUtils tableUtils = new TableUtils(board);
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                PropertiesGameCodes propertiesGameCodes = new PropertiesGameCodes(tableUtils, new GameCode(x, y));
                if(table[y][x].contains("M")){
                    propertiesGameCodes.set(LocationProperty.MINE);
                }
                board[y][x]= propertiesGameCodes;
            }
        }
        return board;
    }
}
