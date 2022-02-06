package rover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import plateau.RectPlateau;
import rover.RectPlateauRover;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class roverTest {


    // how to do parameterized tests for these first four, then another for the next, etc.?

    @BeforeEach
    public void init() {
        System.out.println("Beforeach");
        RectPlateau marsPlateau = new RectPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.WEST, marsPlateau);

    }

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


    @Test
    public void checkChangingRoverPositionWithInvalidCommands() {

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            RectPlateau marsPlateau = new RectPlateau(5,5);
            RectPlateauRover testRover = new RectPlateauRover(0,0,
                    RectPlateauRover.Orientation.WEST, marsPlateau);

            testRover.changePosition("MRB");

        });

        String correctMessage = "One of those instructions is invalid! " +
                "Remember you can only use L (turn left), R (turn right), and M (move forward)";

        Assertions.assertEquals(correctMessage, exception.getMessage());

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

    @Test
    public void checkSpawningRoverOnOccupiedPosition() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            RectPlateau marsPlateau = new RectPlateau(5,5);
            RectPlateauRover testRover = new RectPlateauRover(0,0,
                    RectPlateauRover.Orientation.WEST, marsPlateau);
            RectPlateauRover testRover1 = new RectPlateauRover(0,0,
                    RectPlateauRover.Orientation.WEST, marsPlateau);

        });

        Assertions.assertEquals("That position is outside of the plateau's bounds.", exception.getMessage());


    }

    @Test
    public void checkSpawningRoverOutOfBoundsXAxis() {
        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            RectPlateau marsPlateau = new RectPlateau(5,5);
            RectPlateauRover testRover = new RectPlateauRover(6,4,
                    RectPlateauRover.Orientation.WEST, marsPlateau);

        });

        Assertions.assertEquals("That position is outside of the plateau's bounds.", exception.getMessage());



    }

//    @Test(expected = RuntimeException.class)
    public void checkSpawningRoverOutOfBoundsYAxis() {

        RectPlateau marsPlateau = new RectPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(5,6,
                RectPlateauRover.Orientation.WEST, marsPlateau);

    }

//    @Test(expected = RuntimeException.class)
    public void checkSpawningRoverOutOfBoundsBothAxis() {

        RectPlateau marsPlateau = new RectPlateau(5,5);
        RectPlateauRover testRover = new RectPlateauRover(6,6,
                RectPlateauRover.Orientation.WEST, marsPlateau);

    }

}
