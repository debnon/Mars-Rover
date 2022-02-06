import org.junit.Test;
import plateau.RectPlateau;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class plateauTest {

    @Test
    public void checkPlateauInitialization() {

        // arrange
        RectPlateau marsPlateau2 = new RectPlateau(1, 1);
        int[] desiredSize = {1,1};

        // act
        int[] actualSize = marsPlateau2.checkPlateauLimits();

        // assert
        assertEquals(Arrays.toString(desiredSize), Arrays.toString(actualSize));
    }


//
//    @Test
//    public void testCheckRoverPositions() {
//
//        // arrange
//        RectMarsPlateau marsPlateau5 = new RectMarsPlateau(0, 0);
//        RectPlateauRover marsRover1 = new RectPlateauRover(1,1,
//                RectPlateauRover.Orientation.NORTH, marsPlateau5);
//        // RectPlateauRover marsRover2 = new RectPlateauRover(3,2, RectPlateauRover.Orientation.EAST);
//
//        HashMap<String, Object[]> desiredRoverList = new HashMap<>();
//        // desiredRoverList.put("1", marsRover1.checkPosition());
//        // desiredRoverList.put("2", marsRover2.checkPosition());
//
//
//
//        // act
//        HashMap<String, Object[]> actualRoverList = marsPlateau5.checkRoverPositions();
//        for (Object[] position : actualRoverList.values()) {
//            System.out.println(position[2]);
//        }
//
//        // assert
//        assertEquals(desiredRoverList, actualRoverList);
//    }

}
