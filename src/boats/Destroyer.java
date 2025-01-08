package fightboat.boats;

import fightboat.actions.AdjacentAttack;
import fightboat.actions.DefaultAttack;

import java.util.ArrayList;
import java.util.Arrays;

public class Destroyer extends Boat{

    public Destroyer() {
        super("Destroyer",
                new ArrayList<>(Arrays.asList(new DefaultAttack(), new AdjacentAttack())),
                new ArrayList<>(Arrays.asList(50)));
        this.horImagePath = "/fightboat/images/DestroyerHor.png";
        this.vertImagePath = "/fightboat/images/DestroyerHor.png";
        this.horGridImage = "/fightboat/images/DestroyerGridHor.png";
        this.vertGridImage = "/fightboat/images/DestroyerGridVert.png";
        this.fullyUpgraded = false;

        this.boatUpgradeDescribe = "The adjacent attack doubles your firepower!";

        this.boatDescription = "The destroyer is a smaller ship that still packs a punch. Its adjacent attack upgrade can attack 2 adjacent spaces at once, doubling your firepower! Great for taking down ships once you've spotted them.";
    }

    public ArrayList<ArrayList<String>> getShape() {
        ArrayList<ArrayList<String>> shape = new ArrayList<>();

        ArrayList<String> row1 = new ArrayList<>(Arrays.asList(
                "/fightboat/images/DestroyerHor(0,0).png",
                "/fightboat/images/DestroyerHor(0,1).png",
                "/fightboat/images/DestroyerHor(0,2).png"
        ));

        shape.add(row1);

        return shape;
    }
}
