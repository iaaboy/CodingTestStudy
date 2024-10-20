package prog42840;

import java.util.Arrays;

public class MyMain {
    public static void main(String[] args) {
        int[] answers = { 1, 2, 3, 4, 5 };

        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(answers)));
    }
}

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] ans1 = { 1, 2, 3, 4, 5 };
        int[] ans2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] ans3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, };

        int[] ansCnt = { 0, 0, 0 };
        for (int i = 0; i < answers.length; i++) {
            // System.out.println("a1" + ans1[i%ans1.length]);
            if (answers[i] == ans1[i % ans1.length]) {
                ansCnt[0]++;
            }
            if (answers[i] == ans2[i % ans2.length]) {
                ansCnt[1]++;
            }
            if (answers[i] == ans3[i % ans3.length]) {
                ansCnt[2]++;
            }
        }
        // System.out.println(ansCnt[0] + "-" + ansCnt[1] + "-" + ansCnt[2]);
        int mval = Math.max(Math.max(ansCnt[0], ansCnt[1]), ansCnt[2]);

        int maxCount = 0;
        for (int i = 0; i < ansCnt.length; i++) {
            if (mval == ansCnt[i]) {
                maxCount++;
                // System.out.println(ansCnt[i]);
            }
        }
        answer = new int[maxCount];
        int indexx = 0;
        for (int i = 0; i < ansCnt.length; i++) {
            if (mval == ansCnt[i]) {
                answer[indexx++] = i + 1;
            }
        }

        return answer;
    }
}