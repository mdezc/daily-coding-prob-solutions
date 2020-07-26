package utils.arrays;

import java.util.Arrays;

public class CustomArrayUtils {

    public static boolean[][] deepCopyBooleanArray(boolean[][]original) {
        boolean[][] copy = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }
}
