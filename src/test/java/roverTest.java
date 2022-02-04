import org.junit.Test;
import rover.RectPlateauRover;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class roverTest {


    // how to do parameterized tests for these first four, then another for the next, etc.?
    @Test
    public void checkRoverInitialization() {

        // arrange
        RectPlateauRover testRover = new RectPlateauRover(0,0, RectPlateauRover.Orientation.WEST);
        Object[] desiredRoverPosition = {0,0, RectPlateauRover.Orientation.WEST};

        // act
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        // assert
        assertEquals(actualRoverPosition, Arrays.toString(desiredRoverPosition));
    }

    @Test
    public void checkChangingRoverOrientationLeft() {

        RectPlateauRover testRover = new RectPlateauRover(0,0, RectPlateauRover.Orientation.WEST);
        Object[] correctRoverPosition = {0,0, RectPlateauRover.Orientation.SOUTH};

        testRover.changePosition("L");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkChangingRoverOrientationRight() {

        RectPlateauRover testRover = new RectPlateauRover(0,0, RectPlateauRover.Orientation.WEST);
        Object[] correctRoverPosition = {0,0, RectPlateauRover.Orientation.NORTH};

        testRover.changePosition("R");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkMovingRover() {

        RectPlateauRover testRover = new RectPlateauRover(0,0, RectPlateauRover.Orientation.NORTH);
        Object[] correctRoverPosition = {0,1, RectPlateauRover.Orientation.NORTH};

        testRover.changePosition("M");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkChangingRoverPosition() {

        RectPlateauRover testRover = new RectPlateauRover(0,0, RectPlateauRover.Orientation.NORTH);
        Object[] correctRoverPosition = {0,1, RectPlateauRover.Orientation.EAST};

        testRover.changePosition("MR");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test(expected = RuntimeException.class)
    public void checkChangingRoverPositionWithInvalidCommands() {

        RectPlateauRover testRover = new RectPlateauRover(0,0, RectPlateauRover.Orientation.NORTH);
        String correctMessage = "One of those instructions is invalid! " +
                "Remember you can only use L (turn left), R (turn right), and M (move forward";

        testRover.changePosition("MRB");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, correctMessage);

    }

}
