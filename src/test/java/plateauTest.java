import org.junit.Test;
import plateau.SquareMarsPlateau;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class plateauTest {

    @Test
    public void checkPlateauInitialization() {

        // arrange
        SquareMarsPlateau marsPlateau = new SquareMarsPlateau(1, 1);
        int[] desiredSize = {1,1};

        // act
        int[] actualSize = marsPlateau.checkPlateauLimits();

        // assert
        assertEquals(Arrays.toString(desiredSize), Arrays.toString(actualSize));
    }

}
