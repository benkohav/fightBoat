package fightboat.actions;

import fightboat.GameBoard;
import fightboat.boards.Board;
import fightboat.observer.EventPublisher;

import java.util.ArrayList;
import java.util.Arrays;

public class AdjacentAttack extends GameAction{

    public AdjacentAttack() { super("Adjacent Attack", "/fightboat/images/AdjacentAttackImage.png"); }

    @Override
    public void execute(boolean player1, ArrayList<Integer> position) {

        if (player1) {
            EventPublisher.postEvent("Attack", "Attacking Player 1 using Adjacent Attack on position " + position);
        } else {
            EventPublisher.postEvent("Attack", "Attacking Player 2 using Adjacent Attack on position " + position);
        }
        Board boardCopy = null;
        if (player1) {
            boardCopy = GameBoard.getPlayer1Board();
        } else {
            boardCopy = GameBoard.getPlayer2Board();
        }

        // Assume board is square
        int boardSize = boardCopy.getState().size();

        // Attack center
        GameBoard.setBoardSquare(player1, position);

        // Attack right
        if (position.get(1) < (boardSize - 1)) {
            GameBoard.setBoardSquare(player1, new ArrayList<>(Arrays.asList(position.get(0), position.get(1) + 1)));
        }
    }
}
