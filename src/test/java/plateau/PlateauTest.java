package plateau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rover.RectPlateauRover;

import java.util.Arrays;
import java.util.HashMap;

public class PlateauTest {

    @Test
    public void checkPlateauInitialization() {

        // arrange
        RectPlateau marsPlateau = new RectPlateau(1, 1);
        int[] desiredSize = {1,1};

        // act
        int[] actualSize = marsPlateau.checkPlateauLimits();

        // assert
        Assertions.assertEquals(Arrays.toString(desiredSize), Arrays.toString(actualSize));
    }


    @Test
    public void testCheckRoverPositions() {

        RectPlateau marsPlateau = new RectPlateau(5, 5);
        RectPlateauRover marsRover1 = new RectPlateauRover(1,1,
                RectPlateauRover.Orientation.NORTH, marsPlateau);
        RectPlateauRover marsRover2 = new RectPlateauRover(3,2,
                RectPlateauRover.Orientation.EAST, marsPlateau);

        Object[] array1 = {1,1, "NORTH"};
        Object[] array2 = {3,2, "EAST"};
        Object[][] desiredRoverList = {array1, array2};

        HashMap<String, Object[]> actualRoverMap = marsPlateau.checkRoverPositions();
        Object[][] actualRoverList = new Object[2][];
        int counter = 0;
        for (Object[] position : actualRoverMap.values()) {
            actualRoverList[counter] = position;
            counter += 1;
        }

        // assert
        Assertions.assertEquals(Arrays.toString(desiredRoverList[0]), Arrays.toString(actualRoverList[0]));
        Assertions.assertEquals(Arrays.toString(desiredRoverList[1]), Arrays.toString(actualRoverList[1]));
    }

}
