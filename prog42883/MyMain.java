package prog42883;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String instr = "4321";
        int inNum = 1;

        Solution mSol = new Solution();
        System.out.println(mSol.solution(instr, inNum));
    }
}

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] inNumChr = number.toCharArray();
        Stack<NumData> mStack = new Stack<>();

        mStack.push(new NumData(inNumChr[0] - '0', 0));

        for (int i = 1; i < inNumChr.length; i++) {
            int inNum = inNumChr[i] - '0';
            // 지금 앞자리랑 비교
            System.out.println("stack: " + mStack);
            if (!mStack.isEmpty() && inNum > mStack.peek().num) { // 크면 삭제하고 k감소
                while (!mStack.isEmpty() && inNum > mStack.peek().num) {
                    k--;
                    System.out
                            .println("remove: " + mStack.peek().num + "idx: " + mStack.peek().idx + ", inNum" + inNum);
                    inNumChr[mStack.peek().idx] = 'x';
                    mStack.pop();
                    if (k == 0) {
                        break;
                    }
                }
            }
            if (k == 0) {
                break;
            }
            mStack.push(new NumData(inNum, i));
        }

        if (k > 0) {
            while (!mStack.isEmpty()) {
                k--;
                System.out.println("handle last remove: " + mStack.peek());
                inNumChr[mStack.peek().idx] = 'x';
                mStack.pop();
                if (k == 0) {
                    break;
                }
            }
        }
        // answer만들기
        for (int i = 0; i < inNumChr.length; i++) {
            if (inNumChr[i] != 'x')
                answer += inNumChr[i];
        }
        return answer;
    }
}

class NumData {
    int num;
    int idx;

    public NumData(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}