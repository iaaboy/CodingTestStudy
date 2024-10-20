package prog147355;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/147355
 */
public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        System.out.println("answer:" + mSol.solution("1", "1"));
    }
}

class Solution {
    public int solution(String t, String p) {
        int subCount = p.length();
        int answer = 0;
        for (int i = 0; i < t.length() - subCount + 1; i++) {
            String subStr = t.substring(i, i + subCount);
            System.out.println(subStr);
            if (Long.parseLong(subStr) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}