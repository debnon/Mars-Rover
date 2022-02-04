package plateau;

import java.util.UUID;

public abstract class Plateau implements RoverInformation, PlateauInformation {


    public Plateau() {

    }

    public static String initRoverPosition(Object[] roverPosition) {

        /*
        takes information about a rover instance, assigns it an ID,
        and adds it to an array of all rovers on the plateau.
        It then passes this id back to the rover instance
        to be used as a reference for the relevant rover when updating its position
        */

        String roverID = UUID.randomUUID().toString();

        return roverID;
    }

    public static void updateRoverPosition(String roverID, Object[] roverPosition) {

    }

    public void checkRoverPositions() {

    }
}
