package rover;

import plateau.Plateau;

public class RectPlateauRover implements RoverMovement {

    // check for other rover
    private int xPosition;
    private int yPosition;
    private Orientation orientation;
    public enum Orientation {NORTH, EAST, SOUTH, WEST};

    public RectPlateauRover(int xOrigin, int yOrigin, Orientation startOrientation) {
        // Orientation orientation = rover.Rover.Orientation.WEST;

        this.xPosition = xOrigin;
        this.yPosition = yOrigin;
        this.orientation = startOrientation;
        Plateau.storeRoverPosition();

    }

    public void changePosition() {
        changeOrientation();
        moveForward();
        Plateau.updateRoverPosition(checkPosition());
    }

    private void changeOrientation() {

    }

    private void moveForward() {

    }

    public Object[] checkPosition() {
        Object[] positionArray = new Object[3];
        positionArray[0] = xPosition;
        positionArray[1] = yPosition;
        positionArray[2] = orientation;

        return positionArray;
    }

}