package prog17682;

// [1차] 다트 게임

public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        System.out.println(mSol.solution("1S2D*3T"));
    }
}

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int numberPrev = 0;
        for (int i = 0; i < dartResult.length();) {
            int number = 0;
            if (dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9') {
                if (dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
                    number = 10;
                    i += 2;
                } else {
                    number = dartResult.charAt(i) - '0';
                    i++;
                }
            }
            int bonus = 0;
            if (dartResult.charAt(i) == 'S') {
                bonus = 1;
            } else if (dartResult.charAt(i) == 'D') {
                bonus = 2;
            } else if (dartResult.charAt(i) == 'T') {
                bonus = 3;
            }
            i++;
            int option = 1;
            if (i < dartResult.length() && dartResult.charAt(i) == '*') {
                option = 2;
                i++;
                answer += numberPrev;
            } else if (i < dartResult.length() && dartResult.charAt(i) == '#') {
                option = -1;
                i++;
            }
            numberPrev = (int) (Math.pow(number, bonus) * option);
            answer += numberPrev;
        }

        return answer;
    }
}