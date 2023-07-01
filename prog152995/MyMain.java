package prog152995;

public class MyMain {

    public static void main(String[] args) {
        int[][] scores = { { 2, 2 }, { 1, 4 }, { 3, 2 }, { 3, 2 }, { 2, 1 } };
        Solution mSol = new Solution();
        System.out.println(mSol.solution(scores));
    }
}

class Solution {
    public int solution(int[][] scores) {
        int whScore = scores[0][0] + scores[0][1];
        int count = 0;

        boolean amIFail = false;
        for (int i = 0; i < scores.length; i++) {
            if (scores[0][0] < scores[i][0] && scores[0][1] < scores[i][1]) {
                amIFail = true;
                break;
            }
        }
        if (amIFail) {
            return -1;
        }

        for (int me = 0; me < scores.length; me++) {
            if (whScore >= scores[me][0] + scores[me][1]) {
                continue;
            }
            boolean isCompeter = true;
            for (int i = 0; i < scores.length; i++) {
                if (scores[me][0] < scores[i][0] && scores[me][1] < scores[i][1]) {
                    isCompeter = false;
                    break;
                }
            }
            if (isCompeter) {
                count++;
            }
        }

        return count + 1;
    }
}