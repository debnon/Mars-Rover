package rover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import plateau.RectPlateau;

import java.util.Arrays;


public class roverBasicTests {

    RectPlateauRover testRover;
    RectPlateau marsPlateau;

    @BeforeEach
    public void init() {

        marsPlateau = new RectPlateau(5,5);

        testRover = new RectPlateauRover(0,0,
                RectPlateauRover.Orientation.NORTH, marsPlateau);
    }

    @Test
    public void checkRoverInitialization() {

        // arrange
        Object[] desiredRoverPosition = {0,0, RectPlateauRover.Orientation.NORTH};

        // act
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        // assert
        Assertions.assertEquals(Arrays.toString(desiredRoverPosition), actualRoverPosition);
    }

    @Test
    public void checkChangingRoverOrientationLeft() {

        Object[] correctRoverPosition = {0,0, RectPlateauRover.Orientation.WEST};

        testRover.changePosition("L");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        Assertions.assertEquals(Arrays.toString(correctRoverPosition), actualRoverPosition);

    }

    @Test
    public void checkChangingRoverOrientationRight() {

        Object[] correctRoverPosition = {0,0, RectPlateauRover.Orientation.EAST};

        testRover.changePosition("R");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        Assertions.assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkChangingRoverOrientationLeftThenRight() {

        Object[] correctRoverPosition = {0,0, RectPlateauRover.Orientation.EAST};

        testRover.changePosition("LRR");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        Assertions.assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkChangingRoverOrientationRightThenLeft() {

        Object[] correctRoverPosition = {0,0, RectPlateauRover.Orientation.SOUTH};

        testRover.changePosition("RRRRRLLL");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        Assertions.assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkMovingRover() {

        Object[] correctRoverPosition = {0,1, RectPlateauRover.Orientation.NORTH};

        testRover.changePosition("M");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        Assertions.assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }

    @Test
    public void checkMovingRoverThenChangingOrientation() {

        Object[] correctRoverPosition = {0,1, RectPlateauRover.Orientation.EAST};

        testRover.changePosition("MR");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        Assertions.assertEquals(actualRoverPosition, Arrays.toString(correctRoverPosition));

    }


    @Test
    public void checkChangingRoverPositionWithInvalidCommands() {

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            testRover.changePosition("MRB");
        });

        String correctMessage = "One of those instructions is invalid! " +
                "Remember you can only use L (turn left), R (turn right), and M (move forward)";

        Assertions.assertEquals(correctMessage, exception.getMessage());

    }

    @Test
    public void checkChangingRoverPositionIntoOccupiedPosition() {

        RectPlateauRover testRover2 = new RectPlateauRover(2,2,
                RectPlateauRover.Orientation.WEST, marsPlateau);


        Object[] desiredPosition = {1,2, RectPlateauRover.Orientation.EAST};

        testRover.changePosition("MMMLLMLMMM");
        String actualRoverPosition = Arrays.toString(testRover.checkPosition());

        Assertions.assertEquals(Arrays.toString(desiredPosition), actualRoverPosition);

    }

    @Test
    public void checkSpawningRoverOnOccupiedPosition() {

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            RectPlateauRover testRover1 = new RectPlateauRover(0,0,
                    RectPlateauRover.Orientation.WEST, marsPlateau);
        });

        Assertions.assertEquals("That position on the plateau is already occupied.", exception.getMessage());

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

    @Test
    public void checkSpawningRoverOutOfBoundsYAxis() {

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            RectPlateau marsPlateau = new RectPlateau(5,5);
            RectPlateauRover testRover = new RectPlateauRover(5,6,
                    RectPlateauRover.Orientation.WEST, marsPlateau);
        });

        Assertions.assertEquals("That position is outside of the plateau's bounds.", exception.getMessage());

    }

    @Test
    public void checkSpawningRoverOutOfBoundsBothAxis() {

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            RectPlateau marsPlateau = new RectPlateau(5,5);
            RectPlateauRover testRover = new RectPlateauRover(6,6,
                    RectPlateauRover.Orientation.WEST, marsPlateau);
        });

        Assertions.assertEquals("That position is outside of the plateau's bounds.", exception.getMessage());

    }

}
