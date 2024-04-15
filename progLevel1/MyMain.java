package progLevel1;

public class MyMain {
    public static void main(String[] args) {
        int[] food = { 1, 7, 1, 2 };
        Solution mSol = new Solution();

        System.out.println(mSol.solution(food));
    }
}

class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for (int j = food[i] / 2; j >= 1; j--) {
                answer.append(i);
            }
        }
        StringBuilder answer2 = new StringBuilder(answer);
        answer2.reverse();
        answer.append(0);
        answer.append(answer2);
        return answer.toString();
    }
}