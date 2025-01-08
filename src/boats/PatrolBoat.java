package fightboat.boats;

import fightboat.actions.DefaultAttack;

import java.util.ArrayList;
import java.util.Arrays;

public class PatrolBoat extends Boat{

    public PatrolBoat() {
        super("Patrol Boat",
                new ArrayList<>(Arrays.asList(new DefaultAttack())),
                new ArrayList<>());
        this.horImagePath = "/fightboat/images/PatrolBoatHor.png";
        this.vertImagePath = "/fightboat/images/PatrolBoatHor.png";
        this.horGridImage = "/fightboat/images/PatrolBoatGridHor.png";
        this.vertGridImage = "/fightboat/images/PatrolBoatGridVert.png";
        this.fullyUpgraded = true;
        this.boatName = "Patrol Boat";
        this.boatUpgradeDescribe = "Patrol boats are not upgradeable!";
        this.boatDescription = "These small, rugged boats are able to fly under the radar. Taking up little space, they are hard to find, but they don't have much power individually. They are not upgradable and only have the default attack.";
    }

    public ArrayList<ArrayList<String>> getShape() {
        ArrayList<ArrayList<String>> shape = new ArrayList<>();

        ArrayList<String> row1 = new ArrayList<>(Arrays.asList(
                "/fightboat/images/PatrolBoatHor(0,0).png",
                "/fightboat/images/PatrolBoatHor(0,1).png"
        ));

        shape.add(row1);

        return shape;
    }


}
