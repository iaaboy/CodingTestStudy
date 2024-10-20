package prog12942;

/* 최적의 행렬 곱셈
 * https://school.programmers.co.kr/learn/courses/30/lessons/12942
 */

public class MyMain {
    public static void main(String[] args) {
        int[][] matrix_sizes = {
                { 5, 3 }, { 3, 10 }, { 10, 6 }
        };
        Solution mSol = new Solution();

        System.out.println(mSol.solution(matrix_sizes));
    }
}

class Solution {
    int minCalc;
    int[][] matrix_sizes;
    int[][] memo;

    public int solution(int[][] matrix_sizes) {
        this.matrix_sizes = matrix_sizes;
        memo = new int[matrix_sizes.length + 1][matrix_sizes.length + 1];

        minCalc = calcMulti(0, matrix_sizes.length, 0);
        return minCalc;
    }

    private int calcMulti(int start, int end, int depth) {
        // System.out.println("calc : " + start + " , " + end + " , " + depth);
        if (end - start == 1) {
            // System.out.println("return 0");
            return 0;
        }

        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        int result = Integer.MAX_VALUE;
        // mid 중심으로 왼쪽, 오른쪽...
        for (int mid = start + 1; mid < end; mid++) {
            int l = calcMulti(start, mid, depth + 1);
            int r = calcMulti(mid, end, depth + 1);
            int current = matrix_sizes[start][0] * matrix_sizes[mid][0] * matrix_sizes[end - 1][1];
            // System.out.println("update : " + start + " , " + mid + " , " + end + " , " +
            // depth + " ,cur: " + current);
            result = Math.min(result, l + r + current);
        }
        memo[start][end] = result;
        return result;
    }

}