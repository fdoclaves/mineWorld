package com.faaya.mineWorld;

public class GameCode {
    private int x;
    private int y;

    public GameCode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getCode() {
        return x + "," + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
