package P0012;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Utils.printResult;

public class P0012_tree_recursion {

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

    private static int leaf_solution = 0;

    public static void main(String[] args) {
        int input = 4; // # of steps
        int expected = 5; // unique ways
        int[] stepSizeOptions = new int[]{1, 2};

        printResult(input, expected, solution(input, stepSizeOptions));

        int input2 = 4;
        int expected2 = 3;
        int[] stepSizeOptions2 = new int[]{1, 3, 5};

        printResult(input2, expected2, solution(input2, stepSizeOptions2));
    }

    private static int solution(final int maxStepNumber, final int[] stepSizeOptions) {
        leaf_solution = 0;
        Arrays.sort(stepSizeOptions);
        Node root = new Node(0, 0);

        takeSteps(root, stepSizeOptions, maxStepNumber);

        return leaf_solution;
    }

    private static void takeSteps(Node node, int[] stepSizeOptions, int maxStepNumber) {
        for (int stepSize : stepSizeOptions) {
            if (node.currentStepNumber + stepSize < maxStepNumber) {
                Node newChild = node.addChild(stepSize);
                takeSteps(newChild, stepSizeOptions, maxStepNumber);
                continue;
            }

            if (node.currentStepNumber + stepSize == maxStepNumber) {
                node.addChild(stepSize);
                leaf_solution++;
                continue;
            }

            // bigger steps will not result in a solution, no point in continuing
            break;
        }
    }

    private static class Node {
        private int stepSize;
        private int currentStepNumber;
        private List<Node> children;

        Node(int stepSize, int currentStep) {
            this.stepSize = stepSize;
            this.currentStepNumber = currentStep + stepSize;
            this.children = new ArrayList<>();
        }

        Node addChild(int stepSize) {
            Node newChild = new Node(stepSize, this.currentStepNumber);
            this.children.add(newChild);
            return newChild;
        }
    }

}
