package P0014;

import static utils.Utils.printResult;

public class P0014 {

    // The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.
    // Hint: The basic equation of a circle is x2 + y2 = r2.

    // because im using a square of side 1, centered in 0,0
    // my circle will fit that square with a radius of 0.5, centered in 0,0
    private static final double CIRCLE_RADIUS = 0.5D;

    private static final double SCALE = Math.pow(10, 3);

    private static long pointsTotal = 0;
    private static long pointsInside = 0;

    public static void main(String[] args) {
        do {
            monteCarlo();
        } while (!piEstimatedTo3Decimals());
    }

    private static void monteCarlo() {
        double randomX = CIRCLE_RADIUS - Math.random();
        double randomY = CIRCLE_RADIUS - Math.random();
        double distanceToPoint = hypotenuse(randomX, randomY);
        pointsTotal++;
        if (distanceToPoint < CIRCLE_RADIUS) {
            pointsInside++;
        }
    }

    /**
     * @return whether we have enough data to verify pi to 3 decimal places
     */
    private static boolean piEstimatedTo3Decimals() {
        // because π * radius^2 == π * diameter^2 /4
        // this means that 4 * (points within circle radius / total points) == pi
        double estimatedPi = Math.round(4D * pointsInside / pointsTotal * SCALE) / SCALE;
        return estimatedPi == 3.141D;
    }

    private static double hypotenuse(double randomX, double randomY) {
        return Math.round(Math.sqrt(randomX * randomX + randomY * randomY) * SCALE) / SCALE;
    }

}


