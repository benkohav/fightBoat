package fightboat.actions;

import fightboat.GameBoard;
import fightboat.boards.Board;
import fightboat.observer.EventPublisher;

import java.util.ArrayList;
import java.util.Arrays;

public class OAttack extends GameAction{
    public OAttack() {
        super("O Attack", "/fightboat/images/OAttackImage.png");
    }

    @Override
    public void execute(boolean player1, ArrayList<Integer> position) {

        if(player1)
        {
            EventPublisher.postEvent("Attack", "Attacking Player 1 using O Attack on position " + position);
        }
        else {
            EventPublisher.postEvent("Attack", "Attacking Player 2 using O Attack on position " + position);
        }
        Board boardCopy = null;
        if (player1) {
            boardCopy = GameBoard.getPlayer1Board();
        }
        else {
            boardCopy = GameBoard.getPlayer2Board();
        }

        // Assume board is square
        int boardSize = boardCopy.getState().size();

        // Attack up
        if (position.get(0) >= 1) {
            GameBoard.setBoardSquare(player1, new ArrayList<>(Arrays.asList(position.get(0)-1,position.get(1))));
        }
        // Attack right
        if (position.get(1) < (boardSize-1)) {
            GameBoard.setBoardSquare(player1, new ArrayList<>(Arrays.asList(position.get(0),position.get(1)+1)));
        }
        // Attack down
        if (position.get(0) < (boardSize-1)) {
            GameBoard.setBoardSquare(player1, new ArrayList<>(Arrays.asList(position.get(0)+1,position.get(1))));
        }
        // Attack left
        if (position.get(1) >= 1) {
            GameBoard.setBoardSquare(player1, new ArrayList<>(Arrays.asList(position.get(0),position.get(1)-1)));
        }
    }
}
