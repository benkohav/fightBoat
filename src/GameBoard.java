package fightboat;
import fightboat.boards.*;
import fightboat.boats.*;
import fightboat.observer.EventPublisher;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;


/*SINGLETON PATTERN: It ensures a class has only one instance and provides a global point of access to that instance.
It's like having a single, shared instance of a class accessible across an entire application.
 The GameBoard class is our singleton pattern in essence for this game, because we have one dedicated instance of the game for the whole duration.
 The components of the game, housed in GameBoard, are hence accessible in this shared instance at all times.
 */
public class GameBoard {

    private static GameBoard gameBoard = new GameBoard();
    private Board player1Board;
    private Board player2Board;

    private static JFrame currentFrame = null;

    private int gameState = 0;

    private static int numTurn = 0;




    private GameBoard() {}

    public static GameBoard getGameBoard() {
        return gameBoard;
    }
    public static void setBoard(String boardType) {
        switch (boardType) {
            case "Square Board": {
                gameBoard.player1Board = new SquareBoard(10);
                gameBoard.player2Board = new SquareBoard(10);
                System.out.println("Successfully set board as Square Board");
                break;
            }
            case "Smiley Board": {
                gameBoard.player1Board = new SmileyBoard();
                gameBoard.player2Board = new SmileyBoard();
                System.out.println("Successfully set board as Smiley Board");
                break;
            }
            case "Diamond Board": {
                gameBoard.player1Board = new DiamondBoard();
                gameBoard.player2Board = new DiamondBoard();
                System.out.println("Successfully set board as Diamond Board");
                break;
            }
            case "Donut Board": {
                gameBoard.player1Board = new DonutBoard();
                gameBoard.player2Board = new DonutBoard();
                System.out.println("Successfully set board as Donut Board");
                break;
            }
        }
    }

    public static void setPlayer1Fleet(String fleetType) {
        switch (fleetType) {
            case "Attack Fleet": {
                //BEN COMMENTED
                gameBoard.player1Board.setBoats(AttackFleet.getFleetBoats());
                System.out.println("Successfully set fleet as Attack Fleet");
                break;
            }
            case "Economic Fleet": {
                gameBoard.player1Board.setBoats(EconomicFleet.getFleetBoats());
                System.out.println("Successfully set fleet as Economic Fleet");
                break;
            }
            case "Small But Mighty Fleet": {
                gameBoard.player1Board.setBoats(SmallButMightyFleet.getFleetBoats());
                System.out.println("Successfully set fleet as Small But Mighty Fleet");
                break;
            }
        }
    }

    public static void setPlayer2Fleet(String fleetType) {
        switch (fleetType) {
            case "Attack Fleet": {
                gameBoard.player2Board.setBoats(AttackFleet.getFleetBoats());
                System.out.println("Successfully set fleet as Attack Fleet");
                break;
            }
            case "Economic Fleet": {
                gameBoard.player2Board.setBoats(EconomicFleet.getFleetBoats());
                System.out.println("Successfully set fleet as Economic Fleet");
                break;
            }
            case "Small But Mighty Fleet": {
                gameBoard.player2Board.setBoats(SmallButMightyFleet.getFleetBoats());
                System.out.println("Successfully set fleet as Small But Mighty Fleet");
                break;
            }
        }
    }

    public static Board getPlayer1Board()
    {
//        gameBoard.player1Board.displayState2();
        return gameBoard.player1Board;
    }

    public static Board getPlayer2Board() {
        return gameBoard.player2Board;
    }

    public static void setPlayer1BoatPosition(int i, ArrayList<Integer> position) {
        System.out.println("Setting board 1 boat " + i + " position to " + position);
        gameBoard.player1Board.setBoatPosition(i,position);
    }
    public static void setPlayer2BoatPosition(int i, ArrayList<Integer> position) {
        System.out.println("Setting board 2 boat " + i + " position to " + position);
        gameBoard.player2Board.setBoatPosition(i,position);
    }

    public static int getGameState() { return gameBoard.gameState; }
    public static void setGameState(int state)
    {
        System.out.println("Setting state to " + state);
        gameBoard.gameState = state;
    }

    public static void setBoardSquare(boolean player1, ArrayList<Integer> position)
    {
        if(player1)
        {
            if(gameBoard.player1Board.attackSpace(position))
            {
                gameBoard.player1Board.setSquare(false, true, position);
                //check sunk

                EventPublisher.postEvent("Attack", "Player 1 Boat by Player 2 hit at " + position + "!");
                //check sunk (board) --> check sunk for EACH BOAT (passing in game state) --> updateSunk in Boat class
            }
            else gameBoard.player1Board.setSquare(true, false, position);
            gameBoard.player1Board.checkSunkBoats(true);
        }
        else
        {
            if(gameBoard.player2Board.attackSpace(position))
            {
                gameBoard.player2Board.setSquare(false, true, position);
                //check sunk
                EventPublisher.postEvent("Attack", "Player 2 Boat by Player 1 hit at " + position + "!");


            }
            else gameBoard.player2Board.setSquare(true, false, position);

            gameBoard.player2Board.checkSunkBoats(false);
        }
    }

    public static boolean checkValidPlacement(boolean player1, int boatNum, ArrayList<Integer> position) {
        if (player1) {
            return gameBoard.player1Board.checkValidPlacement(boatNum, position);
        }
        return gameBoard.player2Board.checkValidPlacement(boatNum,position);
    }

    public static void iterateAttackingBoat(boolean player1)
    {
        if(player1)
        {
            gameBoard.player1Board.iterateAttackingBoat();
        }
        else
        {
            gameBoard.player2Board.iterateAttackingBoat();
        }
    }

    public static void resetAttackingBoat(boolean player1)
    {
        if(player1)
        {
            gameBoard.player1Board.resetAttackingBoat();
        }
        else
        {
            gameBoard.player2Board.resetAttackingBoat();
        }
    }

    public static void addTurn()
    {
        GameBoard.numTurn++;
    }

    public static int getTurn()
    {
        return GameBoard.numTurn;
    }

    public static void setFrame(JFrame currFrame)
    {
        if(currentFrame != null)
        {
            currentFrame.dispose();
        }
        GameBoard.currentFrame = currFrame;
        currentFrame.setVisible(true);
    }

    public static JFrame getFrame()
    {
        return currentFrame;
    }

    public static void resetFrame()
    {
        currentFrame.dispose();
    }

    public static void addMoney(Boolean player1, int moneyAmt) {
        if (player1) {
            gameBoard.player1Board.addMoney(moneyAmt);
        }
        else {
            gameBoard.player2Board.addMoney(moneyAmt);
        }
    }

    public static void upgradeBoat(Boolean player1, int boatNum) {
        if (player1) {
            int upgradeCost = gameBoard.player1Board.getBoats().get(boatNum).getUpgradeCost();
            if (gameBoard.player1Board.getMoneyBalance() >= upgradeCost) {
                gameBoard.player1Board.upgradeBoat(boatNum, true);
                gameBoard.player1Board.spendMoney(upgradeCost);
            }
            else { System.out.println("Not enough money!"); }
        }
        else{
            int upgradeCost = gameBoard.player2Board.getBoats().get(boatNum).getUpgradeCost();
            if (gameBoard.player2Board.getMoneyBalance() >= upgradeCost) {
                gameBoard.player2Board.upgradeBoat(boatNum, false);
                gameBoard.player2Board.spendMoney(upgradeCost);
            }
            else { System.out.println("Not enough money!"); }
        }
    }

}
