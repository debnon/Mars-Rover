package rover;

import plateau.RectPlateau;

import java.util.Arrays;

public class RectPlateauRover extends Rover{

    private static int xPosition;
    private static int yPosition;
    private final String roverID;
    private static RectPlateau plateau;

    public enum Orientation {
        NORTH, EAST, SOUTH, WEST;

        private static final Orientation[] cardinals = values();

        public Orientation right() {
            return cardinals[(this.ordinal() + 1) % cardinals.length];
        }

        public Orientation left() {
            return cardinals[Math.floorMod(this.ordinal() - 1, cardinals.length) ];
        }
    }
    private Orientation orientation;

    public RectPlateauRover(int xOrigin, int yOrigin, Orientation startOrientation, RectPlateau marsPlateau) {

        super();
        xPosition = xOrigin;
        yPosition = yOrigin;
        this.orientation = startOrientation;
        plateau = marsPlateau;

        if (!plateau.checkOccupiedPositions(xPosition, yPosition)) {
            throw new RuntimeException("That position on the plateau is already occupied.");
        } else if (0 > yPosition || yPosition > plateau.checkPlateauLimits()[1]
                || 0 > xPosition || xPosition > plateau.checkPlateauLimits()[0]) {
            throw new RuntimeException("That position is outside of the plateau's bounds.");
        }

        // an array is used to store the rover's position to allow abstraction from x and y coordinates
        Object[] roverPosition = {xPosition, yPosition, orientation};
        this.roverID = plateau.initRoverPosition(roverPosition);
    }

    public void changePosition(String desiredPosition) {

        if (!desiredPosition.matches("[RLM]+")) {
            throw new RuntimeException("One of those instructions is invalid! " +
                    "Remember you can only use L (turn left), R (turn right), and M (move forward)");
        }

        // iterates through string of instructions, moving or re-orientating rover for each
        // if a space is already occupied, calculated by querying the array above, the loop terminates

        boolean validMoveCheck;
        for (char instruction : desiredPosition.toCharArray()) {
            if (instruction == 'R' || instruction == 'L') {
                changeOrientation(instruction);
            } else if (instruction == 'M') {
                validMoveCheck = moveForward(orientation);
                if (!validMoveCheck) {
                    System.out.println("Completing the full instruction is impossible due to obstruction. " +
                            "The rover is currently positioned at: " + Arrays.toString(checkPosition()));
                    break;
                }
            }
        }

        plateau.updateRoverPosition(roverID, checkPosition());
    }

    private boolean moveForward(Orientation orientation) {

        // each instruction's effect is determined by the rover's current orientation
        // additionally it is checked that the instruction won't exit the plateau or hit another rover

        if (orientation.equals(Orientation.NORTH)) {
            if (yPosition < plateau.checkPlateauLimits()[1] &&
                    plateau.checkOccupiedPositions(xPosition, yPosition + 1)) {
                yPosition += 1;
            } else {
                return false;
            }

        } else if (orientation.equals(Orientation.EAST)) {
            if (xPosition < plateau.checkPlateauLimits()[0] &&
                    plateau.checkOccupiedPositions(xPosition + 1, yPosition)) {
                xPosition += 1;
            } else {
                return false;
            }

        } else if (orientation.equals(Orientation.SOUTH)) {
            if (yPosition > 0 && plateau.checkOccupiedPositions(xPosition, yPosition - 1)) {
                yPosition -= 1;
            } else {
                return false;
            }

        } else if (orientation.equals(Orientation.WEST)) {
            if (xPosition > 0 && plateau.checkOccupiedPositions(xPosition - 1, yPosition)) {
                xPosition -= 1;
            } else {
                return false;
            }
        }

        return true;
    }

    private void changeOrientation(char instruction) {

        if (instruction == 'L') {
            orientation = orientation.left();
        } else if (instruction == 'R') {
            orientation = orientation.right();
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