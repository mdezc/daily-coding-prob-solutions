package P0023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import utils.arrays.CustomArrayUtils;

import static utils.Utils.printResult;

public class P0023 {

    private static final MapDirection UP = new MapDirection(0, 1, "UP");
    private static final MapDirection DOWN = new MapDirection(0, -1, "DOWN");
    private static final MapDirection LEFT = new MapDirection(-1, 0, "LEFT");
    private static final MapDirection RIGHT = new MapDirection(1, 0, "RIGHT");
    private static final MapDirection[] ALL_DIRECTIONS = { UP, DOWN, LEFT, RIGHT };

    // You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean
    // represents a tile you can walk on.
    //
    //Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end
    // coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You
    // cannot move through walls. You cannot wrap around the edges of the board.
    //
    //For example, given the following board:
    // X \ Y
    //     0  1  2  3
    // 0  [f, f, f, f],
    // 1  [T, T, f, T],
    // 2  [f, f, f, f],
    // 3  [f, f, f, f]
    //
    //and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7,
    // since we would need to go through (1, 2) because there is a wall everywhere else on the second row.

    public static void main(String[] args) {

        boolean[][] map = new boolean[][] {
                    // y =      0,     1,     2,     3
            new boolean[] { false, false, false, false }, // x = 0
            new boolean[] { true , true , false, true  }, // x = 1
            new boolean[] { false, false, false, false }, // x = 2
            new boolean[] { false, false, false, false }  // x = 3
        };

        int[] start = { 3, 0 };
        int[] end = { 0, 0 };
        printResult(7, solution(start, end, map));
    }

    private static int solution(final int[] start, final int[] end, final boolean[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[start[0]][start[1]] = true;
        List<Integer> solutions = iterateDirections(0, start, end, map, visited);
        Collections.sort(solutions);
        return solutions.get(0);
    }

    private static List<Integer> iterateDirections(final int steps, final int[] current, final int[] end, final boolean[][] map, final boolean[][] visited) {
        List<Integer> solution = new ArrayList<>();

        for (final MapDirection direction : ALL_DIRECTIONS) {
            int x = current[0];
            int y = current[1];
            if (direction.isPossible(x, y, map) && direction.notVisited(direction.leadsTo(x, y), visited)) {
                solution.addAll(goToDirection(steps, direction.leadsTo(current[0], current[1]), end, map, visited, solution));
            }
        }
        return solution;
    }

    private static List<Integer> goToDirection(final int steps, final int[] newCurrent, final int[] end, final boolean[][] map, final boolean[][] visited, final List<Integer> solution) {
        int updatedSteps = steps + 1;
        if (newCurrent[0] == end[0] && newCurrent[1] == end[1]) {
            return Collections.singletonList(updatedSteps);
        } else {
            boolean[][] updatedVisited = CustomArrayUtils.deepCopyBooleanArray(visited);
            updatedVisited[newCurrent[0]][newCurrent[1]] = true;
            return iterateDirections(updatedSteps, newCurrent, end, map, updatedVisited);
        }
    }

    private static class MapDirection {
        private final int deltaY;
        private final int deltaX;
        private final String name; // for debugging

        private MapDirection(int deltaX, int deltaY, String name) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
            this.name = name;
        }

        private boolean isPossible(int x, int y, boolean[][] map) {
            int nextX = this.deltaX + x;
            if (nextX >= 0 && nextX <= map.length -1) {
                int nextY = this.deltaY + y;
                if (nextY >= 0 && nextY <= map.length -1) {
                    return !map[nextX][nextY];
                }
            }
            return false;
        }

        private boolean notVisited(int[] leadsTo, boolean[][] visited) {
            return !visited[leadsTo[0]][leadsTo[1]];
        }

        private int[] leadsTo(int x, int y) {
            return new int[]{x + this.deltaX , y + this.deltaY};
        }
    }
}
