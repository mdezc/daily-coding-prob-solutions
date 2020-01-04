package P0004;

import static utils.Utils.printResult;

public class P0004 {

    // Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
    // For example, the input [3, 4, -1, 1] should give 2.
    // The input [1, 2, 0] should give 3.
    //
    // You can modify the input array in-place.

    public static void main(String[] args) {

        int[] input1 = new int[]{3, 4, -1, 1};
        int expected1 = 2;

        int[] input2 = new int[]{1, 2, 0};
        int expected2 = 3;

        int[] input3 = new int[]{-1, -2, 0};
        int expected3 = 1;

        int[] input4 = new int[]{0, 1, 2, 4};
        int expected4 = 3;

        printResult(input1, expected1, solution(input1));
        printResult(input2, expected2, solution(input2));
        printResult(input3, expected3, solution(input3));
        printResult(input4, expected4, solution(input4));
    }

    private static int solution(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int number = input[i];

            if (!isWithinRange(number, input)) {
                input[i] = 0;
            } else if (number != i) {
                int target = input[i];
                input[i] = 0;
                sortNumberIfWithinRange(input, target);
            }
        }

        return lowestMissingInteger(input);
    }

    private static int lowestMissingInteger(int[] input) {
        for (int i = 0; i < input.length; i++) {
            if (i > 0 && input[i] == 0) {
                return i;
            }
        }
        return input.length;
    }

    private static void sortNumberIfWithinRange(int[] input, int i) {
        int target = input[i];
        input[i] = i;
        if (isWithinRange(target, input)) {
            sortNumberIfWithinRange(input, target);
        }
    }

    private static boolean isWithinRange(int number, int[] input) {
        return number > 0 && number < input.length;
    }

}
