package fightboat.boats;

import fightboat.actions.DefaultAttack;
import fightboat.actions.OAttack;

import java.util.ArrayList;
import java.util.Arrays;

public class Battleship extends Boat{

    public Battleship() {
        super(" Battleship",
                new ArrayList<>(Arrays.asList(new DefaultAttack(), new OAttack())),
                new ArrayList<>(Arrays.asList(100)));
        this.horImagePath = "/fightboat/images/BattleshipHor.png";
        this.vertImagePath = "/fightboat/images/BattleshipVert.png";
        this.horGridImage = "/fightboat/images/BattleShipGridHor.png";
        this.vertGridImage = "/fightboat/images/BattleShipGridVert.png";
        this.fullyUpgraded = false;
        this.boatName = "Battleship";
        this.boatUpgradeDescribe = "The O attack is an powerful attack, but you must use it strategically as the space you click won't get hit!";
        this.boatDescription = "The battleship is a staple of the attack fleet. Its O-Attack allows it to hit 4 spaces, and can be obtained for an affordable price, but theres a catch! The O-Attack does not hit the space you click, so you must use it carefully!";
    }

    public ArrayList<ArrayList<String>> getShape() {
        ArrayList<ArrayList<String>> shape = new ArrayList<>();

        ArrayList<String> row1 = new ArrayList<>(Arrays.asList(
                "/fightboat/images/BattleShipHor(0,0).png",
                "/fightboat/images/BattleShipHor(0,1).png",
                "/fightboat/images/BattleShipHor(0,2).png",
                "/fightboat/images/BattleShipHor(0,3).png",
                "/fightboat/images/BattleShipHor(0,4).png"
        ));

        shape.add(row1);

        return shape;
    }
}
