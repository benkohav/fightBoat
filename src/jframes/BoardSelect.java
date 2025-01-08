package fightboat.jframes;
import javax.imageio.ImageIO;
import javax.swing.*;
import fightboat.boards.*;
import fightboat.GameBoard;
import fightboat.observer.EventPublisher;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class BoardSelect extends JFrame{
    public BoardSelect() {
        super("Fight Boat");
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(getClass().getResource("/fightboat/images/water4.jpg"));
            this.setContentPane(new BackgroundPanel(myImage));
        } catch (IOException e) {
            System.out.println("Error loading background image in BoardSelect");
        }
        this.setLayout(new BorderLayout());
        //this.setSize(1025,705);



        JLabel topTitle = new JLabel("Select Board", SwingConstants.CENTER);
        // Customize Title
        topTitle.setFont(new Font("name",1,30));

        //ImageIcon leftSideBackground = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/fightboat/images/water3.jpg")));
        //JLabel leftSide = new JLabel(leftSideBackground);
        JPanel leftSide = new JPanel();
        //leftSide.setLayout(new BorderLayout());
        leftSide.setPreferredSize(new Dimension(500,500));
//        leftSide.setBorder(BorderFactory.createLineBorder(Color.black));
        leftSide.setOpaque(false);

        JLayeredPane board = new SquareBoard(10).displayState2(true,true);
        board.setPreferredSize(new Dimension(500,500));
//        board.setBorder(BorderFactory.createLineBorder(Color.black));

        JComboBox boardSelectDropDown = new JComboBox(new String[]{"Square Board", "Smiley Board", "Diamond Board", "Donut Board"});
        boardSelectDropDown.addActionListener(e -> {
            String boardString = (String)boardSelectDropDown.getSelectedItem();
            JLayeredPane newBoard = null;
            switch (boardString) {
                case "Square Board":
                    newBoard = new SquareBoard(10).displayState2(true,true); break;
                case "Smiley Board":
                    newBoard = new SmileyBoard().displayState2(true,true); break;
                case "Diamond Board":
                    newBoard = new DiamondBoard().displayState2(true,true); break;
                case "Donut Board":
                    newBoard = new DonutBoard().displayState2(true,true); break;
            }
            newBoard.setPreferredSize(new Dimension(500,500));
//            newBoard.setBorder(BorderFactory.createLineBorder(Color.black));

            // Need to find a way here to remove the already existing pane but only that
            // This is pretty hard coded, will need to change if more elements are added to this frame
            // (More within leftSide is fine)
            this.getContentPane().remove(2);
            this.add(newBoard, BorderLayout.CENTER);
            this.pack();
            this.setVisible(true);
        });
        leftSide.add(boardSelectDropDown,BorderLayout.CENTER);

        JButton boardSelectButton = new JButton("Choose Board");
        boardSelectButton.addActionListener(e -> {
            String chosenBoard = (String)boardSelectDropDown.getSelectedItem();
            GameBoard.setBoard(chosenBoard);
            EventPublisher.postEvent("Choose Board", chosenBoard  + " selected for the game");

//            new FleetSelect(true).setVisible(true);
//            this.dispose();
            GameBoard.setFrame(new FleetSelect(true));
        });
        leftSide.add(boardSelectButton, BorderLayout.PAGE_END);

        // Left side MUST be added before board to make board index 1
        this.add(topTitle, BorderLayout.PAGE_START);
        this.add(leftSide, BorderLayout.LINE_START);
        this.add(board, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
