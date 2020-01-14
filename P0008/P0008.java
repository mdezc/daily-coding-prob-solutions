package P0008;

import utils.node.BinaryNode;

import static P0003.P0003.deserialize;
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

    public static void main(String[] args) {
        String serializedTree = "0(1()())(0(1(1()())(1()()))(0()()))";
        BinaryNode tree = deserialize(serializedTree);  // from P0003

        printResult(serializedTree, 5, solution(tree));
    }

    private static int solution(final BinaryNode tree) {
        if (tree == null) {
            return 0;
        }
        if (isUnival(tree)) {
            return 1 + solution(tree.left) + solution(tree.right);
        }
        return solution(tree.left) + solution(tree.right);
    }

    private static boolean isUnival(final BinaryNode tree) {
        if (tree.left == null && tree.right == null) {
            return true; // no children
        }
        if (childNullOrSameAsParent(tree.val, tree.right) && childNullOrSameAsParent(tree.val, tree.left)) {
            return isUnival(tree.right) && isUnival(tree.left);
        }
        return false;
    }

    private static boolean childNullOrSameAsParent(final String parentVal, final BinaryNode child) {
        return child == null || child.val.equals(parentVal);
    }
}
