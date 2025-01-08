package fightboat.Command;

import java.util.ArrayList;


/*COMMAND PATTERN: The command pattern is implemented using Command class, which is abstract in our case, and each command that we possibly call
 from the user (e.g Setup, Fight) that invoke a command on our command class.
  They are all extensions of Command. Each command has its own way of executing, hence the abstract function execute.
 */
public abstract class Command {

    protected Receiver2 receiver2;

    public Command(Receiver2 receiver2) {
        this.receiver2 = receiver2;
    }


    //Adventurers, Creatures
//    public abstract void execute(int boatNum);

    public abstract void execute2();

}