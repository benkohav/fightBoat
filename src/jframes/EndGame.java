package fightboat.jframes;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.util.Objects;

public class EndGame extends JFrame {
    public EndGame() {
        super("Fight Boat");

        this.setSize(1025, 705);
        this.setLocationRelativeTo(null);

        ImageIcon background = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/fightboat/images/FightBoat2000.jpg")));
        JLabel label = new JLabel(background);

        JButton startButton = new JButton("New Game?");
        startButton.setBounds(400, 500, 200, 80);
        startButton.setFont(new FontUIResource("name", 0, 25));

        startButton.addActionListener(e -> {
            new MainMenu().setVisible(true);
            this.dispose();
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
