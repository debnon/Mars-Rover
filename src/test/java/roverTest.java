import org.junit.Test;
import rover.Rover;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class roverTest {

    @Test
    public void checkRoverInitialization() {

        // arrange
        Rover testRover = new Rover(0,0, Rover.Orientation.WEST);
        Object[] desiredRoverPosition = {0,0, Rover.Orientation.WEST};

        // act
        String actualRoverPosition = testRover.checkPosition();

        // assert
        assertEquals(actualRoverPosition, Arrays.toString(desiredRoverPosition));
    }

    @Test
    public void checkChangingRoverOrientation() {

    }

    @Test
    public void checkMovingRover() {

    }

    @Test
    public void checkChangingRoverPosition() {

    }

}
