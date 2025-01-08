package fightboat.Command;

import fightboat.GameBoard;
import fightboat.boards.Board;
import fightboat.boards.Square;
import fightboat.boats.AircraftCarrier;
import fightboat.boats.Boat;

import java.util.ArrayList;


/*COMMAND PATTERN: The command pattern is implemented using Command class, which is abstract in our case, and each command that we possibly call
 from the user (e.g Setup, Fight) that invoke a command on our command class.
  The setup class is one of those commands, and in its execution we are able to place the players boats in their desired positions.
 */
public class Setup extends Command
{

    public Setup(Receiver2 receiver2)
    {
        super(receiver2);
    }

    @Override
    public void execute2() {
        receiver2.placeBoat();
    }
}
