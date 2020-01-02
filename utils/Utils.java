package utils;

import java.util.Arrays;

import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

public enum Utils {
    ;

    public static void printResult(int[] input, int[] expected, int[] actual) {
        boolean isSolution = Arrays.equals(expected, actual);
        System.out.println("isCorrect=" + toUpperCase(isSolution) + " - Input={" + Arrays.toString(input) + "} Expected={" + Arrays.toString(expected) + "} Actual={" + Arrays.toString(actual) + "}");
    }

    public static void printResult(int[] input, boolean expected, boolean actual) {
        boolean isSolution = expected == actual;
        System.out.println("isCorrect=" + toUpperCase(isSolution) + " - Input={" + Arrays.toString(input) + "} Expected={" + expected + "} Actual={" + actual + "}");
    }
}
