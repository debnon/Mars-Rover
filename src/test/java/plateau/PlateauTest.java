package plateau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rover.RectPlateauRover;

import java.util.Arrays;
import java.util.HashMap;

public class PlateauTest {

    RectPlateau marsPlateau;

    @BeforeEach
    public void init() {
        marsPlateau = new RectPlateau(5, 5);

    }

    @Test
    public void checkPlateauInitialization() {

        int[] desiredSize = {5,5};

        // act
        int[] actualSize = marsPlateau.checkPlateauLimits();

        // assert
        Assertions.assertEquals(Arrays.toString(desiredSize), Arrays.toString(actualSize));
    }

    @Test
    public void checkPlateauNegativeInitializationErrorX() {

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            marsPlateau = new RectPlateau(-1, 5);
        });

        Assertions.assertEquals("The plateau's size cannot be negative!", exception.getMessage());
    }

    @Test
    public void checkPlateauNegativeInitializationErrorY() {

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            marsPlateau = new RectPlateau(5, -2);
        });

        Assertions.assertEquals("The plateau's size cannot be negative!", exception.getMessage());
    }

    @Test
    public void checkPlateauNegativeInitializationErrorXAndY() {

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class, () -> {
            marsPlateau = new RectPlateau(-3, -1);
        });

        Assertions.assertEquals("The plateau's size cannot be negative!", exception.getMessage());
    }


    @Test
    public void testCheckRoverPositions() {

        // marsPlateau = new RectPlateau(5, 5);
        RectPlateauRover marsRover1 = new RectPlateauRover(1,1,
                RectPlateauRover.Orientation.NORTH, marsPlateau);
        RectPlateauRover marsRover2 = new RectPlateauRover(3,2,
                RectPlateauRover.Orientation.EAST, marsPlateau);

        Object[] array1 = {1,1, "NORTH"};
        Object[] array2 = {3,2, "EAST"};

        HashMap<String, Object[]> actualRoverMap = marsPlateau.checkRoverPositions();
        String[] actualRoverList = new String[2];
        int counter = 0;
        for (Object[] position : actualRoverMap.values()) {
            actualRoverList[counter] = Arrays.toString(position);
            counter += 1;
        }

        boolean expectedResult = Arrays.asList(actualRoverList).contains(Arrays.toString(array1)) &&
                Arrays.asList(actualRoverList).contains(Arrays.toString(array2));

        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void testCheckRoverPositionsWithObstruction() {

        RectPlateauRover marsRover1 = new RectPlateauRover(3,3,
                RectPlateauRover.Orientation.NORTH, marsPlateau);
        RectPlateauRover marsRover2 = new RectPlateauRover(1,2,
                RectPlateauRover.Orientation.EAST, marsPlateau);

        Object[] array1 = {3,3, "NORTH"};
        Object[] array2 = {3,2, "NORTH"};

        marsRover2.changePosition("MMLMM");

        HashMap<String, Object[]> actualRoverMap = marsPlateau.checkRoverPositions();
        String[] actualRoverList = new String[2];
        int counter = 0;
        for (Object[] position : actualRoverMap.values()) {
            actualRoverList[counter] = Arrays.toString(position);
            counter += 1;
        }

        boolean expectedResult = Arrays.asList(actualRoverList).contains(Arrays.toString(array1)) &&
                Arrays.asList(actualRoverList).contains(Arrays.toString(array2));

        Assertions.assertTrue(expectedResult);
    }

    @Test
    public void testCheckRoverPositionsWithObstructionFromAbove() {

        RectPlateauRover marsRover1 = new RectPlateauRover(3,3,
                RectPlateauRover.Orientation.NORTH, marsPlateau);
        RectPlateauRover marsRover2 = new RectPlateauRover(1,2,
                RectPlateauRover.Orientation.EAST, marsPlateau);

        Object[] array1 = {3,3, "NORTH"};
        Object[] array2 = {3,4, "SOUTH"};

        marsRover2.changePosition("LMMRMMRMM");

        HashMap<String, Object[]> actualRoverMap = marsPlateau.checkRoverPositions();
        String[] actualRoverList = new String[2];
        int counter = 0;
        for (Object[] position : actualRoverMap.values()) {
            actualRoverList[counter] = Arrays.toString(position);
            counter += 1;
        }

        boolean expectedResult = Arrays.asList(actualRoverList).contains(Arrays.toString(array1)) &&
                Arrays.asList(actualRoverList).contains(Arrays.toString(array2));

        Assertions.assertTrue(expectedResult);
    }

}
