import org.junit.Test;
import plateau.RectMarsPlateau;
import rover.RectPlateauRover;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class roverTest {


    // how to do parameterized tests for these first four, then another for the next, etc.?
    @Test
    public void checkRoverInitialization() {

        // arrange
        RectMarsPlateau marsPlateau = new RectMarsPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.WEST, marsPlateau);
        Object[] desiredRoverPosition = {0,0, RectPlateauRover.Orientation.WEST};

        // act
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        // assert
        assertEquals(actualRoverPosition, Arrays.toString(desiredRoverPosition));
    }

    @Test
    public void checkChangingRoverOrientationLeft() {

        RectMarsPlateau marsPlateau = new RectMarsPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.WEST, marsPlateau);
        Object[] correctRoverPosition = {0,0, RectPlateauRover.Orientation.SOUTH};

        testRover.changePosition("L");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkChangingRoverOrientationRight() {

        RectMarsPlateau marsPlateau = new RectMarsPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.WEST, marsPlateau);
        Object[] correctRoverPosition = {0,0, RectPlateauRover.Orientation.NORTH};

        testRover.changePosition("R");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkMovingRover() {

        RectMarsPlateau marsPlateau = new RectMarsPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.NORTH, marsPlateau);
        Object[] correctRoverPosition = {0,1, RectPlateauRover.Orientation.NORTH};

        testRover.changePosition("M");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkChangingRoverPosition() {

        RectMarsPlateau marsPlateau = new RectMarsPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.NORTH, marsPlateau);
        Object[] correctRoverPosition = {0,1, RectPlateauRover.Orientation.EAST};

        testRover.changePosition("MR");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test(expected = RuntimeException.class)
    public void checkChangingRoverPositionWithInvalidCommands() {

        RectMarsPlateau marsPlateau = new RectMarsPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.WEST, marsPlateau);
        String correctMessage = "One of those instructions is invalid! " +
                "Remember you can only use L (turn left), R (turn right), and M (move forward";

        testRover.changePosition("MRB");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, correctMessage);

    }

}
