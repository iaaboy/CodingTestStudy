package prog131702;

/* 고고학 최고의 발견
 * https://school.programmers.co.kr/learn/courses/30/lessons/131702
 */

public class MyMain {
    public static void main(String[] args) {
        // int[][] clockHands = { { 0, 3, 3, 0 }, { 3, 2, 2, 3 }, { 0, 3, 2, 0 }, { 0,
        // 3, 3, 3 } };
        int[][] clockHands = { { 0, 1, 3, 0 }, { 1, 2, 0, 0 }, { 3, 0, 2, 2 }, { 0, 2, 0, 0 } };
        Solution mSol = new Solution();
        System.out.println("Answer: " + mSol.solution(clockHands));
    }
}

class Solution {
    int n;
    int[][] clockHands;
    int[] subSet;

    public int solution(int[][] clockHands) {
        n = clockHands.length;
        this.clockHands = clockHands;
        subSet = new int[clockHands.length];

        switch1stLine(0, clockHands.length);

        return minSwitch;
    }

    private void switch1stLine(int curIndex, int length) {
        if (length == curIndex) {
            // System.out.println(Arrays.toString(subSet));
            checkTicks(subSet);
            return;
        }

        for (int i = 0; i < 4; i++) {
            subSet[curIndex] = i;
            switch1stLine(curIndex + 1, length);
        }
    }

    int minSwitch = Integer.MAX_VALUE;

    private void checkTicks(int[] subSet2) {
        int[][] clockHandsCopied = new int[n][n];
        int switchCount = 0;
        for (int k = 0; k < clockHands.length; k++)
            clockHandsCopied[k] = clockHands[k].clone();
        for (int i = 0; i < subSet2.length; i++) {
            if (subSet2[i] > 0) {
                switchHands(clockHandsCopied, 0, i, subSet2[i]);
                switchCount += subSet2[i];
            }
        }

        printRemained(clockHandsCopied);
        for (int y = 1; y < n; y++)
            for (int x = 0; x < n; x++) {
                if (clockHandsCopied[y - 1][x] > 0) {
                    switchCount += (4 - clockHandsCopied[y - 1][x]);
                    switchHands(clockHandsCopied, y, x, 4 - clockHandsCopied[y - 1][x]);
                    printRemained(clockHandsCopied);
                }
            }

        if (minSwitch > switchCount && checkAllZero(clockHandsCopied)) {
            minSwitch = switchCount;
        }
        // System.out.print(switchCount + " ");
        // System.out.print(minSwitch + " ");
        printRemained(clockHandsCopied);
    }

    private boolean checkAllZero(int[][] clockHandsCopied) {
        for (int i = 0; i < clockHandsCopied.length; i++)
            for (int k = 0; k < clockHandsCopied.length; k++) {
                if (clockHandsCopied[i][k] != 0) {
                    return false;
                }
            }
        return true;
    }

    static int tickX[] = { 0, 0, 0, -1, 1 };
    static int tickY[] = { 0, 1, -1, 0, 0 };

    void switchHands(int[][] clockHands, int fromY, int fromX, int count) {
        if (count == 0)
            return;
        for (int i = 0; i < tickX.length; i++) {
            int curX = fromX + tickX[i];
            int curY = fromY + tickY[i];

            if (curX < 0 || curX >= n || curY < 0 || curY >= n) {
                continue;
            }
            clockHands[curY][curX] = (clockHands[curY][curX] + count) % 4;
        }
    }

    private void printRemained(int[][] remained) {
        // System.out.println("========");
        // for (int i = 0; i < n; i++) {
        // for (int k = 0; k < n; k++)
        // System.out.print(remained[i][k] + ", ");
        // System.out.println();
        // }
    }
}