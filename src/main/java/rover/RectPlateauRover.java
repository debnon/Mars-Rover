package rover;

import plateau.Plateau;
import plateau.SquareMarsPlateau;

public class RectPlateauRover extends Rover{

    // check for other rover
    private int xPosition;
    private int yPosition;
    private Orientation orientation;
    public enum Orientation {NORTH, EAST, SOUTH, WEST};

    public RectPlateauRover(int xOrigin, int yOrigin, Orientation startOrientation) {
        // Orientation orientation = rover.Rover.Orientation.WEST;
        super();
        this.xPosition = xOrigin;
        this.yPosition = yOrigin;
        this.orientation = startOrientation;
        SquareMarsPlateau.storeRoverPosition();

    }

    public void changeOrientation() {

    }

    public void moveForward() {

    }


    public Object[] checkPosition() {
        Object[] positionArray = new Object[3];
        positionArray[0] = xPosition;
        positionArray[1] = yPosition;
        positionArray[2] = orientation;

        return positionArray;
    }

}