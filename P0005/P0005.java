package P0005;

import utils.Utils;

import static utils.Utils.printResult;

public class P0005 {

    // cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair.
    // For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
    //
    // Given this implementation of cons:
    //
    // def cons(a, b):
    //    def pair(f):
    //        return f(a, b)
    //    return pair
    // Implement car and cdr.

    public static void main(String[] args) {

        Pair<Integer, Integer> input1 = cons(3, 4);
        int expected1 = 3;

        Pair<Integer, Integer> input2 = cons(3, 4);
        int expected2 = 4;

        Utils.printResult(input1, expected1, car(cons(3, 4)));
        Utils.printResult(input2, expected2, cdr(cons(3, 4)));
    }

    private static class Pair<T, U> {
        private T a;
        private U b;

        public Pair(final T a, final U b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Pair{" +
                "a=" + a +
                ", b=" + b +
                '}';
        }
    }

    private static <T, U> Pair<T, U> cons(T a, U b) {
        return new Pair(a, b);
    }

    private static <T, U> T car(Pair<T, U> pair) {
        return pair.a;
    }

    private static <T, U> U cdr(Pair<T, U> pair) {
        return pair.b;
    }
}
