package fightboat;
import fightboat.jframes.MainMenu;
import fightboat.observer.EventPublisher;
import fightboat.observer.GameRecorder;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GameDriver {
    public static void main(String[] args) {
        // Literally all that needs to be done is open a main menu, this initializes the whole game and transitions
        // to the PlayGame frame, game is kept track of statically in GameBoard

        // These are to make it work on mac as well as windows
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }



//        EventPublisher pub = new EventPublisher();
        // Add GameRecorder to Event Publisher
        EventPublisher.subscribe(new GameRecorder("GameHistory.txt"), new ArrayList<>(Arrays.asList("Attack", "Make Money", "Set Position", "Choose Fleet", "Choose Board", "Upgrade Boat", "New Turn", "Sunk", "End Game")));
//        MainMenu mainMenu = new MainMenu();
        GameBoard.setFrame(new MainMenu());
    }
}
