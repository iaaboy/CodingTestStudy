package acmicpc1780;

import java.io.*;
import java.util.*;

/* 종이의 개수
 * https://www.acmicpc.net/problem/1780
재귀로 counting하고, 모두 숫자이면 count를 reset.
 */

public class Main {
    static int[][] square;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        square = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Count c = countSqare(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(c.minusOne).append("\n");
        sb.append(c.zero).append("\n");
        sb.append(c.one).append("\n");

        System.out.print(sb);
    }

    static int[] nums = { 0, 1, -1 };

    private static Count countSqare(int y, int x, int n) {

        if (n == 1) {
            Count curCount = new Count(
                    square[y][x] == nums[0] ? 1 : 0,
                    square[y][x] == nums[1] ? 1 : 0,
                    square[y][x] == nums[2] ? 1 : 0);
            // System.out.println(y + "," + x + ".." + n + " : " + curCount);
            return curCount;
        }

        int distance = n / 3;
        Count curCount = new Count(0, 0, 0);
        for (int i = 0; i < n; i += distance) {
            for (int j = 0; j < n; j += distance) {
                curCount.plus(countSqare(y + i, x + j, distance));
            }
        }
        curCount.reset();

        // System.out.println(y + "," + x + ".." + n + " : " + curCount);
        return curCount;
    }

    static class Count {
        int zero, one, minusOne;

        public Count(int zero, int one, int minusOne) {
            this.zero = zero;
            this.one = one;
            this.minusOne = minusOne;
        }

        public void plus(Count b) {
            this.zero += b.zero;
            this.one += b.one;
            this.minusOne += b.minusOne;
        }
        public void reset() {
            if (this.zero == 0 && this.one == 0) {
                this.minusOne = 1;
            } else if (this.minusOne == 0 && this.one == 0) {
                this.zero = 1;
            } else if (this.zero == 0 && this.minusOne == 0) {
                this.one = 1;
            }
        }

        @Override
        public String toString() {
            return "(" + zero + "," + one + "," + minusOne + ")";
        }
    }
}
