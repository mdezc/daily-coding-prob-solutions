package P0009;

import static java.lang.Math.max;
import static utils.Utils.printResult;

public class P0009 {

    // Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
    //
    // For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
    //
    // Follow-up: Can you do this in O(N) time and constant space?

    public static void main(String[] args) {

        int[] input = new int[] { 2, 4, 6, 2, 5 };
        int expected = 13;

        int[] input2 = new int[] { 5, 1, 1, 5 };
        int expected2 = 10;

        int[] input3 = new int[] { 5, 1, -1, -1, 5 };
        int expected3 = 10;

        printResult(input, expected, solution(input));
        printResult(input2, expected2, solution(input2));
        printResult(input3, expected3, solution(input3));
    }

    private static int solution(final int[] input) {
        // max of starting at 0 and starting at 1
        return max(sumHighestOfNextTwoAvailable(input[0], input, 2), sumHighestOfNextTwoAvailable(input[1], input, 3));
    }

    private static int sumHighestOfNextTwoAvailable(int accumulated, final int[] input, final int index) {
        if (index > input.length - 1 ) {
            return accumulated;
        }
        if (input.length - 1 == index) {
            return accumulated + input[index];
        }

        if (input[index] > input[index + 1]) {
            return sumHighestOfNextTwoAvailable(accumulated + input[index], input, index + 2);
        }

        return sumHighestOfNextTwoAvailable(accumulated + input[index + 1], input, index + 3);
    }
}
