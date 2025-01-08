package fightboat.Command;

import java.util.ArrayList;
import java.util.Arrays;

/*COMMAND PATTERN: The command pattern is implemented using Command class, which is abstract in our case, and each command that we possibly call
 from the user (e.g Setup, Fight) that invoke a command on our command class.
  The Receiver class is what will ultimately take on all the changes that are executed by any of the commands, and it will report those changes back to our game Board class.

 */
public class Receiver {

    private static Receiver receive = new Receiver();

    private boolean currentPlayer = false;

    private ArrayList<Integer> position = new ArrayList<Integer>(Arrays.asList(1,1));

    public String attackingBoat;
//
//    public static setAttackingBoat(String boat): void
//+ <<static>> getAttackingBoat(): Boat
//+ <<static>> attack(ArrayList<Integer>): void

    public static Receiver getReceiver() {
        return receive;
    }

//    public static void setReceive(

    //BEN ADDED
    public static boolean getPlayer() { return receive.currentPlayer;}

    public static void setPlayer(boolean currentPlayer) {  receive.currentPlayer = currentPlayer;}

    public static ArrayList<Integer> getPosition(){return receive.position;}

    public static void setPosition(int row, int col){ receive.position.set(0, row); receive.position.set(1,col);}
}
