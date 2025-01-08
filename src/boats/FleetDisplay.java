package fightboat.boats;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class FleetDisplay extends JPanel {

    ArrayList<Boat> boats;
    String fleetName;

    // function:
    // 0 = no button function
    // 1 = buttons work for placement
    // 2 = buttons work for fighting
    protected FleetDisplay(ArrayList<Boat> boats, int function, boolean inPlay, String fleetName) {
        this.fleetName = fleetName;
        this.boats = boats;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel fleetNameLabel = new JLabel(fleetName + ":");
        fleetNameLabel.setFont(new Font("name",Font.BOLD, 20));
        this.add(fleetNameLabel);
        // Add all boats to
        for (int i = 0; i < this.boats.size(); i++) {
            this.add(Box.createRigidArea(new Dimension(10,4)));
            this.addBoat(this.boats.get(i), function);
        }
        //ADD LABEL WITH KEY MAP to Image file.

        if(inPlay) {
            ImageIcon background = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/fightboat/images/gameMenu2.jpg")));
            JLabel label = new JLabel(background);
            label.setSize(30, 30);
            this.add(label);
        }

        this.setVisible(true);
    }

    protected void addBoat(Boat boat, int function) {
        //JButton boatButton = new JButton();
        ImageIcon boatGridImage = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(boat.getGridImagePath(true))));
        JLabel boatButton = new JLabel(boatGridImage);
        JLabel boatNameLabel = new JLabel(boat.boatName);
        //boatButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        //try {
//            Image boatImage = ImageIO.read(getClass().getResource(boat.getGridImagePath(true)));
//            boatButton.setIcon(new ImageIcon(boatImage));
//        }
//        catch (IOException e) {
//            System.out.println("Error loading image in AttackFleet for boat " + boat.getBoatName());
//        }

        // No case for 0 because no additional code
        switch (function) {
            case 1: {
                break;
            }
            case 2: {
                int i = 0;
                break;
            }
        }
        // Add information tab on click here

        //boatButton.setBackground(Color.BLUE);
        this.add(boatNameLabel);
        this.add(boatButton);
    }

}
