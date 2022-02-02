import org.junit.Test;
import rover.RectPlateauRover;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class roverTest {

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
    public void checkChangingRoverOrientation() {

    }

    @Test
    public void checkMovingRover() {

    }

    @Test
    public void checkChangingRoverPosition() {

    }

}
