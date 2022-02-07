package plateau;

import java.util.ArrayList;
import java.util.Arrays;

public class RectPlateau extends Plateau {

    private final int X_SIZE;
    private final int Y_SIZE;

    public RectPlateau(int xLimit, int yLimit) {
        super();
        if (xLimit < 0 || yLimit < 0) {
            throw new RuntimeException("The plateau's size cannot be negative!");
        }
        this.X_SIZE = xLimit;
        this.Y_SIZE = yLimit;
    }

    public int[] checkPlateauLimits() {
        int[] maxCoOrdinates = new int[2];
        maxCoOrdinates[0] = X_SIZE;
        maxCoOrdinates[1] = Y_SIZE;

        return maxCoOrdinates;
    }

    public boolean checkOccupiedPositions(int xPosition, int yPosition) {
        ArrayList<String> positionsOccupied = new ArrayList<>();

        for (Object[] position : checkRoverPositions().values()) {
            String positions = Arrays.toString(position).substring(1,5);
            positionsOccupied.add(positions);
        }

        return !positionsOccupied.contains(String.valueOf(xPosition) + ", " + String.valueOf(yPosition));
    }




}
