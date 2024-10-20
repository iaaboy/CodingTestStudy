package prog1832;

/* 보행자 천국
 * dp가 아니면 시간 초과
 * https://school.programmers.co.kr/learn/courses/30/lessons/1832
 */

public class MyMain {
    public static void main(String[] args) {
        int[] m = { 3, 3 };
        int[] n = { 3, 6 };
        int[][][] cityMap = {
                { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
                { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } } };

        Solution mSol = new Solution();

        for (int i = 0; i < 2; i++)
            System.out.println(mSol.solution(m[i], n[i], cityMap[i]));
    }
}

class Solution {
    int MOD = 20170805;
    int[][] count;
    public int solution(int m, int n, int[][] cityMap) {
        count = new int[m][n];
        count[0][0] = 1;

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (cityMap[y][x] != 1) { // 0 좌회전, 우회전 가능
                    // add up
                    if (y - 1 >= 0) {
                        if (cityMap[y - 1][x] == 0) {
                            count[y][x] += count[y - 1][x];
                            count[y][x] = count[y][x] % MOD;
                        } else if (cityMap[y - 1][x] == 2) {
                            if (y - 2 >= 0) {
                                for (int curY = y - 2; curY >= 0; curY--) { // 앞에가 직진이면, 한칸 더 앞에 찾아간다
                                    if (cityMap[curY][x] != 2) {
                                        count[y][x] += count[curY][x];
                                        count[y][x] = count[y][x] % MOD;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    // add left
                    if (x - 1 >= 0) {
                        if (cityMap[y][x - 1] == 0) {
                            count[y][x] += count[y][x - 1];
                            count[y][x] = count[y][x] % MOD;
                        } else if (cityMap[y][x - 1] == 2) {
                            if (x - 2 >= 0) {
                                for (int curX = x - 2; curX >= 0; curX--) { // 앞에가 직진이면, 한칸 더 앞에 찾아간다
                                    if (cityMap[y][curX] != 2) {
                                        count[y][x] += count[y][curX];
                                        count[y][x] = count[y][x] % MOD;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return count[m - 1][n - 1];
    }
}