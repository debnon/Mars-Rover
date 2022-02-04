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
        // Orientation orientation = rover.Rover.Orientation.WEST;
        super();
        xPosition = xOrigin;
        yPosition = yOrigin;
        this.orientation = startOrientation;
        this.roverID = RectMarsPlateau.initRoverPosition(xOrigin, yOrigin);

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
            xPosition += 1;
        } else if (orientation.equals(Orientation.EAST)) {
            yPosition += 1;
        } else if (orientation.equals(Orientation.SOUTH)) {
            xPosition -= 1;
        } else if (orientation.equals(Orientation.WEST)) {
            yPosition -= 1;
        }

        // check if other rovers are in the way
        // how to handle long input?

    }

    private void changeOrientation(char instruction) {

    }

    public Object[] checkPosition() {
        Object[] positionArray = new Object[3];
        positionArray[0] = xPosition;
        positionArray[1] = yPosition;
        positionArray[2] = orientation;

        return positionArray;
    }

}