package prog12973;

import java.util.*;

/* 짝지어 제거하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
 */
public class MyMain {
    public static void main(String[] args) {
        Solution mSol = new Solution();
        mSol.solution("baabaa");
    }
}

class Solution {
    public int solution(String s) {
        Stack<Character> chStack = new Stack<>();
        for (char ch : s.toCharArray()) {
            System.out.println(chStack);
            boolean isHandled = false;
            while (!chStack.isEmpty() && ch == chStack.peek()) {
                isHandled = true;
                chStack.pop();
            }
            if (!isHandled)
                chStack.push(ch);
        }
        // System.out.println(chStack);
        return chStack.size() == 0 ? 1 : 0;
    }
}
