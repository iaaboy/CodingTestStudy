package prog12949;

import java.util.Arrays;

/* 행렬의 곱셈
 * https://school.programmers.co.kr/learn/courses/30/lessons/12949
 */

class Solution {
    public static int[][] solution(int[][] a, int[][] b) {
        int[][] answer = new int[a.length][b[0].length];
        for (int y = 0; y < a.length; y++) {
            for (int x = 0; x < b[0].length; x++) {
                for (int idx = 0; idx < a[0].length; idx++) {
                    answer[y][x] += a[y][idx] * b[idx][x];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][][] arr1 = {
                { { 1, 4 }, { 3, 2 }, { 4, 1 } },
                { { 2, 3, 2 }, { 4, 2, 4 }, { 3, 1, 4 } }
        };
        int[][][] arr2 = {
                { { 3, 3 }, { 3, 3 } },
                { { 5, 4, 3 }, { 2, 4, 1 }, { 3, 1, 1 } }
        };

        int[][] as = solution(arr1[1], arr2[1]);
        for (int[] a : as)
            System.out.println(Arrays.toString(a));
    }
}