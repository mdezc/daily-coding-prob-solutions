package P0021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static utils.Utils.printResult;

public class P0021 {

    // Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
    //
    //For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

    public static void main(String[] args) {

        List<TimeInterval> intervalList = new ArrayList<>();
        intervalList.add(new TimeInterval(30, 75));
        intervalList.add(new TimeInterval(0, 50));
        intervalList.add(new TimeInterval(60, 150));
        int expected = 2;

        printResult(expected, solution(intervalList));
    }

    private static int solution(final List<TimeInterval> intervalList) {
        List<Integer> shiftChanges =
            intervalList.stream().flatMap(interval -> Arrays.stream(new Integer[] { interval.start, interval.end })).collect(Collectors.toList());

        int maxRooms = 0;
        for (int shift : shiftChanges) {
            int shiftRooms = 0;
            for (TimeInterval lecture : intervalList) {
                if (shift >= lecture.start && shift <= lecture.end) {
                    shiftRooms++;
                }
            }
            if (shiftRooms > maxRooms) {
                maxRooms = shiftRooms;
            }
        }
        return maxRooms;
    }

    public static class TimeInterval {
        private int start;
        private int end;

        public TimeInterval(final int start, final int end) {
            this.start = start;
            this.end = end;
        }
    }
}
