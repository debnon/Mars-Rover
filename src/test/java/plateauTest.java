import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class plateauTest {

    @Test
    public void checkPlateauInitialization() {

        // arrange
        Plateau marsPlateau = new Plateau(1, 1);
        int[] desiredSize = {1,1};

        // act
        int[] actualSize = marsPlateau.checkPlateauLimits();

        // assert
        assertEquals(Arrays.toString(desiredSize), Arrays.toString(actualSize));
    }

}
