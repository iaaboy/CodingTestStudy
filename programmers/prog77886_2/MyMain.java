package prog77886_2;

import java.util.Arrays;
import java.util.Stack;

public class MyMain {
    public static void main(String[] args) {
        String[] s = { "100111100", "1110", "0111111010" };
        Solution mSol = new Solution();

        System.out.println(Arrays.toString(mSol.solution(s)));
    }
}

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            // 110 뽑아내기 (개수 찾기)
            Stack<Character> mStack = new Stack<>();
            int count110 = 0;
            for (int j = 0; j < s[i].length(); j++) {
                char third = s[i].charAt(j);
                boolean is110 = false;
                if (mStack.size() >= 2) {
                    char second = mStack.pop();
                    char first = mStack.peek();
                    if (first == '1' && second == '1' && third == '0') {
                        // hit
                        count110++;
                        mStack.pop();
                        is110 = true;
                    } else {
                        mStack.add(second);
                    }
                }
                if (!is110) {
                    mStack.add(third);
                }
            }
            // debug
            System.out.println(count110);
            System.out.println(mStack);
            // 0이 있으면 가장 마지막 0 다음
            StringBuilder sb = new StringBuilder();
            while (!mStack.isEmpty()) {
                if (mStack.peek() == '0') {
                    while (count110 > 0) {
                        sb.insert(0, "110");
                        count110--;
                    }
                    sb.insert(0, mStack.pop());
                } else {
                    sb.insert(0, mStack.pop());
                }
            }
            // 0이 없으면 1앞에
            while (count110 > 0) {
                sb.insert(0, "110");
                count110--;
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}