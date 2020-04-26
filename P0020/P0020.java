package P0020;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static utils.Utils.printResult;

public class P0020 {

    // Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
    //
    //For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
    //
    //In this example, assume nodes with the same value are the exact same node objects.
    //
    //Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.

    public static void main(String[] args) {

        LinkNode n10 = new LinkNode(10, null);
        LinkNode n8 = new LinkNode(8, n10);
        P0020.LinkNode n1 = new LinkNode(1, n8);
        P0020.LinkNode n99 = new LinkNode(99, n1);
        P0020.LinkNode n7 = new LinkNode(7, n8);
        P0020.LinkNode n3 = new LinkNode(3, n7);

        int expected = 8;

        printResult(String.valueOf(expected), solution(n3, n99));
    }

    private static String solution(LinkNode a, LinkNode b) {
        // check any of shortest values exist in longer
        Map<Integer, LinkNode> nodeMapListA = new HashMap<>();

        LinkNode currentNodeListA = a;
        do {
            nodeMapListA.put(currentNodeListA.value, currentNodeListA.next);
            currentNodeListA = currentNodeListA.next;
        } while (currentNodeListA != null);

        LinkNode currentNodeListB = b;
        do {
            if (nodeMapListA.containsKey(currentNodeListB.value)) {
                LinkNode matchingValueNode = nodeMapListA.get(currentNodeListB.value);
                if (matchingValueNode == currentNodeListB.next) {
                    return String.valueOf(currentNodeListB.value);
                }
            }
            currentNodeListB = currentNodeListB.next;
        } while (currentNodeListB != null);

        return "Not found";
    }

    public static class LinkNode {
        private int value;
        private P0020.LinkNode next;

        public LinkNode(int value, P0020.LinkNode next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", LinkNode.class.getSimpleName() + "[", "]")
                    .add("value=" + value)
                    .add("next=" + next)
                    .toString();
        }
    }
}
