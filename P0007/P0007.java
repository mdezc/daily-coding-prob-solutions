package P0007;

import static utils.Utils.printResult;

public class P0007 {

    // Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
    //
    //For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
    //
    //You can assume that the messages are decodable. For example, '001' is not allowed.

    public static void main(String[] args) {

        int encodedChars = 26;

        String input1 = "111";
        int expected1 = 3; // aaa|ka|ak

        printResult(input1, expected1, solution(encodedChars, input1));

        String input2 = "1111";
        int expected2 = 5;

        printResult(input2, expected2, solution(encodedChars, input2));
    }

    private static int solution(final int encodedChars, final String message) {
        if (message.length() > 1) {
            if (isAmbiguous(message.substring(0, 2), encodedChars)) {
                return solution(encodedChars, message.substring(2))
                    + solution(encodedChars, message.substring(1));
            }
        }
        return 1;
    }

    private static boolean isAmbiguous(String string, int encodedChars) {
        return string.length() == 2 &&
            Integer.parseInt(string) <= encodedChars; // false for 30 31 91, true for 15,
    }
}
