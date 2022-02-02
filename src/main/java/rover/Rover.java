package rover;

import plateau.Plateau;

public abstract class Rover implements RoverMovement, RoverPosition {

    public Rover() {

    }

    public void changePosition() {
        changeOrientation();
        moveForward();
        Plateau.updateRoverPosition(checkPosition());
    }




}
