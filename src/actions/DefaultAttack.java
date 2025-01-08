package fightboat.actions;

import fightboat.GameBoard;
import fightboat.observer.EventPublisher;

import java.util.ArrayList;

public class DefaultAttack extends GameAction {
    public DefaultAttack() {
        super("Default Attack", "/fightboat/images/DefaultAttackImage.png");
    }

    @Override
    public void execute(boolean player1, ArrayList<Integer> position)
    {
        if(player1)
        {
            EventPublisher.postEvent("Attack", "Attacking Player 1 using Default Attack on position " + position);
        }
        else {
            EventPublisher.postEvent("Attack", "Attacking Player 2 using Default Attack on position " + position);
        }
        GameBoard.setBoardSquare(player1, position);
    }
}
