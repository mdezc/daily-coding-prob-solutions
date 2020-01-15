package P0011;

import java.util.*;

import static utils.Utils.printResult;

public class P0011 {

    // Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.
    //
    // For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
    //
    // Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

    public static void main(String[] args) {

        List<String> input = Arrays.asList("dog", "deer", "deal");
        List<String> expected = Arrays.asList("deer", "deal"); // "de"

        printResult(input.toString(), expected.toString(), solution(input, "de").toString());
    }

    private static List<String> solution(List<String> dictionary, String queryString) {
        Map<String, List<String>> dictionaryMap = buildDictionary(dictionary);
        return dictionaryMap.get(queryString);
    }

    private static Map<String, List<String>> buildDictionary(List<String> dictionary) {
        Map<String, List<String>> hashMap = new HashMap<>();

        for (String word : dictionary) {
            String startingChars = word.substring(0, 2);
            if (!hashMap.containsKey(startingChars)) {
                hashMap.put(startingChars, new ArrayList<>());
            }
            hashMap.get(startingChars).add(word);
        }
        return hashMap;
    }

}
