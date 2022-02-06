import org.junit.Test;
import plateau.RectPlateau;
import rover.RectPlateauRover;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class roverTest {


    // how to do parameterized tests for these first four, then another for the next, etc.?
    @Test
    public void checkRoverInitialization() {

        // arrange
        RectPlateau marsPlateau = new RectPlateau(5,5);
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

        RectPlateau marsPlateau = new RectPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.WEST, marsPlateau);
        Object[] correctRoverPosition = {0,0, RectPlateauRover.Orientation.SOUTH};

        testRover.changePosition("L");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkChangingRoverOrientationRight() {

        RectPlateau marsPlateau = new RectPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.WEST, marsPlateau);
        Object[] correctRoverPosition = {0,0, RectPlateauRover.Orientation.NORTH};

        testRover.changePosition("R");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkMovingRover() {

        RectPlateau marsPlateau = new RectPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.NORTH, marsPlateau);
        Object[] correctRoverPosition = {0,1, RectPlateauRover.Orientation.NORTH};

        testRover.changePosition("M");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkChangingRoverPosition() {

        RectPlateau marsPlateau = new RectPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.NORTH, marsPlateau);
        Object[] correctRoverPosition = {0,1, RectPlateauRover.Orientation.EAST};

        testRover.changePosition("MR");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }



    @Test(expected = RuntimeException.class)
    public void checkChangingRoverPositionWithInvalidCommands() {

        RectPlateau marsPlateau = new RectPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.WEST, marsPlateau);
        String correctMessage = "One of those instructions is invalid! " +
                "Remember you can only use L (turn left), R (turn right), and M (move forward";

        testRover.changePosition("MRB");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        assertEquals(actualRoverPosition, correctMessage);

    }

    @Test
    public void checkChangingRoverPositionIntoOccupiedArea() {

        RectPlateau marsPlateau = new RectPlateau(5,5);

        RectPlateauRover testRover1 = new RectPlateauRover(2,2,
                RectPlateauRover.Orientation.WEST, marsPlateau);

        RectPlateauRover testRover2 = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.WEST, marsPlateau);

        Object[] desiredPosition = {1,2, RectPlateauRover.Orientation.EAST};


        testRover2.changePosition("RMMMRRMLMM");
        String actualRoverPosition = Arrays.toString(testRover2.checkPosition());

        assertEquals(Arrays.toString(desiredPosition), actualRoverPosition);

    }

    @Test(expected = RuntimeException.class)
    public void checkSpawningRoverOnOccupiedPosition() {

        RectPlateau marsPlateau = new RectPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.WEST, marsPlateau);
        RectPlateauRover testRover1 = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.WEST, marsPlateau);

    }

    @Test(expected = RuntimeException.class)
    public void checkSpawningRoverOutOfBounds() {

        RectPlateau marsPlateau = new RectPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(6,5,
                RectPlateauRover.Orientation.WEST, marsPlateau);

    }

}
