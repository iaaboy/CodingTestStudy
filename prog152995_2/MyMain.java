package prog152995_2;

public class MyMain {
    public static void main(String[] args) {
        int[][] scores = { { 2, 2 }, { 1, 4 }, { 3, 2 }, { 3, 2 }, { 2, 1 } };
        Solution mSolution = new Solution();
        System.out.println(mSolution.solution(scores));
    }
}

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;

        // check wanho is fail
        boolean isWanhoFail = false;
        for (int i = 1; i < scores.length; i++) {
            if (scores[0][0] < scores[i][0] && scores[0][1] < scores[i][1]) {
                isWanhoFail = true;
                break;
            }
        }
        if (isWanhoFail) {
            return -1;
        }

        // wanho 등수 count
        int wanHoScore = scores[0][0] + scores[0][1];
        for (int i = 0; i < scores.length; i++) {
            if (wanHoScore < scores[i][0] + scores[i][1]) { // wanho보다 큰 경우만...
                boolean canGetBonus = true;
                for (int j = 0; j < scores.length; j++) {
                    if (scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]) {
                        canGetBonus = false;
                        break;
                    }
                }
                if (canGetBonus) {
                    answer++;
                }
            }
        }
        return answer + 1;
    }
}