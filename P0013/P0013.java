package P0013;

import java.util.HashSet;
import java.util.Set;

import static utils.Utils.printResult;

public class P0013 {

    // Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
    //
    // For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

    public static void main(String[] args) {

        String input = "abcba";
        int k = 2;
        String expected = "bcb";

        String input2 = "aabcdaaa";
        String expected2 = "daaa";

        printResult(input, expected, solution(input,k));
        printResult(input2, expected2, solution(input2,k));
    }

    private static String solution(String input, int k) {
        String longestString = "";
        for (int i = 0; i < input.length(); i++) {
            String subString = stringOfKUniqueChars(input.substring(i), k);
            if (subString.length() > longestString.length()) {
                longestString = subString;
            }
        }
        return longestString;
    }

    private static String stringOfKUniqueChars(String substring, int k) {
        Set<Character> charSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : substring.toCharArray()) {
            if (charSet.contains(ch) || charSet.size() < k) {
                charSet.add(ch);
                stringBuilder.append(ch);
            } else {
                break;
            }
        }

        return stringBuilder.toString();
    }



}
