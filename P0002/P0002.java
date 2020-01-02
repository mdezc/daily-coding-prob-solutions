package P0002;

import java.util.Arrays;

import static utils.Utils.printResult;

public class P0002 {

    //Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
    //For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
    //Follow-up: what if you can't use division?

    public static void main(String[] args) {

        int[] input1 = new int[]{1, 2, 3, 4, 5};
        int[] expected1 = new int[]{120, 60, 40, 30, 24};

        printResult(input1, expected1, solutionEasy(input1));
        printResult(input1, expected1, solutionHard(input1));
    }

    private static int[] solutionEasy(int[] input) {
        int totalProduct = Arrays.stream(input).reduce(1, (left, right) -> left * right);
        return Arrays.stream(input).map(operand -> totalProduct / operand).toArray();
    }

    private static int[] solutionHard(int[] input) {
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            result[i] = productForI(input, i);
        }
        return result;
    }

    private static int productForI(int[] input, int i) {
        int product = 1;
        for (int j = 0; j < input.length; j++) {
            if (i != j) {
                product += product * j;
            }
        }
        return product;
    }
}


