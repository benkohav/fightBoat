package fightboat.jframes;

import fightboat.GameBoard;
import fightboat.boats.*;
import fightboat.boards.Board;
import fightboat.observer.EventPublisher;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class PlaceFleet extends JFrame {

    public PlaceFleet(Boolean player1) {
        super("Fight Boat");
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(getClass().getResource("/fightboat/images/water4.jpg"));
            this.setContentPane(new BackgroundPanel(myImage));
        } catch (IOException e) {
            System.out.println("Error loading background image in BoardSelect");
        }
        this.setLayout(new BorderLayout());

        this.setLayout(new BorderLayout());
        JLabel topTitle = null;

//        JPanel leftSide = new JPanel();


        if (player1) {
            topTitle = new JLabel("Place Player 1 Fleet", SwingConstants.CENTER);
        }
        else {
            topTitle = new JLabel("Place Player 2 Fleet", SwingConstants.CENTER);
        }
        topTitle.setFont(new Font("name",1,30));

        ArrayList<Boat> boats = null;
        if (player1) {
            boats = GameBoard.getPlayer1Board().getBoats();
        }
        else {
            boats = GameBoard.getPlayer2Board().getBoats();
        }
        JPanel fleet = new PlaceFleetMenu().getPlaceFleetMenu(player1);

        fleet.setOpaque(false);

//        FleetDescription description = new FleetDescription(AttackFleet.getFleetBoats(),false);
        fleet.setPreferredSize(new Dimension(500,500));

//        leftSide.add(description,BorderLayout.CENTER);

        JLayeredPane board = null;
//        board.setOpaque(false);
        // currPlayer is false here because buttons can only be pressed if the board is not for the current player
        // The logic being when fighting, you can't click your own board
        if (player1) {
            board = GameBoard.getPlayer1Board().displayState2(false, true);
        }
        else {
            board = GameBoard.getPlayer2Board().displayState2(false, false);
        }
        board.setPreferredSize(new Dimension(500,500));

        JButton fleetSelectButton = new JButton("Finish Placement");
        fleetSelectButton.addActionListener(e -> {
            //String chosenFleet = (String)fleetSelectDropDown.getSelectedItem();
            if (player1)
            {
                //GameBoard.setPlayer1Fleet(chosenFleet);
//                this.dispose();
//                new PlaceFleet(false).setVisible(true);
                if (GameBoard.getPlayer1Board().boatNotSet() == -1) {
                    GameBoard.setFrame(new PlaceFleet(false));
                }
            }
            else {
                //GameBoard.setPlayer2Fleet(chosenFleet);
                //new PlaceFleet(true).setVisible(true);
                if (GameBoard.getPlayer2Board().boatNotSet() == -1) {
                    GameBoard.setGameState(2);

                    EventPublisher.postEvent("New Turn", "\nNew Turn: " + GameBoard.getTurn());

                    //                new PlayGame(true).setVisible(true);
                    //                this.dispose();
                    GameBoard.setFrame(new PlayGame(true));
                }

            }

        });
        this.add(fleetSelectButton,BorderLayout.PAGE_END);
        board.setOpaque(false);
        this.add(board, BorderLayout.LINE_END);
        this.add(topTitle, BorderLayout.PAGE_START);

        this.add(fleet, BorderLayout.CENTER);
//        this.add(leftSide, BorderLayout.CENTER);
//        this.add(description, BorderLayout.CENTER);

//        this.setVisible(true);

//        JButton startButton = new JButton("Start Game");
//        startButton.setFont(new FontUIResource("name",0,25));

//        startButton.setBounds(400,500, 200,80);
//        startButton.setPreferredSize(new Dimension(100,50));
//        this.add(startButton, BorderLayout.LINE_START);

//        this.add(startButton, BorderLayout.LINE_START);

//        JLabel label = new JLabel();
//        label.add(startButton);
//        this.add(label, BorderLayout.LINE_START);
//        this.setVisible(true);

//        this.pack();

//        startButton.addActionListener(e -> {new PlayGame().setVisible(true); this.dispose();});
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


}
