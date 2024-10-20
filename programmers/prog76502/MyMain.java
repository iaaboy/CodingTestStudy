package prog76502;

import java.util.HashMap;
import java.util.Stack;

/* 괄호 회전하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */

public class MyMain {
    public static void main(String[] args) {
        String[] ss = {
                "}]()[{",
                // "{(})",
                // "[)(]",
                // "}}}"
        };

        Solution mSol = new Solution();
        for (String s : ss)
            System.out.println(mSol.solution(s));
    }
}

class Solution {
    HashMap<Character, Integer> cMap = new HashMap<>();

    public int solution(String s) {
        int answer = 0;

        if ((s.length() % 2) != 0) {
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1, s.length()) + s.charAt(0);
            // System.out.println(s);
            answer += calc(s);
        }
        return answer;
    }

    private int calc(String s) {
        Stack<Character> mStack = new Stack<>();
        for (Character c : s.toCharArray()) {
            switch (c) {
                case '[':
                    mStack.add(c);
                    break;
                case ']':
                    if (mStack.isEmpty() || mStack.peek() != '[') {
                        return 0;
                    } else {
                        mStack.pop();
                    }
                    break;
                case '(':
                    mStack.add(c);
                    break;
                case ')':
                    if (mStack.isEmpty() || mStack.peek() != '(') {
                        return 0;
                    } else {
                        mStack.pop();
                    }
                    break;
                case '{':
                    mStack.add(c);
                    break;
                case '}':
                    if (mStack.isEmpty() || mStack.peek() != '{') {
                        return 0;
                    } else {
                        mStack.pop();
                    }
                    break;
            }
        }

        if (mStack.size() > 0) {
            return 0;
        }
        return 1;
    }
}