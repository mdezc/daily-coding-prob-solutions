package P0017;

import java.util.*;

import static utils.Utils.printResult;

public class P0017 {

    //Suppose we represent our file system by a string in the following manner:
    //The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
    //dir
    //    subdir1
    //    subdir2
    //        file.ext
    //The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

    //The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
    //dir
    //    subdir1
    //        file1.ext
    //        subsubdir1
    //    subdir2
    //        subsubdir2
    //            file2.ext
    //The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext
    // and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2
    // containing a file file2.ext.

    //We are interested in finding the longest (number of characters) absolute path to a file within our file system.
    // For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and
    // its length is 32 (not including the double quotes).
    //Given a string representing the file system in the above format, return the length of the longest absolute path
    // to a file in the abstracted file system. If there is no file in the system, return 0.
    //Note:
    //The name of a file contains at least a period and an extension.
    //The name of a directory or sub-directory will not contain a period.


    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int expected = 32;
        printResult(input, expected, solution(input));
    }

    private static int solution(String input) {
        int maxLength = 0;
        Stack<String> namePerLevel = new Stack<>();

        for (String line : input.split("\n")) {
            String objectName = line.replaceAll("\t", "");
            if (line.contains(".")) {
                // is a file
                String path = pathToHere(namePerLevel) + objectName;
                if (path.length() > maxLength) {
                    System.out.println(String.format("Replacing maxLength %s with new %s from %s", maxLength, path.length(), path));
                    maxLength = path.length();
                }
            } else {
                // is a directory
                int thisLineIndent = line.split("\t").length;

                if (thisLineIndent > namePerLevel.size()) {
                    namePerLevel.push(objectName);
                    continue;
                }

                if (thisLineIndent == namePerLevel.size()) {
                    namePerLevel.pop();
                    namePerLevel.push(objectName);
                    continue;
                }

                int diffInLevels = namePerLevel.size() - thisLineIndent;
                for (int i = 0; i < diffInLevels; i++) {
                    namePerLevel.pop();
                }
                namePerLevel.push(objectName);
            }
        }
        return maxLength;
    }

    private static String pathToHere(Stack<String> lengthPerLevel) {
        List<String> stringList = new ArrayList<>();
        Stack<String> clone = (Stack<String>) lengthPerLevel.clone();
        do {
            stringList.add(clone.pop());
        } while (!clone.isEmpty());
        Collections.reverse(stringList); // friendly printing
        StringJoiner stringJoiner = new StringJoiner("/", "", "/"); // account for path structure
        stringList.forEach(stringJoiner::add);
        return stringJoiner.toString();
    }
}
