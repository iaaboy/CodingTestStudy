package prog12952;

import java.util.Arrays;

/* N-Queen 풀이
 * https://school.programmers.co.kr/learn/courses/30/lessons/12952
 */
public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        for (int i = 4; i < 5; i++) {
            System.out.println(mSol.solution(i));
        }

    }
}

class Solution {
    int n;
    int board[][];
    int answer;

    public int solution(int n) {
        this.n = n;
        board = new int[n][n];
        answer = 0;

        dfs(0);

        return answer;
    }

    private void dfs(int depth) {
        // System.out.println(depth + "," + Arrays.toString(board));
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
//            board[depth] = i;
//
//            boolean hasNext = true;
//            for (int j = 0; j < depth; j++) {
//                if (board[depth] == board[j]) { //직선
//                    hasNext = false;
//                    break;
//                }
//                if (Math.abs(depth - j) == Math.abs(board[depth] - board[j])) { //대각선
//                    hasNext = false;
//                    break;
//                }
//            }
//
//            if (hasNext) {
//                dfs(depth + 1);
//            }
        }
    }
}