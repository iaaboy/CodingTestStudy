package prog77886;

import java.util.*;

/* 110 옮기기
 * https://school.programmers.co.kr/learn/courses/30/lessons/77886
 */

public class MyMain {
    public static void main(String[] args) {
        String[] s = { "10101001110"};
        Solution mSol = new Solution();
        System.out.println(Arrays.toString(mSol.solution(s)));
    }
}

class Solution {
    public String[] solution(String[] s) {
        char[] comparer = { '1', '1', '0' };
        Stack<Character> mQ = new Stack<>();
        int numCount = 0;
        String[] answer = new String[s.length];
        int index = 0;

        for (String ss : s) {
            mQ.clear();
            for (int i = 0; i < ss.length(); i++) {
                char third = ss.charAt(i);
                if (mQ.size() > 1) {
                    char second = mQ.pop();
                    char first = mQ.peek();
                    System.out.println(first + "," + second + "," + third);
                    if (first == comparer[0] && second == comparer[1] && third == comparer[2]) {
                        // mached
                        mQ.pop();
                        numCount++;
                        third = '9';// mean handled
                        System.out.println(mQ);
                    } else {
                        // mQ.add(second);
                        mQ.push(second);
                    }
                }
                if (third != '9') // pass already handled
                    mQ.push(third);
            }
            StringBuffer sb = new StringBuffer();
            while (!mQ.isEmpty()) {
                char ch = mQ.pop();
                if (ch == '1') {
                    sb.insert(0, ch);
                } else {
                    while (numCount > 0) {
                        sb.insert(0, "110");
                        numCount--;
                    }
                    sb.insert(0, ch);
                }
                System.out.print(ch + ",");
            }

            while (numCount > 0) {
                sb.insert(0, "110");
                numCount--;
            }
            answer[index++] = sb.toString();
            System.out.println(numCount);
            // numCount = 0;
        }
        return answer;
    }
}