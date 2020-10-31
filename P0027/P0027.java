package P0027;

import java.util.Stack;

import static utils.Utils.printResult;

public class P0027 {

    /*
     * Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).
     * For example, given the string "([])[]({})", you should return true.
     * Given the string "([)]" or "((()", you should return false.
     */

    public static void main(String[] args) {

        String input1 = "([])[]({})";
        boolean expected1 = true;
        String input2 = "([)]";
        boolean expected2 = false;
        String input3 = "((()";
        boolean expected3 = false;

        printResult(expected1, solution(input1));
        printResult(expected2, solution(input2));
        printResult(expected3, solution(input3));
    }

    private static boolean solution(final String input) {
        final Stack<Bracket> bracketStack = new Stack<>();

        for (char ch : input.toCharArray()) {
            final Bracket currentBracket = Bracket.fromString(ch);
            if (currentBracket == null) {
                return false;
            }
            // if it opens, push it and continue
            if (currentBracket.isOpener()) {
                bracketStack.push(currentBracket);
                continue;
            }
            // if it closes and closes top, pop and continue
            if (bracketStack.peek().closer == currentBracket) {
                bracketStack.pop();
                continue;
            }
            return false;
        }

        // stack should be empty if every opener was closed
        return bracketStack.isEmpty();
    }

    private enum Bracket {
        ROUND_CLOSE(')', null),
        ROUND_OPEN('(', ROUND_CLOSE),
        CURLY_CLOSE('}', null),
        CURLY_OPEN('{', CURLY_CLOSE),
        SQUARE_CLOSE(']', null),
        SQUARE_OPEN('[', SQUARE_CLOSE);

        private final char ch;
        private final Bracket closer;

        Bracket(final char ch, final Bracket closer) {
            this.ch = ch;
            this.closer = closer;
        }

        public boolean isOpener() {
            return this.closer != null;
        }

        public static Bracket fromString(char ch) {
            for (Bracket b : Bracket.values()) {
                if (b.ch == ch) {
                    return b;
                }
            }
            return null;
        }

    }

}
