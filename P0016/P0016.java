package P0016;

import java.util.LinkedList;

import static utils.Utils.printResult;

public class P0016 {

    // You run an e-commerce website and want to record the last N order ids in a log.
    // Implement a data structure to accomplish this, with the following API:
    //
    // record(order_id): adds the order_id to the log
    // get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
    // You should be as efficient with time and space as possible.

    public static void main(String[] args) {

        IdLog solution = new IdLog(3);
        solution.record("first el");
        solution.record("second el");
        solution.record("third el");
        solution.record("fourth el");

        printResult("third el", solution.get_last(2));
    }

    private static class IdLog {
        private int size;
        private LinkedList<String> linkedList;

        IdLog(int size) {
            this.size = size;
            this.linkedList = new LinkedList<>();
        }

        void record(String id) {
            linkedList.addFirst(id);
            if (linkedList.size() > size) {
                linkedList.removeLast();
            }
            System.out.println("List is now: " + linkedList.toString());
        }

        String get_last(int position) {
            return linkedList.get(position -1); // shift "position" to array index
        }
    }

}
