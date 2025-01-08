package fightboat.jframes;

import fightboat.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.SimpleTimeZone;

public class MiddleMenu {

    public MiddleMenu() {

    }

    public JPanel getMiddleMenu(Boolean player1){
        int attackingBoat;
        String boatDescription;
        String boatName;
        int upgradeCost;
        ImageIcon boatImage;
        ImageIcon attackImage = null;
        ImageIcon attackUpgradeImage = null;
        if (player1) {
            attackingBoat = GameBoard.getPlayer1Board().getCurrentAttackingBoat();
            boatName = GameBoard.getPlayer1Board().getBoats().get(attackingBoat).getBoatName();
            upgradeCost = GameBoard.getPlayer1Board().getBoats().get(GameBoard.getPlayer1Board().getCurrentAttackingBoat()).getUpgradeCost();
            if (upgradeCost == -1) {
                boatDescription = "No upgrades are available for this " + boatName;
            }
            else boatDescription = GameBoard.getPlayer1Board().getBoats().get(attackingBoat).getBoatUpgradeDescribe();
            boatImage = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(GameBoard.getPlayer1Board().getBoats().get(attackingBoat).getHorImagePath())));
            attackImage = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(GameBoard.getPlayer1Board().getBoats().get(attackingBoat).getAttackImage())));
            attackUpgradeImage = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(GameBoard.getPlayer1Board().getBoats().get(attackingBoat).getUpgradeImage())));
        }
        else {
            attackingBoat = GameBoard.getPlayer2Board().getCurrentAttackingBoat();
            boatName = GameBoard.getPlayer2Board().getBoats().get(attackingBoat).getBoatName();
            upgradeCost = GameBoard.getPlayer2Board().getBoats().get(GameBoard.getPlayer2Board().getCurrentAttackingBoat()).getUpgradeCost();
            if (upgradeCost == -1) {
                boatDescription = "No upgrades are available for this " + boatName + "!";
            }
            else boatDescription = GameBoard.getPlayer2Board().getBoats().get(attackingBoat).getBoatUpgradeDescribe();
            boatImage = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(GameBoard.getPlayer2Board().getBoats().get(attackingBoat).getHorImagePath())));
            attackImage = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(GameBoard.getPlayer2Board().getBoats().get(attackingBoat).getAttackImage())));
            attackUpgradeImage = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(GameBoard.getPlayer2Board().getBoats().get(attackingBoat).getUpgradeImage())));
        }

        JPanel menu = new JPanel();
        menu.setLayout(new BorderLayout());

        JPanel boatInfo = new JPanel();
        JLabel boatNameLabel = new JLabel("Now attacking: " + boatName, SwingConstants.CENTER);
        boatNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        boatInfo.setLayout(new BorderLayout());
        JLabel boatImageLabel = new JLabel(boatImage);
        boatDescription = "<html><body>"
                + "<p>" + boatDescription;
        JLabel boatDescriptionLabel = new JLabel(String.format(boatDescription,40,40), SwingConstants.CENTER);
        boatDescriptionLabel.setBorder(BorderFactory.createEmptyBorder(10,15,0,0));
        boatInfo.add(boatNameLabel, BorderLayout.PAGE_START);
        boatInfo.add(boatImageLabel, BorderLayout.CENTER);
        boatInfo.add(boatDescriptionLabel, BorderLayout.PAGE_END);
        menu.add(boatInfo, BorderLayout.PAGE_START);

        JPanel upgradeInfoHolder = new JPanel();
        upgradeInfoHolder.setLayout(new BoxLayout(upgradeInfoHolder,BoxLayout.Y_AXIS));
        JPanel upgradeInfo = new JPanel();
        upgradeInfo.setLayout(new BorderLayout());
        //upgradeInfo.add(Box.createVerticalGlue());
        JLabel upgradeTitle = new JLabel("Upgrade Boat:", SwingConstants.CENTER);
        upgradeTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
        JLabel attackImageDisplay = new JLabel(attackImage);
        attackImageDisplay.setPreferredSize(new Dimension(100,100));
        JLabel middleArrow = new JLabel(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/fightboat/images/Arrow.png"))));
        middleArrow.setPreferredSize(new Dimension(50,100));
        JLabel upgradedAttackImageDisplay = new JLabel(attackUpgradeImage);
        upgradedAttackImageDisplay.setPreferredSize(new Dimension(100,100));
        JButton upgradeButton;
        if (upgradeCost == -1) {
            upgradeButton = new JButton("No upgrade available!");
        }
        else {
            upgradeButton = new JButton("Click to upgrade for Cost: " + upgradeCost);
            upgradeButton.setSize(20,10);
            upgradeButton.addActionListener(e -> {
                // upgradeBoat() handles if the player does not have enough money or if the boat is already max level
                GameBoard.upgradeBoat(player1, attackingBoat);
//                GameBoard.getPlayer1Board().getBoats().get(attackingBoat).setBoatUpgradeDescribe("No upgrades");
                GameBoard.setFrame(new PlayGame(player1));
            });
        }
        upgradeInfo.add(upgradeTitle, BorderLayout.PAGE_START);
        upgradeInfo.add(attackImageDisplay, BorderLayout.LINE_START);
        upgradeInfo.add(middleArrow, BorderLayout.CENTER);
        upgradeInfo.add(upgradedAttackImageDisplay, BorderLayout.LINE_END);
        upgradeInfo.add(upgradeButton, BorderLayout.PAGE_END);

        upgradeInfoHolder.add(Box.createRigidArea(new Dimension(100,60)));
        upgradeInfoHolder.add(upgradeInfo);

        JLabel hitKey = new JLabel(new ImageIcon(Objects.requireNonNull(this.getClass().getResource("/fightboat/images/gameMenu2.jpg"))));

        boatInfo.setOpaque(false);
        upgradeInfoHolder.setOpaque(false);
        upgradeInfo.setOpaque(false);
        menu.add(boatInfo, BorderLayout.PAGE_START);
        //menu.add(Box.createVerticalGlue());
        menu.add(upgradeInfoHolder, BorderLayout.CENTER);
        //menu.add(Box.createVerticalGlue());
        menu.add(hitKey, BorderLayout.PAGE_END);

        return menu;
    }
}
