public class Rover implements RoverMovement {


    // check for other rover
    private int xPosition;
    private int yPosition;
    private enum Orientation {NORTH, EAST, SOUTH, WEST};

    public Rover(int xOrigin, int yOrigin) {
        Orientation orientation = Rover.Orientation.WEST;

        this.xPosition = xOrigin;
        this.yPosition = yOrigin;

    }

    public void changePosition() {
        changeOrientation();
        moveForward();
    }

    private void changeOrientation() {

    }

    private void moveForward() {

    }

}