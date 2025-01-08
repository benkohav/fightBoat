package fightboat.boats;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class EconomicFleet extends FleetDisplay{

    ArrayList<Boat> boats = new ArrayList<>();
    public EconomicFleet(int function) {
        super(new ArrayList<>(Arrays.asList(
                new ContainerShip(),
                new ContainerShip(),
                new Battleship(),
                new Destroyer(),
                new Destroyer())
        ),function, false, "Economic Fleet");
    }

    public static ArrayList<Boat> getFleetBoats() {
//        BEN COMMENTED
        return new ArrayList<Boat>(Arrays.asList(new ContainerShip(), new ContainerShip(), new Battleship(), new Destroyer(), new Destroyer()));
//        return new ArrayList<Boat>(Arrays.asList(new ContainerShip()));
    }
}
