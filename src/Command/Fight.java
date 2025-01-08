package fightboat.Command;

import java.util.ArrayList;


/*COMMAND PATTERN: The command pattern is implemented using Command class, which is abstract in our case, and each command that we possibly call
 from the user (e.g Setup, Fight) that invoke a command on our command class.
  The fight class is one of those commands, and in its execution we determine the result of attacks on the opponents board square.
 */
public class Fight  extends  Command
{

    public Fight(Receiver2 receiver2)
    {
        super(receiver2);
    }


    @Override
    public void execute2() {
        receiver2.attack();
    }

}
