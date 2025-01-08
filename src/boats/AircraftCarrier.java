package fightboat.boats;

import fightboat.actions.DefaultAttack;
import fightboat.actions.XAttack;

import java.util.ArrayList;
import java.util.Arrays;

public class AircraftCarrier extends Boat{

    //private String boatName = "Aircraft Carrier";

    public AircraftCarrier()
    {
        super("Aircraft Carrier",
                new ArrayList<>(Arrays.asList(new DefaultAttack(), new XAttack())),
                new ArrayList<>(Arrays.asList(150)));
        this.horImagePath = "/fightboat/images/CuteAircraftCarrierHor.png";
        this.vertImagePath = "/fightboat/images/CuteAircraftCarrierVert.png";
        this.horGridImage = "/fightboat/images/AircraftCarrierGridHor.png";
        this.vertGridImage = "/fightboat/images/AircraftCarrierGridVert.png";

        this.boatName = "Aircraft Carrier";

        this.boatUpgradeDescribe = "The X-Attack is powerful but expensive, choose wisely!";

        this.boatDescription = "The aircraft carrier is a powerhouse, capable of an X-Attack, attacking 5 squares simultaneously. However, this upgrade is expensive to obtain, and its massive size makes it easy to find, especially on specially shaped boards.";
//
    }

    public ArrayList<ArrayList<String>> getShape() {
        ArrayList<ArrayList<String>> shape = new ArrayList<>();

        ArrayList<String> row1 = new ArrayList<>(Arrays.asList(
                "/fightboat/images/CuteAircraftCarrierHor(0,0).png",
                "/fightboat/images/CuteAircraftCarrierHor(0,1).png",
                "/fightboat/images/CuteAircraftCarrierHor(0,2).png",
                "/fightboat/images/CuteAircraftCarrierHor(0,3).png"
        ));
        ArrayList<String> row2 = new ArrayList<>(Arrays.asList(
                "/fightboat/images/CuteAircraftCarrierHor(1,0).png",
                "/fightboat/images/CuteAircraftCarrierHor(1,1).png",
                "/fightboat/images/CuteAircraftCarrierHor(1,2).png",
                "/fightboat/images/CuteAircraftCarrierHor(1,3).png"
        ));

        shape.add(row1);
        shape.add(row2);

        return shape;
    }


//    @Override
//    public boolean checkHit(ArrayList<Integer> coordinates) {
//        if (this.rootPosition.equals(coordinates)) {
//            return true;
//        }
//        return false;
//    }
}
