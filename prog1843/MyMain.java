package prog1843;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[] nums = { "5", "-", "3", "+", "1", "+", "2", "-", "4" };

        Solution mSol = new Solution();
        System.out.println(mSol.solution(nums));
    }
}

class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        ArrayList<Integer> num = new ArrayList<Integer>();
        ArrayList<Character> op = new ArrayList<Character>();

        // 인풋을 두개 에레이로 분리
        boolean isOdd = true;
        for (String inS : arr) {
            if (isOdd) {
                num.add(Integer.parseInt(inS));
            } else {
                op.add(inS.charAt(0));
            }
            isOdd = !isOdd;
        }
        // System.out.println(num);
        // System.out.println(op);

        // 계산(함수)
        answer = calc(num, op);

        return answer;
    }

    int calc(ArrayList<Integer> num, ArrayList<Character> op) {

        int index = 0;
        int max = Integer.MIN_VALUE;
        int calcResult = 0;

        if (op.size() == 1) {
            if (op.get(0) == '+') { // +
                calcResult = num.get(0) + num.get(1);
            } else { // -
                calcResult = num.get(0) - num.get(1);
            }
            if (calcResult > max) {
                max = calcResult;
            }

            // System.out.println("max :" + max);
            return max;
        }

        for (char operator : op) {
            int tempResult = 0;
            if (operator == '+') { // +
                tempResult = num.get(index) + num.get(index + 1);
            } else { // -
                tempResult = num.get(index) - num.get(index + 1);
            }
            index++;

            // recursively calc호출
            // num 생성
            ArrayList<Integer> newNum = new ArrayList<>();
            for (Integer n : num) {
                newNum.add(n);
            }
            newNum.remove(index - 1);
            newNum.remove(index - 1);
            newNum.add(index - 1, tempResult);
            // 값 넣어주기

            // op 생성
            ArrayList<Character> newOp = new ArrayList<>();
            for (char b : op) {
                newOp.add(b);
            }
            newOp.remove(index - 1);
            // 값 넣어주기

            // System.out.println(newNum);
            // System.out.println(newOp);
            calcResult = calc(newNum, newOp);
            if (calcResult > max) {
                max = calcResult;
            }
        }

        // System.out.println("max :" + max);
        return max;
    }
}