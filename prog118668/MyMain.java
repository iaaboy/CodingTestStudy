package prog118668;

public class MyMain {
    public static void main(String[] args) {
        int[] alp = {};
        int[] cop = {};
        int[][][] problems = { 
            { { 10, 15, 2, 1, 2 }, { 20, 20, 3, 3, 4 } },
            { { 0, 0, 2, 1, 2 }, { 4, 5, 3, 1, 2 }, { 4, 11, 4, 0, 2 }, { 10, 4, 0, 4, 2 } }
        };

        Solution mSol = new Solution();

        for (int i = 0; i < 2; i++) {
            mSol.solution(alp[i], cop[i], problems[i]);
        }
    }
}

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        return answer;
    }
}