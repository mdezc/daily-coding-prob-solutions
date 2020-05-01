package P0022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static utils.Utils.printResult;

public class P0022 {

    // Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list.
    // If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.
    //
    //For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
    // you should return ['the', 'quick', 'brown', 'fox'].
    //
    //Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
    // return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].

    public static void main(String[] args) {

        String[] dictionary1 = new String[]{"quick", "brown", "the", "fox"};
        String string1 = "thequickbrownfox";
        List<String> expected1 = Arrays.asList("the", "quick", "brown", "fox");

        String[] dictionary2 = new String[]{"bed",  "bath", "and", "beyond"};
        String string2 = "bedbathandbeyond";
        List<String> expected2 = Arrays.asList("bed", "bath", "and", "beyond");

        printResult(expected1, solution(dictionary1, string1));
        printResult(expected2, solution(dictionary2, string2));
    }

    private static List<String> solution(final String[] dictionary1, final String string1) {
        return findWordInString(new HashSet<>(Arrays.asList(dictionary1)), string1, new ArrayList<>());
    }

    private static List<String> findWordInString(final Set<String> dictionary, final String stringRemaining, ArrayList<String> foundWords) {
        if (stringRemaining.isEmpty()) {
            return foundWords;
        }

        Optional<String> optWord = dictionary.stream().filter(stringRemaining::contains).findFirst();
        if (optWord.isPresent())  {
            foundWords.add(optWord.get());
            return findWordInString(dictionary, stringRemaining.replace(optWord.get(), ""), foundWords);
        }

        return null;
    }
}
