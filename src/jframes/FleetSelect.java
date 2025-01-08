package fightboat.jframes;

import fightboat.GameBoard;
import fightboat.boards.*;
import fightboat.boats.*;
import fightboat.observer.EventPublisher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FleetSelect extends JFrame {
    public FleetSelect(boolean player1) {
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
        if (player1) {
            topTitle = new JLabel("Select Player 1 Fleet", SwingConstants.CENTER);
        }
        else {
            topTitle = new JLabel("Select Player 2 Fleet", SwingConstants.CENTER);
        }
        // Customize title
        topTitle.setFont(new Font("name",1,30));

        JPanel leftSide = new JPanel();
        leftSide.setPreferredSize(new Dimension(700,500));
//        leftSide.setBorder(BorderFactory.createLineBorder(Color.black));
        leftSide.setOpaque(false);


        // By default display Attack Fleet
        FleetDisplay fleet = new AttackFleet(0);

        fleet.setPreferredSize(new Dimension(300,500));
//        fleet.setBorder(BorderFactory.createLineBorder(Color.black));

        FleetDescription description = new FleetDescription(AttackFleet.getFleetBoats(),true);
//        description.setOpaque(false);

        JComboBox fleetSelectDropDown = new JComboBox(new String[]{"Attack Fleet", "Economic Fleet", "Small But Mighty Fleet"});
        fleetSelectDropDown.addActionListener(e -> {
            String boardString = (String) fleetSelectDropDown.getSelectedItem();
            FleetDisplay newFleet = null;

            FleetDescription describe = null;

//            leftSide.add(describe,BorderLayout.CENTER);
            switch (boardString) {
                case "Attack Fleet":
                    newFleet = new AttackFleet(0);
//                    describe = new FleetDescription(AttackFleet.getFleetBoats(),0);
//                    EventPublisher.postEvent("Choose Fleet", "Attack Fleet selected");
                    break;
                case "Economic Fleet":
                    newFleet = new EconomicFleet(0);
//                    describe = new FleetDescription(EconomicFleet.getFleetBoats(),0);
//                    EventPublisher.postEvent("Choose Fleet", "Economic Fleet selected");
                    break;
                case "Small But Mighty Fleet":
                    newFleet = new SmallButMightyFleet(0);
//                    describe = new FleetDescription(SmallButMightyFleet.getFleetBoats(),0);
//                    EventPublisher.postEvent("Choose Fleet", "Economic Fleet selected");
                    break;
            }
            newFleet.setPreferredSize(new Dimension(300, 500));
//            newFleet.setBorder(BorderFactory.createLineBorder(Color.black));

//            leftSide.add(describe,BorderLayout.CENTER);

//            this.getContentPane().remove(1);
//            this.add(leftSide, BorderLayout.CENTER);
//            System.out.println(getContentPane());
            this.getContentPane().remove(2);
//            this.getContentPane().remove(1);
//            this.add(leftSide, BorderLayout.CENTER);

            newFleet.setOpaque(false);
            this.add(newFleet, BorderLayout.CENTER);
            this.pack();
            this.setVisible(true);
        });
        leftSide.add(fleetSelectDropDown,BorderLayout.CENTER);

//        FleetDescription describe = new FleetDescription(AttackFleet.getFleetBoats(),0);
//
//        leftSide.add(description,BorderLayout.CENTER);

        JButton fleetSelectButton = new JButton("Choose Fleet");
        fleetSelectButton.addActionListener(e -> {
            String chosenFleet = (String)fleetSelectDropDown.getSelectedItem();
            if (player1) {
                GameBoard.setPlayer1Fleet(chosenFleet);
                EventPublisher.postEvent("Choose Fleet", "Player 1 has " + chosenFleet + " selected");
//                new FleetSelect(false).setVisible(true);
                GameBoard.setFrame(new FleetSelect(false));
            }
            else {
                GameBoard.setPlayer2Fleet(chosenFleet);
                EventPublisher.postEvent("Choose Fleet", "Player 2 has " + chosenFleet + " selected");
                //new PlaceFleet(true).setVisible(true);
                GameBoard.setGameState(1);
//                new PlaceFleet(true).setVisible(true);
                GameBoard.setFrame(new PlaceFleet(true));
            }
            this.dispose();
        });
        leftSide.add(fleetSelectButton);

        leftSide.add(description,BorderLayout.CENTER);
        fleet.setOpaque(false);

        this.add(topTitle,BorderLayout.PAGE_START);
        this.add(leftSide, BorderLayout.LINE_START);
        this.add(fleet, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
