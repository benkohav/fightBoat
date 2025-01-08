package fightboat.Command;

import fightboat.GameBoard;
import fightboat.boards.Board;
import fightboat.observer.EventPublisher;

import java.util.ArrayList;

/*COMMAND PATTERN: The command pattern is implemented using Command class, which is abstract in our case, and each command that we possibly call
 from the user (e.g Setup, Fight) that invoke a command on our command class.
  The Receiver class is what will ultimately take on all the changes that are executed by any of the commands, and it will report those changes back to our game Board class.
 */
public class Receiver2 {

    boolean player1;
    int boatNum;
    ArrayList<Integer> position;
    public Receiver2(boolean player1, int boatNum, ArrayList<Integer> position) {
        this.player1 = player1;
        this.boatNum = boatNum;
        this.position = position;
    }

    public void placeBoat() {
        System.out.println("Entered setup");
        if(this.player1)
        {
            System.out.println("Setting player 1 board");
            System.out.println("Updating boat position for boat #" + boatNum);
            EventPublisher.postEvent("Set Position", "Setting player 1 boardUpdating boat position for boat #" + boatNum + ", " + GameBoard.getPlayer1Board().getBoats().get(boatNum).getBoatName() + ", to position " + position);
            GameBoard.setPlayer1BoatPosition(boatNum, position);
        }
        else
        {
            System.out.println("Setting player 2 board");
            System.out.println("Updating boat position for boat #" + boatNum);
            EventPublisher.postEvent("Set Position", "Setting player 2 boardUpdating boat position for boat #" + boatNum + ", " + GameBoard.getPlayer2Board().getBoats().get(boatNum).getBoatName() + ", to position " + position);
            GameBoard.setPlayer2BoatPosition(boatNum, position);
        }
    }

    public void attack() {
        System.out.println("List of boats: " + GameBoard.getPlayer1Board().getBoats());
        System.out.println("Boatnum: " + this.boatNum);
        // Making this not player1 fixed issue where boats were using other players attack
        // Maybe because player is in this case the one being attacked, so if player 2 is being attacked, get player
        // 1 boat and attack
        if (!this.player1) {
            // Call Gameboard functions to update square
            //GameBoard.setBoardSquare(true, this.position);

            // Call Action of specified boat
            GameBoard.getPlayer1Board().getBoats().get(this.boatNum).getAction().execute(this.player1, this.position);

        }
        else {
            // Call Gameboard functions to update square

            // Call Action of specified boat
            GameBoard.getPlayer2Board().getBoats().get(this.boatNum).getAction().execute(this.player1, this.position);
        }
    }
}
