public class Plateau {

    private int xSize;
    private int ySize;

    public Plateau(int xLimit, int yLimit) {
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
