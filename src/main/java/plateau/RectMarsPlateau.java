package plateau;

import java.util.UUID;

public class RectMarsPlateau extends Plateau {


    private final int xSize;
    private final int ySize;

    public RectMarsPlateau(int xLimit, int yLimit) {
        super();
        this.xSize = xLimit;
        this.ySize = yLimit;
    }

    public int[] checkPlateauLimits() {
        int[] maxCoOrdinates = new int[2];
        maxCoOrdinates[0] = xSize;
        maxCoOrdinates[1] = ySize;

        return maxCoOrdinates;
    }




}
