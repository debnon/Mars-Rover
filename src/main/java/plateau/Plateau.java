package plateau;

import java.util.HashMap;
import java.util.UUID;

public abstract class Plateau implements RoverInformation, PlateauInformation {

    public static HashMap<String, Object[]> roverList = new HashMap<>();

    public Plateau() {
        // HashMap<String, Object[]> roverList = new HashMap<>();

    }

    public static String initRoverPosition(Object[] roverPosition) {

        /*
        takes information about a rover instance, assigns it an ID,
        and adds it to a hashmap of all rovers on the plateau.
        It then passes this id back to the rover instance
        to be used as a reference for the relevant rover when updating its position
        */

        String roverID = UUID.randomUUID().toString();
        roverList.put(roverID, roverPosition);

        return roverID;
    }

    public static void updateRoverPosition(String roverID, Object[] roverPosition) {
        roverList.put(roverID, roverPosition);

    }

    public HashMap<String, Object[]> checkRoverPositions() {
        return roverList;
    }
}
