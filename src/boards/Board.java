package fightboat.boards;

import fightboat.Command.*;
import fightboat.GameBoard;
import fightboat.boats.*;
import fightboat.jframes.EndGame;
import fightboat.jframes.PlaceFleet;
import fightboat.jframes.PlayGame;
import fightboat.observer.EventPublisher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public abstract class Board {

    protected String boardName;

    protected String boardDescription;

    protected ArrayList<Boat> boats = new ArrayList<>();
    ArrayList<ArrayList<Square>> state = null;

    private int currentAttackingBoat = 0;

    private boolean fleetType = false;

    private int money = 0;

//    protected ArrayList<ArrayList<Square>> boardStorePlayer1 = null;




    protected abstract ArrayList<ArrayList<Square>> initializeState();

    // currPlayer means whether or not the board should be displayed for the player who is currently moving
    // True would mean the buttons on the board do nothing, False would me they do something
    // The logic is that if you are moving, the buttons on your own board do nothing
    // player1 is which player the board is for, true = player 1, false = player 2
    public JLayeredPane displayState2(boolean currPlayer, boolean player1) {
        JLayeredPane board = new JLayeredPane();
        board.setPreferredSize(new Dimension(500, 500));
        GridLayout boardLayout = new GridLayout(0, 10);
        board.setLayout(boardLayout);
        JPanel boardPanel = new JPanel();

        boardPanel.setLayout(new GridLayout(0, 10));

        if (this.state == null) {
            System.out.println("State is null");
        }
        // Loop through boats and print positions
//        for (int i = 0; i < this.getBoats().size(); i++) {
//            System.out.println("Boat " + i + " position: " + this.getBoats().get(i).getPosition());
//        }

        // Loop through squares and create them,
        for (int i = 0; i < this.state.size(); i++) {
            for (int j = 0; j < this.state.get(0).size(); j++) {

                int row = i;
                int col = j;
                Square square = this.state.get(i).get(j);

                if (square.returnButton()) {
                    JButton boardSpace = square.generatateButton(currPlayer, this.getBoats());
//                    switch (GameBoard.getGameState()) {
//                        case 0: {boardSpace.setBackground(square.getColor(false,new ArrayList<>())); break;}
//                        // Make !currPlayer for setup so that boats will display and buttons can be pressed
//                        case 1: {boardSpace.setBackground(square.getColor(!currPlayer, this.getBoats())); break;}
//                        case 2: {boardSpace.setBackground(square.getColor(currPlayer, this.getBoats())); break;}
//                    }
                    //System.out.println("Before remove: " + boardSpace.getActionListeners());
//                    for( ActionListener al : boardSpace.getActionListeners() ) {
//                        System.out.println("Removed action listener");
//                        boardSpace.removeActionListener( al );
//                    }
                    //System.out.println("After remove: " + boardSpace.getActionListeners());

                    if (!currPlayer) {
                        boardSpace.addActionListener(e -> {
                            //System.out.println("Running button action listener");

                            // Check if already attacked
                            if (square.getMiss() | square.getHit()) {
//                            boardSpace.setBackground(Color.RED);
                            }
                            else {
                                // If
                                if (GameBoard.getGameState() == 1) {
                                    int boatNum = boatNotSet();
                                    if (boatNum != -1) {
                                        //System.out.println("Not all boats set");
                                        // Check that the placement is valid
                                        if (GameBoard.checkValidPlacement(player1, boatNum, new ArrayList<Integer>(Arrays.asList(row,col)))) {
                                            Invoker.execute2(new Setup(new Receiver2(player1, boatNum, new ArrayList<Integer>(Arrays.asList(row, col)))));

//                                            new PlaceFleet(player1).setVisible(true);
                                            GameBoard.setFrame(new PlaceFleet(player1));
                                        }
                                    }
                                    else System.out.println("All boats set");
                                }
                                else if (GameBoard.getGameState() == 2) {
                                    // This needs to be for whichever boats haven't attacked when we get there

                                    if(player1)
                                    {
                                        Invoker.execute2(new Fight(new Receiver2(player1, GameBoard.getPlayer2Board().getCurrentAttackingBoat(), new ArrayList<Integer>(Arrays.asList(row, col)))));
                                    }
                                    else
                                    {
                                        Invoker.execute2(new Fight(new Receiver2(player1, GameBoard.getPlayer1Board().getCurrentAttackingBoat(), new ArrayList<Integer>(Arrays.asList(row, col)))));
                                    }
//                                    for (int k = 0; k < Frame.getFrames().length; k++) {
//                                        Frame.getFrames()[0].dispose();
//                                    }

                                    if(checkEndState())
                                    {
                                        if(player1) {
                                            EventPublisher.postEvent("End Game", "Game Ended! Won by: Player 1");
                                        }
                                        else EventPublisher.postEvent("End Game", "Game Ended! Won by: Player 2");
                                        GameBoard.setFrame(new EndGame());
//                                        new EndGame().setVisible(true);
                                    }
                                    else
                                    {
                                        // If board is being rendered for player 1, and it is player 1 is being attacked:
                                        if(player1)
                                        {
                                            GameBoard.iterateAttackingBoat(false);
                                            // Player 2 is attacking, so get the index of their boat that is currently attacking
                                            // If this is the last boat in the list, then:
                                            if(GameBoard.getPlayer2Board().getCurrentAttackingBoat() >= GameBoard.getPlayer2Board().getBoats().size())
                                            {
                                                //if all (unsunk) boats have attacked in the turn, we set attacking boat to 0
                                                //and load next player's board.
                                                GameBoard.resetAttackingBoat(true);
                                                GameBoard.addTurn();
                                                EventPublisher.postEvent("New Turn", "\nNew Turn: " + GameBoard.getTurn());
//                                                new PlayGame(player1).setVisible(true);
                                                GameBoard.setFrame(new PlayGame(player1));
                                            }
                                            else
                                            {
//                                                setCurrentAttackingBoat(getCurrentAttackingBoat() + 1);
                                                //check to make sure we aren't attacking with sunk boats.
                                                //GameBoard.iterateAttackingBoat(false);

//                                                new PlayGame(!player1).setVisible(true);
                                                GameBoard.setFrame(new PlayGame(!player1));
                                            }
                                        }
                                        else {
                                            GameBoard.iterateAttackingBoat(true);
                                            if(GameBoard.getPlayer1Board().getCurrentAttackingBoat() >= GameBoard.getPlayer1Board().getBoats().size())
                                            {
                                                //if all (unsunk) boats have attacked in the turn, we set attacking boat to 0
                                                //and load next player's board.
                                                GameBoard.resetAttackingBoat(false);
                                                GameBoard.addTurn();
                                                EventPublisher.postEvent("New Turn", "\nNew Turn: " + GameBoard.getTurn());

//                                                new PlayGame(player1).setVisible(true);
                                                GameBoard.setFrame(new PlayGame(player1));
                                            }

                                            else
                                            {
//                                                setCurrentAttackingBoat(getCurrentAttackingBoat() + 1);
                                                //check to make sure we aren't attacking with sunk boats.

//                                                new PlayGame(!player1).setVisible(true);
                                                GameBoard.setFrame(new PlayGame(!player1));
                                            }
                                        }
                                    }
                                }
                            }
                        });
                    }
//                    this.dispose();
                    board.add(boardSpace);

                } else {
                    JComponent boardSpace = new JLabel();
                    board.add(boardSpace);
                }
            }
            //boardPanel.add(this.state.get(i).get(j));
        }

        return board;
    }


    public int boatNotSet()
    {
        for(int i = 0; i  < this.getBoats().size(); i++)
        {
//            Integer index;
            if (this.getBoats().get(i).getPosition().equals( new ArrayList<Integer>(Arrays.asList(-1,-1))))
            {
                return i;
            }
        }
        return -1;
    }

    private JLabel createBoatLabel(Boat boat) {
        ImageIcon boatPic = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(boat.getHorImagePath())));
        JLabel boatImage = new JLabel(boatPic);
        boatImage.setVerticalAlignment(JLabel.TOP);
        boatImage.setHorizontalAlignment(JLabel.LEFT);
        boatImage.setBounds(100, 100, 200, 100);
        return boatImage;
    }
    //public abstract JPanel returnBoatOverlay();
    public void setBoats(ArrayList<Boat> boats) {
        this.boats = boats;
    }

    public ArrayList<Boat> getBoats() {
        return this.boats;
    }
    public void setBoatPosition(int i, ArrayList<Integer> position)
    {
        System.out.println("Setting in board");
        this.boats.get(i).setPosition(position);
        System.out.println("Set position to: " + this.getBoats().get(i).getPosition());
    }

    public boolean attackSpace(ArrayList<Integer> coordinates) {
        boolean hit = false;
        for (int i = 0; i < this.getBoats().size(); i++) {
            boolean temp = this.boats.get(i).checkHit(coordinates);
            //boolean temp = false;
            if (temp) {
                hit = true;
                // Update board
            }
            else {
                // Update board
            }
        }
        // Change color of space
        return hit;
    }


    public void setSquare(boolean miss, boolean hit, ArrayList<Integer> position)
    {
        if(miss)
        {
            System.out.println("Setting boat position " + position + " to miss");
            this.state.get(position.get(0)).get(position.get(1)).setMiss(true);
        }
        if(hit)
        {
            System.out.println("Setting boat position " + position + " to hit");
            this.state.get(position.get(0)).get(position.get(1)).setHit(true);

        }
    }

    public void checkSunkBoats(boolean player1)
    {
        for(int i = 0; i < this.boats.size(); i++)
        {
            //System.out.println("Checking sink status: Boat #" + i);
            this.boats.get(i).updateSunk(this.state, player1);
        }
    }

    public boolean checkEndState()
    {
        int numSunk = 0;

        for(int i = 0; i < this.boats.size(); i++)
        {
            if(this.boats.get(i).getSunk())
            {
                numSunk +=1;
            }
        }
        if(numSunk == this.boats.size())
        {
            return true;
        }
        else return false;
    }


    //BEN ADDED
    public ArrayList<ArrayList<Square>> getState() { return this.state;}

    public void setFleetType(boolean fleetType) {
        this.fleetType = fleetType;
    }

    public boolean getFleetType(){return this.fleetType;}

    public boolean checkValidPlacement(int boatNum, ArrayList<Integer> position) {
        boolean valid = true;
        ArrayList<ArrayList<Integer>> tempAllPositions = this.boats.get(boatNum).generateAllPositions(position);
        for (int i = 0; i < tempAllPositions.size(); i++) {

            // Check first to make sure position is in bounds of board
            if (tempAllPositions.get(i).get(0) >= 0 &
                    tempAllPositions.get(i).get(0) < this.state.size() &
                    tempAllPositions.get(i).get(1) >= 0 &
                    tempAllPositions.get(i).get(1) < this.state.get(0).size())
            {

                Square tempSquare = this.state.get(tempAllPositions.get(i).get(0)).get(tempAllPositions.get(i).get(1));
                // Now check if the square is a button, if it does then not valid
                if (!tempSquare.returnButton()) {
                    System.out.println("Placement is on illegal space on board!");
                    return false;
                }
                // Now check if square has boat in it, if it does then not valid
                if (tempSquare.checkForBoat(this.getBoats())) {
                    System.out.println("Placement is on space where boat already exists!");
                    return false;
                }
            }
            else {
                System.out.println("Placement has space outside of board!");
                return false;
            }
        }
        return valid;
    }

    public void setCurrentAttackingBoat(int boatNum)
    {
        this.currentAttackingBoat = boatNum;
    }

    public int getCurrentAttackingBoat()
    {
        return this.currentAttackingBoat;
    }

    public void iterateAttackingBoat()
    {
//        System.out.println("iterating player board");
        if(this.currentAttackingBoat < this.boats.size())
        {
            this.currentAttackingBoat++;
        }
        while(this.currentAttackingBoat < this.boats.size() && this.boats.get(this.currentAttackingBoat).getSunk())
        {
            System.out.println("entered iterate while loop");
            this.currentAttackingBoat++;
        }
        System.out.println("iterating attacking boat to " + this.currentAttackingBoat);
    }

    public void resetAttackingBoat()
    {
        //this.currentAttackingBoat = 0;
        int tempBoatNum = 0;
        //while((tempBoatNum < this.boats.size()) && (this.boats.get(tempBoatNum).getSunk()))
        while(this.boats.get(tempBoatNum).getSunk())
        {
            System.out.println("entered reset while loop");
            tempBoatNum++;
        }
        this.currentAttackingBoat = tempBoatNum;
        System.out.println("Reset attacking boat to " + this.currentAttackingBoat);
    }

    public int getMoneyBalance() {return this.money;}

    public void addMoney(int moneyAmt) {this.money = this.money + moneyAmt;}

    public void spendMoney(int moneyAmt) {this.money = this.money - moneyAmt;}
    public void upgradeBoat(int boatNum, boolean player1) {
        this.boats.get(boatNum).upgradeBoat(player1);
    }

    public String getBoardName()
    {
        return this.boardName;
    }

    public String getBoardDescription()
    {
        return this.boardDescription;
    }
}
