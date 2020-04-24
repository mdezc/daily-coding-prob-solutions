package P0018;

import static sun.swing.MenuItemLayoutHelper.max;
import static utils.Utils.printResult;

public class P0018 {

    // Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum
    // values of each subarray of length k.
    //
    //For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
    //
    //10 = max(10, 5, 2)
    //7 = max(5, 2, 7)
    //8 = max(2, 7, 8)
    //8 = max(7, 8, 7)
    //Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to
    // store the results. You can simply print them out as you compute them.

    public static void main(String[] args) {

        int[] input1 = new int[]{10, 5, 2, 7, 8, 7};
        int[] expected1 = new int[]{10, 7, 8, 8};

        printResult(input1, expected1, solution(input1, 3));
    }

    private static int[] solution(int[] input, int lengthOfSubarray) {
        int[] output = new int[input.length - lengthOfSubarray + 1];
        int outputInserts = 0;
        int[] currentSet = new int[lengthOfSubarray];

        for (int i = 0; i < input.length; i++) {
            int iModK = i % lengthOfSubarray;
            currentSet[iModK] = input[i];
            if (i + 1 >= lengthOfSubarray) {
                output[outputInserts] = max(currentSet);
                outputInserts++;
            }
        }
        return output;
    }
}
