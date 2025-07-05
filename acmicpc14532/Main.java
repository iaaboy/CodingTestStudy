package acmicpc14532;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * 풀이중
 */

public class Main {
    static int N;
    static int[][] num, numReversed;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        num = new int[N][N];
        numReversed = new int[N][N];
        HashMap<Integer, Square> colors = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char[] nChar = bf.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                int n = nChar[j] - '0';
                num[i][j] = n;
                if (n == 0)
                    continue;
                if (!colors.containsKey(n)) {
                    colors.put(n, new Square());
                }
                Square s = colors.get(n);
                s.xMax = Math.max(s.xMax, j);
                s.xMin = Math.min(s.xMin, j);
                s.yMax = Math.max(s.yMax, i);
                s.yMin = Math.min(s.yMin, i);
            }
        }
        // System.out.println(colors);

        boolean hasMoreItem = true;
        while (hasMoreItem) {
            hasMoreItem = false;
            for (Entry<Integer, Square> entrySet : colors.entrySet()) {
                hasMoreItem = chechSquare(entrySet.getKey(), entrySet.getValue());
                if (hasMoreItem) {
                    entrySet.getValue().isHandled = true;
                    setSquare(entrySet.getKey(), entrySet.getValue());
                }
            }
        }

        // System.out.println();
        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(num[i]));
        // }

        // System.out.println();
        // for (int i = 0; i < N; i++) {
        //     System.out.println(Arrays.toString(numReversed[i]));
        // }

        int result = 0;
        for (Entry<Integer, Square> entrySet : colors.entrySet()) {
            hasMoreItem = checkReversedSquare(entrySet.getKey(), entrySet.getValue());
            if (hasMoreItem) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void setSquare(Integer number, Square sq) {
        for (int i = sq.yMin; i <= sq.yMax; i++) {
            for (int j = sq.xMin; j <= sq.xMax; j++) {
                numReversed[i][j] = number;
                num[i][j] = OVER_DRAWN;
            }
        }
    }

    static int OVER_DRAWN = 10;

    private static boolean chechSquare(Integer number, Square sq) {
        if (sq.isHandled) {
            return false;
        }
        for (int i = sq.yMin; i <= sq.yMax; i++) {
            for (int j = sq.xMin; j <= sq.xMax; j++) {
                if (num[i][j] != number && num[i][j] != OVER_DRAWN) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkReversedSquare(Integer number, Square sq) {
        for (int i = sq.yMin; i <= sq.yMax; i++) {
            for (int j = sq.xMin; j <= sq.xMax; j++) {
                if (numReversed[i][j] != number) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class Square {
        int xMax;
        int xMin = Integer.MAX_VALUE;
        int yMax;
        int yMin = Integer.MAX_VALUE;
        boolean isHandled = false;

        @Override
        public String toString() {
            return "(" + yMin + "," + xMin + " - " + yMax + "," + xMax + ")";
        }
    }
}

/*
4
1113
1113
2333
2244
*/