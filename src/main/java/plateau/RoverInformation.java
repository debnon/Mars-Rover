package plateau;

import java.util.HashMap;

public interface RoverInformation {

    String initRoverPosition(Object[] roverPosition);

    void updateRoverPosition(String roverID, Object[] roverPosition);

    HashMap<String, Object[]> checkRoverPositions();

    boolean checkOccupiedPositions(int xPosition, int yPosition);
}
