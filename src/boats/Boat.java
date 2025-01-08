package fightboat.boats;
import fightboat.boards.*;
import fightboat.actions.*;
import fightboat.observer.EventPublisher;

import javax.swing.*;
import java.util.*;

public abstract class Boat {

    protected String boatName;

    protected String boatDescription;

    protected String boatUpgradeDescribe;
    protected String horImagePath = null;
    protected String vertImagePath = null;

    protected String horGridImage = null;

    protected String vertGridImage = null;

    protected ArrayList<GameAction> actions;
    protected ArrayList<Integer> upgradeCosts;
    protected int boatLevel = 0;

    ArrayList<Integer> rootPosition = new ArrayList<>(Arrays.asList(-1,-1));
    ArrayList<ArrayList<Integer>> allPositions = new ArrayList<>();
    ArrayList<ArrayList<String>> shape;
    boolean isSunk = false;
    boolean fullyUpgraded = false;

    public Boat(String boatName, ArrayList<GameAction> actions, ArrayList<Integer> upgradeCosts) {
        this.boatName = boatName;
        this.actions = actions;
        this.upgradeCosts = upgradeCosts;
        this.shape = this.getShape();
    }

    public abstract ArrayList<ArrayList<String>> getShape();
    public String getHorImagePath() {
        return this.horImagePath;
    }

    public String getVertImagePath() {
        return this.vertImagePath;
    }

    public boolean checkHit(ArrayList<Integer> coordinates) {
        for (int i = 0; i < this.allPositions.size(); i++) {
            if (this.allPositions.get(i).equals(coordinates)) {
                return true;
            }
        }
        return false;
    }

    public void setPosition(ArrayList<Integer> position)
    {
        this.rootPosition = position;
        this.allPositions = this.generateAllPositions(position);
        System.out.println("Root position set to " + this.rootPosition);
        System.out.println("All positions: " + this.allPositions);
    }

    public ArrayList<ArrayList<Integer>> generateAllPositions(ArrayList<Integer> position) {

        ArrayList<ArrayList<Integer>> allPositions = new ArrayList<>();
        for (int i = 0; i < shape.size(); i++) {
            for (int j = 0; j < shape.get(i).size(); j++) {
                if (shape.get(i).get(j) != "") {
                    allPositions.add(new ArrayList<>(Arrays.asList(position.get(0) + i, position.get(1) + j)));
                }
            }
        }
        return allPositions;
    }

//    public abstract boolean checkHit(ArrayList<Integer> coordinates);

    public void updateSunk(ArrayList<ArrayList<Square>> state, boolean player1)
    {
        if(!isSunk) {
            boolean allHit = true;
            // Check all spaces the boat is on
            for (int i = 0; i < this.allPositions.size(); i++) {
                // Check if space is not hit, if not hit then the boat cannot be sunk
                if (!state.get(allPositions.get(i).get(0)).get(allPositions.get(i).get(1)).getHit()) {
                    allHit = false;
                }
            }
            System.out.println("Boat " + this.boatName + " sunk: " + allHit);
            this.isSunk = allHit;

            if (player1 && this.isSunk) {
                EventPublisher.postEvent("Sunk", boatName + " was sunk by Player 1!");
            }
            if (!player1 && this.isSunk) EventPublisher.postEvent("Sunk", boatName + " was sunk by Player 2!");
        }
        }

    public String getSpaceImagePath(ArrayList<Integer> position) {
        // First check that position exists in boat positions
        boolean existsInPositions = false;
        for (int i = 0; i < this.allPositions.size(); i++) {
            if (this.allPositions.get(i).equals(position)) {
                existsInPositions = true;
            }
        }
        if (!existsInPositions) {
            System.out.println("Position " + position + " does not exist for boat " + this.boatName);
            return null;
        }
        // Find and return corresponding index in shape
        int row = position.get(0) - this.getPosition().get(0);
        int col = position.get(1) - this.getPosition().get(1);
        //System.out.println("Got image path: " + this.shape.get(row).get(col));
        return this.shape.get(row).get(col);
    }

    public boolean getSunk() { return this.isSunk; }
    public GameAction getAction() { return this.actions.get(this.boatLevel); }
    public ArrayList<Integer> getPosition() { return this.rootPosition; }
    public String getBoatName() { return this.boatName; }

    public void upgradeBoat(boolean player1) {
        if (!this.fullyUpgraded) {
            this.boatLevel++;
            if (this.boatLevel >= this.actions.size() - 1) {
                this.fullyUpgraded = true;
            }
            System.out.println("Successfully upgraded boat");
            if(player1) {
                EventPublisher.postEvent("Upgrade Boat", "Player 1 Successfully upgraded their " + this.boatName + "!");
            }
            else EventPublisher.postEvent("Upgrade Boat", "Player 1 Successfully upgraded their " + this.boatName + "!");
        }
        else {
            System.out.println("Boat is at max level");
        }
    }
    public int getUpgradeCost() {
        if (this.upgradeCosts.size() == 0) {
            return -1;
        }
        if (this.fullyUpgraded) {
            return -1;
        }
        return this.upgradeCosts.get(boatLevel);
    }

    public String getBoatDescription() { return this.boatDescription;}

    public void setBoatUpgradeDescribe(String update)
    {
        this.boatUpgradeDescribe = update;
    }

    public String getBoatUpgradeDescribe(){ return this.boatUpgradeDescribe;}

    public String getUpgradeImage() {
        if (this.fullyUpgraded) {
            return "/fightboat/images/doggy.png";
        }
        return this.actions.get(this.boatLevel+1).getImagePath();
    }

    public String getAttackImage() {
        return this.actions.get(boatLevel).getImagePath();
    }

    public boolean isFullyUpgraded() { return this.fullyUpgraded; }

    public String getGridImagePath(boolean hor) {
        if (hor) {
            return horGridImage;
        }
        return vertGridImage;
    }
}
