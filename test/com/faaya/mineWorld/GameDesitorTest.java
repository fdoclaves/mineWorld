package com.faaya.mineWorld;

import com.faaya.mineWorld.enums.ColorPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameDesitorTest {

    GameDesitor gameDesitor;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void chooseHouseOneMine(){
        String [][] table = {{"X","X","X"},{"X","X","X"},{"X","X","M"}};
        gameDesitor = new GameDesitor(UtilsTest.convert(table));
        assertEquals("1,2", gameDesitor.chooseHouse().getGameCode().getCode());
    }

    @Test
    public void chooseHouseTwoMine(){
        String [][] table = {{"X","X","X","X","M"},{"X","X","X","X","X"},{"X","X","M","X","X"}};
        gameDesitor = new GameDesitor(UtilsTest.convert(table));
        assertEquals("3,1", gameDesitor.chooseHouse().getGameCode().getCode());
    }

    @Test
    public void chooseHouseThreeMine(){
        String [][] table = {{"X","X","X","X","M"},{"X","X","X","X","X"},{"X","X","M","X","M"}};
        gameDesitor = new GameDesitor(UtilsTest.convert(table));
        assertEquals("3,1", gameDesitor.chooseHouse().getGameCode().getCode());
    }

    @Test
    public void chooseHouseThreeMineDiferentLocations(){
        String [][] table = {{"M","X","X","X","M"},{"M","X","X","X","X"},{"X","X","M","X","M"}};
        gameDesitor = new GameDesitor(UtilsTest.convert(table));
        assertEquals("3,1", gameDesitor.chooseHouse().getGameCode().getCode());
    }

    @Test
    public void chooseHouseThreeMineDiferentLocations2(){
        String [][] table = {{"X","X","X","X","M"},{"X","X","X","X","X"},{"X","X","X","X","X"}};
        gameDesitor = new GameDesitor(UtilsTest.convert(table));
        assertEquals("4,1", gameDesitor.chooseHouse().getGameCode().getCode());
    }

    @Test
    public void chooseHouseThreeMineDiferentLocationsAndIsMine(){
        String [][] table = {{"X","X","X","M","X"},{"X","X","M","M","M"},{"X","X","X","M","X"}};
        gameDesitor = new GameDesitor(UtilsTest.convert(table));
        assertEquals("4,2", gameDesitor.chooseHouse().getGameCode().getCode());
    }

    @Test
    public void checarTiempo() throws InterruptedException {
        String [][] table = {{"X","X","X"},{"X","X","X"},{"X","X","M"}};
        ThinkerPlayer thinkerPlayer = new ThinkerPlayer(new GameDesitor(UtilsTest.convert(table)), ColorPlayer.BLUE_PLAYER_HOUSE);
        thinkerPlayer.start(5);
        System.out.println("Esperando...");
        Thread.sleep(3000);
        assertTrue(thinkerPlayer.getTimeLeft() > 0);
        System.out.println("Esperando...");
        Thread.sleep(2000);
        assertTrue("Deberia ser cero", thinkerPlayer.getTimeLeft() <= 0);
    }

    @Test
    public void play(){
        String [][] table = {{"X","X","X","M","X"},{"X","X","M","M","M"},{"X","X","X","M","H"}};
        PropertiesGameCodes[][] board = UtilsTest.convert(table);
        gameDesitor = new GameDesitor(board);
        Player player1 = new ThinkerPlayer(gameDesitor, ColorPlayer.BLUE_PLAYER_HOUSE);
        Player player2 = new ThinkerPlayer(gameDesitor, ColorPlayer.RED_PLAYER_HOUSE);
        GameController gameController = new GameController(player1, player2);
        gameController.chooseHouses();
        int countHouse=0;
        for (int y = 0; y < table.length; y++) {
            for (int x = 0; x < table[y].length; x++) {
               if(board[y][x].isType("HOUSE")){
                   countHouse++;
               }
            }
        }
        assertEquals(2, countHouse);

    }
}