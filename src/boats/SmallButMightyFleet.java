package fightboat.boats;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SmallButMightyFleet extends FleetDisplay{

    public SmallButMightyFleet(int function) {
        super(new ArrayList<>(Arrays.asList(
                new PatrolBoat(),
                new PatrolBoat(),
                new PatrolBoat(),
                new PatrolBoat(),
                new PatrolBoat(),
                new PatrolBoat())
        ),function, false, "Small but Mighty Fleet");
    }
    public static ArrayList<Boat> getFleetBoats() {
//        BEN COMMENTED
        return new ArrayList<Boat>(Arrays.asList(new PatrolBoat(), new PatrolBoat(), new PatrolBoat(), new PatrolBoat(), new PatrolBoat(), new PatrolBoat(), new PatrolBoat()));
//        return new ArrayList<Boat>(Arrays.asList(new ContainerShip()));


    }
}
