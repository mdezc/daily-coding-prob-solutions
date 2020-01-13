package P0008;

import static utils.Utils.printResult;

public class P0008 {

    // A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
    //
    //Given the root to a binary tree, count the number of unival subtrees.
    //
    //For example, the following tree has 5 unival subtrees:

    //   0
    //  / \
    // 1   0
    //    / \
    //   1   0
    //  / \
    // 1   1

    private static int leaf_solution = 0;

    public static void main(String[] args) {
        int input = 4; // # of steps
        int expected = 5; // unique ways
        int[] stepSizeOptions = new int[]{1, 2};

        printResult(input, expected, solution(input, stepSizeOptions));
    }

    private static int solution(final int maxStepNumber, final int[] stepSizeOptions) {

    }

}
