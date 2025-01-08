package fightboat.boards;

import fightboat.GameBoard;
import fightboat.boats.Boat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Square {

    private boolean isHit;
    private boolean isMiss;
    private boolean isButton;
    private ArrayList<Integer> position;

    public Square(boolean isButton, ArrayList<Integer> position)
    {
//        this.hasBoat = hasBoat;
        this.isHit = false;
        this.isMiss = false;
        this.isButton = isButton;
        this.position = position;
    }

    public JButton generatateButton(Boolean currPlayer, ArrayList<Boat> boats) {
        // First set background color of space
        JButton boardSpace = new JButton();
        switch (GameBoard.getGameState()) {
            case 0: {boardSpace.setBackground(this.getColor(false,new ArrayList<>())); break;}
            // Make !currPlayer for setup so that boats will display and buttons can be pressed
            case 1: {boardSpace.setBackground(this.getColor(!currPlayer, boats)); break;}
            case 2: {boardSpace.setBackground(this.getColor(currPlayer, boats)); break;}
        }

        // Next add image if there is a boat and the board is for the currently attacking player
        if ((GameBoard.getGameState()==1 && !currPlayer) || (GameBoard.getGameState()==2 && currPlayer)) {
            for (int i = 0; i < boats.size(); i++) {
                if (boats.get(i).checkHit(this.position)) {
                    try {
                        Image boatImage = ImageIO.read(getClass().getResource(boats.get(i).getSpaceImagePath(this.position)));
                        //System.out.println("Successfully loaded image");
                        boardSpace.setIcon(new ImageIcon(boatImage));
                    } catch (IOException e) {
                        System.out.println("Error loading image in square " + position + " for boat " + boats.get(i).getBoatName());
                    }
                }
            }
        }

        return boardSpace;
    }

    public Color getColor(boolean currPlayer, ArrayList<Boat> boats) {
        if (this.isHit) {
            return Color.RED;
        }
        else if (this.isMiss) {
            return Color.WHITE;
        }
        // Only display black if displaying the current player's board (currPlayer = true), ie don't display opponent boats
        //else if (currPlayer & this.checkForBoat(boats)) {
        //    return Color.BLACK;
        //}
        else if (!currPlayer & this.checkForBoat(boats)) {
            return Color.CYAN;
        }
        // Default color
        return Color.CYAN;
    }

    public boolean checkForBoat(ArrayList<Boat> boats) {
        for (int i = 0; i < boats.size(); i++) {
            if (boats.get(i).checkHit(this.position)) {
                return true;
            }
        }
        return false;
    }

    public boolean getHit()
    {
        return this.isHit;
    }
    public boolean getMiss()
    {
        return this.isMiss;
    }

    public boolean returnButton(){return isButton;}


    public void setHit(boolean isHit)
    {
        this.isHit = isHit;
    }

    public void setMiss(boolean isMiss)
    {
        this.isMiss = isMiss;
    }

}
