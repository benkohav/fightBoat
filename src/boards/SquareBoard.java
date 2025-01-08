package fightboat.boards;

import fightboat.GameBoard;
import fightboat.boats.Boat;
import fightboat.jframes.FleetSelect;
import fightboat.jframes.PlayGame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import javax.imageio.ImageIO;

public class SquareBoard extends Board{

    int size;
    public SquareBoard(int size) {
        super();
        this.size = size;
        this.state = this.initializeState();
//        this.boardStorePlayer1 = this.initializeState();

        this.boardName = "Square Board";

        this.boardDescription = "Hac platea congue sociosqu rutrum euismod class fringilla posuere ac ad molestie etiam. Malesuada tellus penatibus suspendisse mollis platea luctus sociosqu eget. ";
//
//        this.displayState2();
    }

    //@Override
    public JPanel returnBoatOverlay() {
        JPanel boatOverlay = new JPanel();
        boatOverlay.setLayout(new BorderLayout());
        for (int i = 0; i < this.boats.size(); i++) {
            if (this.boats.get(i).getPosition() != null) {
                ImageIcon boatPic = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(this.boats.get(i).getHorImagePath())));
                JLabel boatImage = new JLabel(boatPic);
                boatImage.setBounds(this.boats.get(i).getPosition().get(0), this.boats.get(i).getPosition().get(1),50,50);

                //try {
                    //Image boatPic = ImageIO.read(getClass().getResource(this.boats.get(i).getImagePath()));
                    //boatImage.setIcon(new ImageIcon(boatPic));
                    //boatImage.setBounds(this.boats.get(i).getPosition().get(0), this.boats.get(i).getPosition().get(1),boatPic.getWidth(null)*50,boatPic.getHeight(null)*50);

                //}
                //catch(IOException e) {
                //    System.out.println("Error loading image in boat overlay for boat " + this.boats.get(i).getBoatName());
                //}
                boatOverlay.add(boatImage);
            }
        }

        return boatOverlay;
    }

    @Override
    protected ArrayList<ArrayList<Square>> initializeState() {
        ArrayList<ArrayList<Square>> finalState = new ArrayList<>();

//        BEN ADDED
        this.boats = new ArrayList<Boat>();
//        this.getBoats().add();
        for (int i=0; i < this.size; i++) {
            ArrayList<Square> row = new ArrayList<>();
            for (int j=0; j < this.size; j++)
            {

                Square boardSpace = new Square(true, new ArrayList<>(Arrays.asList(i,j)));
//               boardSpace.setBackground(Color.BLUE);

                row.add(boardSpace);
            }
            finalState.add(row);
        }
        return finalState;
    }

}
