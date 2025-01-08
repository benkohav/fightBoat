package fightboat.boats;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class FleetDescription extends JPanel {

    ArrayList<Boat> boats = new ArrayList<>();

    // function:
    // 0 = no button function
    // 1 = buttons work for placement
    // 2 = buttons work for fighting
    public FleetDescription(ArrayList<Boat> FleetBoats, boolean isGeneral)
    {

        if(!isGeneral) {
            this.boats = FleetBoats;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            for (int i = 0; i < this.boats.size(); i++) {
                this.addBoat(this.boats.get(i));
            }
        }
        else
        {
            ArrayList<Boat> boats = new ArrayList<Boat>();
            boats.add(new AircraftCarrier());
            boats.add(new Battleship());
            boats.add(new ContainerShip());
            boats.add(new Destroyer());
            boats.add(new PatrolBoat());

            this.boats = boats;

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            for (int i = 0; i < this.boats.size(); i++) {
                this.addBoat(this.boats.get(i));
            }
        }
        //ADD LABEL WITH KEY MAP to Image file.

//        this.pack();

        this.setVisible(true);
    }


    protected void addBoat(Boat boat) {

        String html = "<html><body width='%1s'><h3>"
                + boat.getBoatName() + "</h3>"
                + "<p>" + boat.getBoatDescription();
        // change to alter the width
        int w = 700;
        JLabel boatDescript = new JLabel(String.format(html,w,w));
//        J
//        boatDescript.set(true);
        boatDescript.setAlignmentX(Component.LEFT_ALIGNMENT);

        boatDescript.setSize(500,30);



//        boatDescript.setText("<html>"  + boat.getBoatName() + " "  + boat.getBoatDescription() + "</html>" );
        boatDescript.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Add information tab on click here

//        boatButton.setBackground(Color.BLUE);
        this.add(boatDescript);
    }

}
