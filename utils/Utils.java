package utils;

import java.util.Arrays;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public enum Utils {
    ;

    public static void printResult(int[] input, int[] expected, int[] actual) {
        boolean isCorrect = Arrays.equals(expected, actual);
        printLn(String.valueOf(isCorrect), Arrays.toString(input), Arrays.toString(expected), Arrays.toString(actual));
    }

    public static void printResult(int[] input, boolean expected, boolean actual) {
        boolean isCorrect = expected == actual;
        printLn(String.valueOf(isCorrect), Arrays.toString(input), String.valueOf(expected), String.valueOf(actual));
    }

    public static void printResult(final int input, final int expected, final int actual) {
        boolean isCorrect = expected == actual;
        printLn(String.valueOf(isCorrect), String.valueOf(input), String.valueOf(expected), String.valueOf(actual));
    }

    private static void printLn(String isCorrect, String input, String expected, String actual) {
        System.out.println("isCorrect=" + toUpperCase(isCorrect) + " - Input={" + input + "} Expected={" + expected + "} Actual={" + actual + "}");
    }
}
