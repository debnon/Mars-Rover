package rover;

import plateau.Plateau;
import plateau.RectMarsPlateau;

import java.util.ArrayList;

public class RectPlateauRover extends Rover{

    // check for other rover
    private static int xPosition;
    private static int yPosition;
    private final String roverID;
    private static RectMarsPlateau plateau;

    public enum Orientation {NORTH, EAST, SOUTH, WEST};
    private Orientation orientation;

    public RectPlateauRover(int xOrigin, int yOrigin, Orientation startOrientation, RectMarsPlateau marsPlateau) {

        super();
        xPosition = xOrigin;
        yPosition = yOrigin;
        this.orientation = startOrientation;
        plateau = marsPlateau;

        // an array is used to store the rover's position to allow abstraction from
        // x and y coordinates in the abstract plateau class.

        Object[] roverPosition = {xPosition, yPosition, orientation};
        this.roverID = plateau.initRoverPosition(roverPosition);
    }

    public void changePosition(String desiredPosition) {

        if (!desiredPosition.matches("[RLM]+")) {
            throw new RuntimeException("One of those instructions is invalid! " +
                    "Remember you can only use L (turn left), R (turn right), and M (move forward)");
        }

        // when the moveForward method is called, it returns a boolean to indicate if a move is valid
        // and if the loop should continue to the next instruction

        ArrayList<Integer> xPositionsOccupied = new ArrayList<Integer>();

        for (Object[] position : plateau.checkRoverPositions().values()) {
            xPositionsOccupied.add((Integer) position[0]);
        }
        System.out.println(xPositionsOccupied);

        ArrayList<Integer> yPositionsOccupied = new ArrayList<Integer>();
        for (Object[] position : plateau.checkRoverPositions().values()) {
            yPositionsOccupied.add((Integer) position[1]);
        }

        // iterates through string of instructions, moving or re-orientating rover for each
        // if a space is already occupied, calculated by querying the arrays above, the loop terminates

        boolean validMoveCheck;
        for (char instruction : desiredPosition.toCharArray()) {
            if (instruction == 'R' || instruction == 'L') {
                changeOrientation(instruction);
            } else if (instruction == 'M') {
                validMoveCheck = moveForward(orientation, xPositionsOccupied, yPositionsOccupied);
                if (!validMoveCheck) {
                    System.out.println("The " + desiredPosition);
                    break;
                }
            }
        }

        plateau.updateRoverPosition(roverID, checkPosition());
    }

    private static boolean moveForward(Orientation orientation,
                                       ArrayList<Integer> xOccupied, ArrayList<Integer> yOccupied) {

        // each instruction's effect is determined by the rover's current orientation
        // additionally it is checked that the instruction won't exit the plateau or hit another rover

        if (orientation.equals(Orientation.NORTH)) {
            System.out.println(yPosition);
            System.out.println(yOccupied);
            System.out.println(!yOccupied.contains(yPosition + 1));
            if (yPosition < plateau.checkPlateauLimits()[1] && !yOccupied.contains(yPosition + 1)) {
                yPosition += 1;
            } else {
                return false;
            }

        } else if (orientation.equals(Orientation.EAST)) {
            if (xPosition < plateau.checkPlateauLimits()[0] && !xOccupied.contains(xPosition + 1)) {
                xPosition += 1;
            } else {
                return false;
            }

        } else if (orientation.equals(Orientation.SOUTH)) {
            if (yPosition > 0 && !yOccupied.contains(yPosition - 1)) {
                yPosition -= 1;
            } else {
                return false;
            }
        } else if (orientation.equals(Orientation.WEST)) {
            if (xPosition > 0 && !yOccupied.contains(xPosition - 1)) {
                xPosition -= 1;
            } else {
                return false;
            }
        }

        return true;
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