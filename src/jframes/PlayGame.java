package fightboat.jframes;

import fightboat.GameBoard;
import fightboat.boards.*;
import fightboat.boats.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class PlayGame extends JFrame {

    // player1 is who's turn it is to attack, true = player1, false = player2
    public PlayGame(boolean player1) {
        super();
        try {
            BufferedImage myImage = ImageIO.read(getClass().getResource("/fightboat/images/water4.jpg"));
            this.setContentPane(new BackgroundPanel(myImage));
        } catch (IOException e) {
            System.out.println("Error loading background image in PlayGame");
        }

        this.setLayout(new BorderLayout());

        JPanel middleMenu = new MiddleMenu().getMiddleMenu(player1);
        middleMenu.setOpaque(false);
        middleMenu.setPreferredSize(new Dimension(250,500));

        this.add(middleMenu, BorderLayout.CENTER);

        JPanel topDisplay = new JPanel(new BorderLayout());
        topDisplay.setOpaque(false);
        JLabel topTitle;
        JLabel balanceDisplay;
        JLabel boardIdentifiers;
        int playerBalance;
        if (player1) {
            System.out.println("Player 1 turn");

            topTitle = new JLabel("Player 1 Turn", SwingConstants.CENTER);
            // Customize Title
            topTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

            playerBalance = GameBoard.getPlayer1Board().getMoneyBalance();
            balanceDisplay = new JLabel("Money Balance: " + playerBalance, SwingConstants.CENTER);
            balanceDisplay.setFont(new Font("Tahoma", Font.BOLD, 20));

            boardIdentifiers = new JLabel("                                  Player                                                                                                                   Opponent");
            boardIdentifiers.setFont(new Font("Tahoma", Font.BOLD, 20));

            //System.out.println("Getting board 1");
            this.add(GameBoard.getPlayer1Board().displayState2(true, true), BorderLayout.LINE_START);
            //System.out.println("Getting board 2");
            this.add(GameBoard.getPlayer2Board().displayState2(false, false), BorderLayout.LINE_END);
        }
        else {
            System.out.println("Player 2 turn");

            topTitle = new JLabel("Player 2 Turn", SwingConstants.CENTER);
            // Customize Title
            topTitle.setFont(new Font("Tahoma", Font.BOLD, 30));

            playerBalance = GameBoard.getPlayer2Board().getMoneyBalance();
            balanceDisplay = new JLabel("Money Balance: " + playerBalance, SwingConstants.CENTER);
            balanceDisplay.setFont(new Font("Tahoma", Font.BOLD, 20));

            boardIdentifiers = new JLabel("                                    Opponent                                                                                                             Player");
            boardIdentifiers.setFont(new Font("Tahoma", Font.BOLD, 20));

            //System.out.println("Getting board 1");
            this.add(GameBoard.getPlayer1Board().displayState2(false, true), BorderLayout.LINE_START);
            //System.out.println("Getting board 2");
            this.add(GameBoard.getPlayer2Board().displayState2(true, false), BorderLayout.LINE_END);
        }

        topDisplay.add(topTitle, BorderLayout.PAGE_START);
        topDisplay.add(balanceDisplay, BorderLayout.CENTER);
        topDisplay.add(boardIdentifiers, BorderLayout.PAGE_END);

        //this.add(p1BoatOverlay, BorderLayout.LINE_START);
        //this.add(p2BoatOverlay, BorderLayout.LINE_END);
        this.add(topDisplay, BorderLayout.PAGE_START);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
