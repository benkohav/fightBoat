package fightboat.boats;

import fightboat.actions.DefaultAttack;
import fightboat.actions.Make100;
import fightboat.actions.Make50;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.Arrays;

public class ContainerShip extends Boat{

    //String boatName = "Container Ship";

    public ContainerShip() {
        super("Container Ship",
                new ArrayList<>(Arrays.asList(new Make50(), new Make100())),
                new ArrayList<>(Arrays.asList(50)));
        this.horImagePath = "/fightboat/images/ContainerShipHor.png";
        this.vertImagePath = "/fightboat/images/ContainerShipVert.png";
        this.horGridImage = "/fightboat/images/ContainerShipGridHor.png";
        this.vertGridImage = "/fightboat/images/ContainerShipGridVert.png";
        this.fullyUpgraded = false;
        this.boatName = "Container Ship";
        this.boatUpgradeDescribe = "This boat does not attack, and only makes money. Upgrade to make more, or click anywhere on the board to make money!";
        this.boatDescription = "Utilize this commercial vessel to earn money and purchase bigger and better attacks for your attacking ships!";
    }

    public ArrayList<ArrayList<String>> getShape() {
        ArrayList<ArrayList<String>> shape = new ArrayList<>();

        ArrayList<String> row1 = new ArrayList<>(Arrays.asList(
                "/fightboat/images/ContainerShipHor(0,0).png",
                "/fightboat/images/ContainerShipHor(0,1).png",
                "/fightboat/images/ContainerShipHor(0,2).png",
                "/fightboat/images/ContainerShipHor(0,3).png"
        ));

        shape.add(row1);

        return shape;
    }
}
