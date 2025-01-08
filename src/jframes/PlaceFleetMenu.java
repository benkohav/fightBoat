package fightboat.jframes;

import fightboat.GameBoard;
import fightboat.boats.Boat;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PlaceFleetMenu {


    public JPanel getPlaceFleetMenu(boolean player1) {
        JPanel placeFleetMenu = new JPanel();
        placeFleetMenu.setLayout(new BorderLayout());

        Boat currentBoat = null;
        int boatIndex;
        if (player1) {
            boatIndex = GameBoard.getPlayer1Board().boatNotSet();
            if (boatIndex != -1) {
                currentBoat = GameBoard.getPlayer1Board().getBoats().get(boatIndex);
            }
        }
        else {
            boatIndex = GameBoard.getPlayer2Board().boatNotSet();
            if (boatIndex != -1) {
                currentBoat = GameBoard.getPlayer2Board().getBoats().get(boatIndex);
            }
        }

        if (boatIndex == -1) {
            JLabel allBoatsPlaced = new JLabel("All Boats Placed!", SwingConstants.CENTER);
            allBoatsPlaced.setFont(new Font("name",Font.BOLD, 20));
            placeFleetMenu.add(allBoatsPlaced, BorderLayout.PAGE_START);
            placeFleetMenu.add(Box.createRigidArea(new Dimension(100,100)), BorderLayout.CENTER);
        }
        else {
            JPanel boatInfo = new JPanel();
            boatInfo.setLayout(new BorderLayout());
            JLabel boatNameLabel = new JLabel("Now placing: " + currentBoat.getBoatName(), SwingConstants.CENTER);
            boatNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
            ImageIcon boatImage = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(currentBoat.getGridImagePath(true))));
            JLabel boatImageLabel = new JLabel(boatImage);
            String boatDescription = currentBoat.getBoatDescription();
            boatDescription = "<html><body>" + "<p>" + boatDescription;
            JLabel boatDescriptionLabel = new JLabel(boatDescription);
            boatDescriptionLabel.setBorder(BorderFactory.createEmptyBorder(10,25,10,25));

            boatInfo.add(boatNameLabel, BorderLayout.PAGE_START);
            boatInfo.add(boatImageLabel, BorderLayout.CENTER);
            boatInfo.add(boatDescriptionLabel, BorderLayout.PAGE_END);

            placeFleetMenu.add(boatInfo, BorderLayout.PAGE_START);
            placeFleetMenu.add(Box.createRigidArea(new Dimension(100,100)), BorderLayout.CENTER);
        }

        return placeFleetMenu;
    }
}
