package fightboat.boats;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AttackFleet extends FleetDisplay {

    public AttackFleet(int function) {
        super(new ArrayList<>(Arrays.asList(
                new AircraftCarrier(),
                new Battleship(),
                new Destroyer(),
                new ContainerShip())
        ),function, false, "Attack Fleet");
    }

    public static ArrayList<Boat> getFleetBoats() {
//        BEN COMMENTED
        return new ArrayList<Boat>(Arrays.asList(new AircraftCarrier(), new Battleship(), new Destroyer(), new ContainerShip()));
//        return new ArrayList<Boat>(Arrays.asList(new ContainerShip()));
    }
}
