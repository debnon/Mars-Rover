package rover;

import plateau.Plateau;
import plateau.RectMarsPlateau;

public class RectPlateauRover extends Rover{

    // check for other rover
    private static int xPosition;
    private static int yPosition;
    private final String roverID;

    public enum Orientation {NORTH, EAST, SOUTH, WEST};
    private Orientation orientation;


    public RectPlateauRover(int xOrigin, int yOrigin, Orientation startOrientation) {

        super();
        xPosition = xOrigin;
        yPosition = yOrigin;
        this.orientation = startOrientation;

        // an array is used to store the rover's position to allow abstraction from
        // x and y coordinates in the abstract plateau class.
        Object[] roverPosition = {xPosition, yPosition, orientation};
        this.roverID = RectMarsPlateau.initRoverPosition(roverPosition);

    }

    public void changePosition(String desiredPosition) {

        if (!desiredPosition.matches("[RLM]+")) {
            throw new RuntimeException("One of those instructions is invalid! " +
                    "Remember you can only use L (turn left), R (turn right), and M (move forward)");
        }

        for (char instruction : desiredPosition.toCharArray()) {
            if (instruction == 'R' || instruction == 'L') {
                changeOrientation(instruction);
            } else if (instruction == 'M') {
                moveForward(orientation);
            }
        }

        Plateau.updateRoverPosition(roverID, checkPosition());
    }

    private static void moveForward(Orientation orientation) {
        if (orientation.equals(Orientation.NORTH)) {
            yPosition += 1;
        } else if (orientation.equals(Orientation.EAST)) {
            xPosition += 1;
        } else if (orientation.equals(Orientation.SOUTH)) {
            yPosition -= 1;
        } else if (orientation.equals(Orientation.WEST)) {
            xPosition -= 1;
        }

        // check if other rovers are in the way
        // how to handle long input?

    }

    private void changeOrientation(char instruction) {

        if (instruction == 'L') {
            if (orientation.equals(Orientation.NORTH)) {
                orientation = Orientation.WEST;
            } else if (orientation.equals(Orientation.EAST)) {
                orientation = Orientation.NORTH;
            } else if (orientation.equals(Orientation.SOUTH)) {
                orientation = Orientation.EAST;
            } else if (orientation.equals(Orientation.WEST)) {
                orientation = Orientation.SOUTH;
            }

        } else if (instruction == 'R') {
            if (orientation.equals(Orientation.NORTH)) {
                orientation = Orientation.EAST;
            } else if (orientation.equals(Orientation.EAST)) {
                orientation = Orientation.SOUTH;
            } else if (orientation.equals(Orientation.SOUTH)) {
                orientation = Orientation.WEST;
            } else if (orientation.equals(Orientation.WEST)) {
                orientation = Orientation.NORTH;
            }
        }
    }

    public Object[] checkPosition() {
        Object[] positionArray = new Object[3];
        positionArray[0] = xPosition;
        positionArray[1] = yPosition;
        positionArray[2] = orientation;

        return positionArray;
    }

}