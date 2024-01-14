package prog12939;

import java.util.*;

/* 최댓값과 최솟값
 * https://school.programmers.co.kr/learn/courses/30/lessons/12939
 */

public class MyMain {
    public static void main(String[] args) {
        String[] num = {
                "1 2 3 4",
                "-1 -2 -3 -4",
                "-1 -1"
        };
        Solution mSol = new Solution();

        for (String s : num) {
            System.out.println(mSol.solution(s));
        }
    }

}

class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        List<Integer> number = new ArrayList<>();
        for (String n : nums) {
            number.add(Integer.parseInt(n));
        }
        number.sort(null);
        StringBuilder answer = new StringBuilder();
        answer.append(number.get(0) + " " + number.get(number.size() - 1));
        return answer.toString();
    }
}