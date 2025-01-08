package fightboat.jframes;

import fightboat.GameBoard;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainMenu extends JFrame {
    public MainMenu() {
        super("Fight Boat");

        this.setSize(1025,705);
        this.setLocationRelativeTo(null);

        ImageIcon background = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/fightboat/images/FightBoat1000.jpg")));
        JLabel label = new JLabel(background);

        JButton startButton = new JButton("Start Game");
        startButton.setBounds(400,500, 200,80);
        startButton.setFont(new FontUIResource("name",0,25));

        startButton.addActionListener(e ->
        {
//            new BoardSelect().setVisible(true); this.dispose();
            GameBoard.setFrame(new BoardSelect());
        });

//        startButton.addActionListener(e -> {new PlaceFleet(true).setVisible(true); this.dispose();});

        label.add(startButton);
        this.add(label);
        this.setVisible(true);
    }

    public void runDispose() {
        this.dispose();
    }
}
