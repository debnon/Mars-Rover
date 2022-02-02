package rover;

import java.util.Arrays;

public class Rover implements RoverMovement {

    // check for other rover
    private int xPosition;
    private int yPosition;
    private Orientation orientation;
    public enum Orientation {NORTH, EAST, SOUTH, WEST};

    public Rover(int xOrigin, int yOrigin, Orientation startOrientation) {
        // Orientation orientation = rover.Rover.Orientation.WEST;

        this.xPosition = xOrigin;
        this.yPosition = yOrigin;
        this.orientation = startOrientation;

    }

    public void changePosition() {
        changeOrientation();
        moveForward();
    }

    private void changeOrientation() {

    }

    private void moveForward() {

    }

    public String checkPosition() {
        Object[] positionArray = new Object[3];
        positionArray[0] = xPosition;
        positionArray[1] = yPosition;
        positionArray[2] = orientation;

        return Arrays.toString(positionArray);
    }

}