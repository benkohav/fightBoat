package fightboat.observer;

import java.nio.file.*;
import java.io.*;


/*OBSERVER PATTERN: A way for an object (the subject) to notify a list of dependents (observers) about any state changes,
so they can automatically update themselves when the subject changes.

 */
public class GameRecorder extends Listener{
    private String fileName = null;

    public GameRecorder(String fileName) {
        this.fileName = fileName;
        // Create file
        Path path = Paths.get("src/fightboat/observer/","observerLog");

        // To use deleteIfExists() need to catch IOException, found at:
        // https://www.geeksforgeeks.org/files-deleteifexists-method-in-java-with-examples/#
        try {Files.deleteIfExists(path);}
        catch(IOException e) {}

        File file = new File("src/fightboat/observer/","observerLog");
        try {file.createNewFile();}
        catch(IOException e) {System.out.println("IOException");}
    }
    @Override
    public void takeInData(String strIn) {
        writeToFile(strIn);
    }
    private void writeToFile(String strIn) {
        // Write to file
        try {
            strIn = strIn + "\n";
            OutputStream os = new FileOutputStream("src/fightboat/observer/observerLog", true);
            os.write(strIn.getBytes());
            os.close();
        }
        catch (IOException e) {System.out.println("IOException");}
    }
}
