package fightboat.Command;

import fightboat.GameBoard;

import java.util.ArrayList;

public class Invoker
{
    private Command command = null;


    /*COMMAND PATTERN: The command pattern is implemented using Command class, which is abstract in our case, and each command that we possibly call
 from the user (e.g Setup, Fight) that invoke a command on our command class.
 The Invoker class is one of those commands, and we determine which command will occur and be called and executed based on how our invoker is created.
 */
    private static Invoker invoke = new Invoker();


    public static void execute2(Command command) {
        command.execute2();
    }


}
