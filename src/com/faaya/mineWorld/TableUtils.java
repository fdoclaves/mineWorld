package com.faaya.mineWorld;

import com.faaya.mineWorld.enums.LocationProperty;

public class TableUtils {
    private PropertiesGameCodes[][] board;

    public TableUtils(PropertiesGameCodes[][] board) {
        this.board = board;
    }

    public PropertiesGameCodes[][] getBoard() {
        return board;
    }

    public boolean existPosition(int x, int y) {
        return existY(y) && existX(x);
    }

    private boolean existX(int x) {
        return x < board[0].length && x >= 0;
    }

    public boolean existY(int y) {
        return y < board.length && y >= 0;
    }

    public boolean hasCode(int x, int y, String locationProperty) {
        try {
            if (!existPosition(x, y)) {
                return false;
            }
            return board[y][x].is(locationProperty);
        } catch (Exception e) {
            System.out.println("error:" + x + ", " + y);
            throw e;
        }
    }

    public int countForValue(String locationProperty, GameCode gameCode) {
        int distance = 1;
        int count = 0;
        if (hasCode(gameCode.getX() - distance, gameCode.getY() + distance, locationProperty)) {
            count++;
        }
        if (hasCode(gameCode.getX() - 0, gameCode.getY() + distance, locationProperty)) {
            count++;
        }
        if (hasCode(gameCode.getX() + distance, gameCode.getY() + distance, locationProperty)) {
            count++;
        }

        if (hasCode(gameCode.getX() - distance, gameCode.getY() - 0, locationProperty)) {
            count++;
        }
        if (hasCode(gameCode.getX() + distance, gameCode.getY() - 0, locationProperty)) {
            count++;
        }

        if (hasCode(gameCode.getX() - distance, gameCode.getY() - distance, locationProperty)) {
            count++;
        }
        if (hasCode(gameCode.getX() - 0, gameCode.getY() - distance, locationProperty)) {
            count++;
        }
        if (hasCode(gameCode.getX() + distance, gameCode.getY() - distance, locationProperty)) {
            count++;
        }
        return count;
    }
}
