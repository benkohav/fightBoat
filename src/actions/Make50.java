package fightboat.actions;

import fightboat.GameBoard;
import fightboat.observer.EventPublisher;

import java.util.ArrayList;

public class Make50 extends GameAction{

    private int moneyPerRound;
    public  Make50() {
        super("Make", "/fightboat/images/$50.jpg");
        this.moneyPerRound = 50;
    }

    @Override
    public void execute(boolean player1, ArrayList<Integer> position) {
        // In this case, player1 represents whether it is player 1 or player 2 being attacked. In either case, give money to the attacker
        GameBoard.addMoney(!player1,this.moneyPerRound);
        if(player1)
        {
            EventPublisher.postEvent("Make Money", "Player 2 added 50 coins through their container ship!");
        }
        else EventPublisher.postEvent("Make Money", "Player 1 added 50 coins through their container ship!");
    }
}
