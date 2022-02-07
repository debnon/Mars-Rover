package plateau;

import java.util.ArrayList;
import java.util.Arrays;

public class RectPlateau extends Plateau {

    private final int xSize;
    private final int ySize;

    public RectPlateau(int xLimit, int yLimit) {
        super();
        if (xLimit < 0 || yLimit < 0) {
            throw new RuntimeException("The plateau's size cannot be negative!");
        }
        this.xSize = xLimit;
        this.ySize = yLimit;
    }

    public int[] checkPlateauLimits() {
        int[] maxCoOrdinates = new int[2];
        maxCoOrdinates[0] = xSize;
        maxCoOrdinates[1] = ySize;

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
