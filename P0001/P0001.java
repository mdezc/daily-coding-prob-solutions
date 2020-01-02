package P0001;

import java.util.HashSet;
import java.util.Set;

import static utils.Utils.printResult;

public class P0001 {

    // Given a list of numbers and a number k, return whether any of two numbers from the list add up to k.
    // For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
    // Bonus: Can you do this in one pass?

    public static void main(String[] args) {

        int[] input1 = new int[] { 10, 15, 3, 7 };
        int k1 = 17;
        boolean expected1 = true;

        int[] input2 = new int[] { 1, 2, 3, 4, 5 };
        int k2 = 50;
        boolean expected2 = false;

        printResult(input1, expected1, solutionEasy(input1, k1));
        printResult(input2, expected2, solutionHard(input2, k2));
    }

    private static boolean solutionEasy(int[] input, int k) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length && i != j; j++) {
                if (input[i] + input[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean solutionHard(int[] input, int k) {
        Set<Integer> seen = new HashSet<>(input.length);
        for (final int value : input) {
            if (seen.contains(k - value)) {
                return true;
            }
            seen.add(value);
        }
        return false;
    }
}


