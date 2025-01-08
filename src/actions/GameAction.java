package fightboat.actions;

import java.util.ArrayList;

public abstract class GameAction {
    protected String name;

    protected String imagePath;

    public GameAction(String name, String imagePath) {
        this.imagePath = imagePath;
        this.name = name;
    }

    public abstract void execute(boolean player1, ArrayList<Integer> position);

    public String getImagePath() { return this.imagePath; }

}
