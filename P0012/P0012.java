package P0012;

import java.util.Arrays;

import static utils.Utils.printResult;

public class P0012 {

    // There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
    //
    //For example, if N is 4, then there are 5 unique ways:
    //
    //1, 1, 1, 1
    //2, 1, 1
    //1, 2, 1
    //1, 1, 2
    //2, 2
    //What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.

    public static void main(String[] args) {
        int input = 4; // # of steps
        int expected = 5; // unique ways
        int[] stepSizeOptions = new int[] { 1, 2 };

        printResult(input, expected, solution(input, stepSizeOptions));

        int input2 = 4;
        int expected2 = 3;
        int[] stepSizeOptions2 = new int[] {1, 3, 5};

        printResult(input2, expected2, solution(input2, stepSizeOptions2));
    }

    private static int solution(final int maxStepNumber, final int[] stepSizeOptions) {
        // combinations for each level =
        // sum of combinations for level - each of the options

        Arrays.sort(stepSizeOptions);
        return sumOfCombinations(0, 0, stepSizeOptions, maxStepNumber);
    }

    private static int sumOfCombinations(final int startingLevel, int combinations, final int[] stepSizeOptions, final int maxStepNumber) {
        if (startingLevel < maxStepNumber) {
            for (int stepSize : stepSizeOptions) {
                combinations = sumOfCombinations(startingLevel + stepSize, combinations, stepSizeOptions, maxStepNumber);
            }
        }

        if (startingLevel == maxStepNumber) {
            combinations++;
        }

        // starting level is > maxStepNumber so finish this branch
        return combinations;
    }

}
