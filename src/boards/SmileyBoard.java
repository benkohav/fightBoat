package fightboat.boards;

import fightboat.boats.Boat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

public class SmileyBoard extends Board{

    public SmileyBoard() {
        super();
        this.state = initializeState();

        this.boardName = "Square Board";

        this.boardDescription = "Hac platea congue sociosqu rutrum euismod class fringilla posuere ac ad molestie etiam. Malesuada tellus penatibus suspendisse mollis platea luctus sociosqu eget. ";
//        this.displayState2();
    }


    @Override
    protected ArrayList<ArrayList<Square>> initializeState() {

        // Row 1
        ArrayList<Square> row1 = new ArrayList<>();
        row1.add(new Square(false, new ArrayList<>(Arrays.asList(0,0))));
        row1.add(new Square(false, new ArrayList<>(Arrays.asList(0,1))));
        row1.add(new Square(true, new ArrayList<>(Arrays.asList(0,2))));
        row1.add(new Square(true, new ArrayList<>(Arrays.asList(0,3))));
        row1.add(new Square(true, new ArrayList<>(Arrays.asList(0,4))));
        row1.add(new Square(true, new ArrayList<>(Arrays.asList(0,5))));
        row1.add(new Square(true, new ArrayList<>(Arrays.asList(0,6))));
        row1.add(new Square(true, new ArrayList<>(Arrays.asList(0,7))));
        row1.add(new Square(false, new ArrayList<>(Arrays.asList(0,8))));
        row1.add(new Square(false, new ArrayList<>(Arrays.asList(0,9))));

        // Row 2
        ArrayList<Square> row2 = new ArrayList<>();
        row2.add(new Square(false, new ArrayList<>(Arrays.asList(1,0))));
        row2.add(new Square(true, new ArrayList<>(Arrays.asList(1,1))));
        row2.add(new Square(true, new ArrayList<>(Arrays.asList(1,2))));
        row2.add(new Square(true, new ArrayList<>(Arrays.asList(1,3))));
        row2.add(new Square(true, new ArrayList<>(Arrays.asList(1,4))));
        row2.add(new Square(true, new ArrayList<>(Arrays.asList(1,5))));
        row2.add(new Square(true, new ArrayList<>(Arrays.asList(1,6))));
        row2.add(new Square(true, new ArrayList<>(Arrays.asList(1,7))));
        row2.add(new Square(true, new ArrayList<>(Arrays.asList(1,8))));
        row2.add(new Square(false, new ArrayList<>(Arrays.asList(1,9))));

        // Row 3
        ArrayList<Square> row3 = new ArrayList<>();
        row3.add(new Square(true, new ArrayList<>(Arrays.asList(2,0))));
        row3.add(new Square(true, new ArrayList<>(Arrays.asList(2,1))));
        row3.add(new Square(true, new ArrayList<>(Arrays.asList(2,2))));
        row3.add(new Square(false, new ArrayList<>(Arrays.asList(2,3))));
        row3.add(new Square(true, new ArrayList<>(Arrays.asList(2,4))));
        row3.add(new Square(true, new ArrayList<>(Arrays.asList(2,5))));
        row3.add(new Square(false, new ArrayList<>(Arrays.asList(2,6))));
        row3.add(new Square(true, new ArrayList<>(Arrays.asList(2,7))));
        row3.add(new Square(true, new ArrayList<>(Arrays.asList(2,8))));
        row3.add(new Square(true, new ArrayList<>(Arrays.asList(2,9))));

        // Row 4
        ArrayList<Square> row4 = new ArrayList<>();
        row4.add(new Square(true, new ArrayList<>(Arrays.asList(3,0))));
        row4.add(new Square(true, new ArrayList<>(Arrays.asList(3,1))));
        row4.add(new Square(true, new ArrayList<>(Arrays.asList(3,2))));
        row4.add(new Square(false, new ArrayList<>(Arrays.asList(3,3))));
        row4.add(new Square(true, new ArrayList<>(Arrays.asList(3,4))));
        row4.add(new Square(true, new ArrayList<>(Arrays.asList(3,5))));
        row4.add(new Square(false, new ArrayList<>(Arrays.asList(3,6))));
        row4.add(new Square(true, new ArrayList<>(Arrays.asList(3,7))));
        row4.add(new Square(true, new ArrayList<>(Arrays.asList(3,8))));
        row4.add(new Square(true, new ArrayList<>(Arrays.asList(3,9))));

        // Row 5
        ArrayList<Square> row5 = new ArrayList<>();
        row5.add(new Square(true, new ArrayList<>(Arrays.asList(4,0))));
        row5.add(new Square(true, new ArrayList<>(Arrays.asList(4,1))));
        row5.add(new Square(true, new ArrayList<>(Arrays.asList(4,2))));
        row5.add(new Square(true, new ArrayList<>(Arrays.asList(4,3))));
        row5.add(new Square(true, new ArrayList<>(Arrays.asList(4,4))));
        row5.add(new Square(true, new ArrayList<>(Arrays.asList(4,5))));
        row5.add(new Square(true, new ArrayList<>(Arrays.asList(4,6))));
        row5.add(new Square(true, new ArrayList<>(Arrays.asList(4,7))));
        row5.add(new Square(true, new ArrayList<>(Arrays.asList(4,8))));
        row5.add(new Square(true, new ArrayList<>(Arrays.asList(4,9))));

        // Row 6
        ArrayList<Square> row6 = new ArrayList<>();
        row6.add(new Square(true, new ArrayList<>(Arrays.asList(5,0))));
        row6.add(new Square(false, new ArrayList<>(Arrays.asList(5,1))));
        row6.add(new Square(true, new ArrayList<>(Arrays.asList(5,2))));
        row6.add(new Square(true, new ArrayList<>(Arrays.asList(5,3))));
        row6.add(new Square(true, new ArrayList<>(Arrays.asList(5,4))));
        row6.add(new Square(true, new ArrayList<>(Arrays.asList(5,5))));
        row6.add(new Square(true, new ArrayList<>(Arrays.asList(5,6))));
        row6.add(new Square(true, new ArrayList<>(Arrays.asList(5,7))));
        row6.add(new Square(false, new ArrayList<>(Arrays.asList(5,8))));
        row6.add(new Square(true, new ArrayList<>(Arrays.asList(5,9))));

        // Row 7
        ArrayList<Square> row7 = new ArrayList<>();
        row7.add(new Square(true, new ArrayList<>(Arrays.asList(6,0))));
        row7.add(new Square(true, new ArrayList<>(Arrays.asList(6,1))));
        row7.add(new Square(false, new ArrayList<>(Arrays.asList(6,2))));
        row7.add(new Square(true, new ArrayList<>(Arrays.asList(6,3))));
        row7.add(new Square(true, new ArrayList<>(Arrays.asList(6,4))));
        row7.add(new Square(true, new ArrayList<>(Arrays.asList(6,5))));
        row7.add(new Square(true, new ArrayList<>(Arrays.asList(6,6))));
        row7.add(new Square(false, new ArrayList<>(Arrays.asList(6,7))));
        row7.add(new Square(true, new ArrayList<>(Arrays.asList(6,8))));
        row7.add(new Square(true, new ArrayList<>(Arrays.asList(6,9))));

        // Row 8
        ArrayList<Square> row8 = new ArrayList<>();
        row8.add(new Square(true, new ArrayList<>(Arrays.asList(7,0))));
        row8.add(new Square(true, new ArrayList<>(Arrays.asList(7,1))));
        row8.add(new Square(true, new ArrayList<>(Arrays.asList(7,2))));
        row8.add(new Square(false, new ArrayList<>(Arrays.asList(7,3))));
        row8.add(new Square(false, new ArrayList<>(Arrays.asList(7,4))));
        row8.add(new Square(false, new ArrayList<>(Arrays.asList(7,5))));
        row8.add(new Square(false, new ArrayList<>(Arrays.asList(7,6))));
        row8.add(new Square(true, new ArrayList<>(Arrays.asList(7,7))));
        row8.add(new Square(true, new ArrayList<>(Arrays.asList(7,8))));
        row8.add(new Square(true, new ArrayList<>(Arrays.asList(7,9))));

        // Row 9
        ArrayList<Square> row9 = new ArrayList<>();
        row9.add(new Square(false, new ArrayList<>(Arrays.asList(8,0))));
        row9.add(new Square(true, new ArrayList<>(Arrays.asList(8,1))));
        row9.add(new Square(true, new ArrayList<>(Arrays.asList(8,2))));
        row9.add(new Square(true, new ArrayList<>(Arrays.asList(8,3))));
        row9.add(new Square(true, new ArrayList<>(Arrays.asList(8,4))));
        row9.add(new Square(true, new ArrayList<>(Arrays.asList(8,5))));
        row9.add(new Square(true, new ArrayList<>(Arrays.asList(8,6))));
        row9.add(new Square(true, new ArrayList<>(Arrays.asList(8,7))));
        row9.add(new Square(true, new ArrayList<>(Arrays.asList(8,8))));
        row9.add(new Square(false, new ArrayList<>(Arrays.asList(8,9))));

        // Row 10
        ArrayList<Square> row10 = new ArrayList<>();
        row10.add(new Square(false, new ArrayList<>(Arrays.asList(9,0))));
        row10.add(new Square(false, new ArrayList<>(Arrays.asList(9,1))));
        row10.add(new Square(true, new ArrayList<>(Arrays.asList(9,2))));
        row10.add(new Square(true, new ArrayList<>(Arrays.asList(9,3))));
        row10.add(new Square(true, new ArrayList<>(Arrays.asList(9,4))));
        row10.add(new Square(true, new ArrayList<>(Arrays.asList(9,5))));
        row10.add(new Square(true, new ArrayList<>(Arrays.asList(9,6))));
        row10.add(new Square(true, new ArrayList<>(Arrays.asList(9,7))));
        row10.add(new Square(false, new ArrayList<>(Arrays.asList(9,8))));
        row10.add(new Square(false, new ArrayList<>(Arrays.asList(9,9))));

        ArrayList<ArrayList<Square>> finalArray = new ArrayList<>();
        finalArray.add(row1);
        finalArray.add(row2);
        finalArray.add(row3);
        finalArray.add(row4);
        finalArray.add(row5);
        finalArray.add(row6);
        finalArray.add(row7);
        finalArray.add(row8);
        finalArray.add(row9);
        finalArray.add(row10);

//        for (int i = 0; i < finalArray.size(); i++) {
//            for (int j = 0; j < finalArray.get(1).size(); j++) {
//                if (finalArray.get(i).get(j) instanceof JButton) {
//                    JButton boardSpace = new JButton();
//                    boardSpace.setBackground(Color.BLUE);
//                    boardSpace.addActionListener(e -> {
//                        // Put actions of button here
//                        boardSpace.setBackground(Color.RED);
//                    });
//                    finalArray.get(i).set(j,boardSpace);
//                }
//            }
//        }
//        return null;
        return finalArray;
        //for (int i = 0;)


    }

    //@Override
    public JPanel returnBoatOverlay() {
        JPanel boatOverlay = new JPanel();
        boatOverlay.setLayout(new BorderLayout());
        for (int i = 0; i < this.boats.size(); i++) {
            if (this.boats.get(i).getPosition() != null) {
                JLabel boatImage = new JLabel();
                try {
                    Image boatPic = ImageIO.read(getClass().getResource(this.boats.get(i).getHorImagePath()));
                    boatImage.setIcon(new ImageIcon(boatPic));
                    boatImage.setBounds(this.boats.get(i).getPosition().get(0), this.boats.get(i).getPosition().get(1),boatPic.getWidth(null)*50,boatPic.getHeight(null)*50);
                }
                catch(IOException e) {
                    System.out.println("Error loading image in boat overlay for boat " + this.boats.get(i).getBoatName());
                }
            }
        }

        return boatOverlay;
    }

}
