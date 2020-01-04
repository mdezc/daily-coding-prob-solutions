package P0003;

import java.util.Stack;

import static utils.Utils.printResult;

public class P0003 {

    // Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree. For example, given the following Node class
    //
    // class Node:
    // def __init__(self, val, left=None, right=None):
    // self.val = val self.left = left
    // self.right = right
    //
    // The following test should pass:
    //
    // node = Node('root', Node('left', Node('left.left')), Node('right')) assert deserialize(serialize(node)).left.left.val == 'left.left'

    public static void main(String[] args) {
        String expected = "left.left";
        Node root = new Node("root",
                new Node("left", new Node("left.left", null ,null), null),
                new Node("right", null, null)
        );
        Node tree = deserialize(serialize(root));
        printResult(expected, solution(tree));
    }

    private static String solution(Node node) {
        String serialized = serialize(node);
        Node deserialized = deserialize(serialized);
        return deserialized.left.left.val;
    }

    private static String serialize(Node node) {
        if (node == null) {
            return "";
        }
        return node.val + "(" + serialize(node.left) + ")" + "(" + serialize(node.right) + ")";
    }

    private static Node deserialize(String string) {
        if ("()".equals(string) || "".equals(string)) {
            return null; // for empty nodes
        }

        String nodeContent = string.startsWith("(") ? string.substring(1, string.length()-1) : string; // for root vs nodes;
        return new Node(nodeContent.substring(0, nodeContent.indexOf('(')),
                deserialize(extractContentForNodeNumber(nodeContent, 1)),
                deserialize(extractContentForNodeNumber(nodeContent, 2)));
    }

    private static String extractContentForNodeNumber(String string, int nodeNumber) {
        int nodesFound = 0;
        Stack<Integer> nodeStartPositionStack = new Stack<>();

        for (int i = 0; i < string.toCharArray().length; i++) {
            char ch = string.toCharArray()[i];
            if (ch == '(') {
                nodeStartPositionStack.push(i);
            }
            if (ch == ')') {
                if (nodeStartPositionStack.size() == 1) {
                    nodesFound++;
                    if (nodesFound == nodeNumber) {
                        return string.substring(nodeStartPositionStack.peek(), i+1);
                    }
                }
                nodeStartPositionStack.pop();
            }
        }

        return null; // should never happen unless string is malformed
    }

    static class Node {
        String val;
        Node left;
        Node right;

        Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
