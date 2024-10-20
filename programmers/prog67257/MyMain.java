package prog67257;

import java.util.*;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/67257
 */
public class MyMain {
    public static void main(String[] args) {
        String express = "100-200*300-500+20";

        Solution mSol = new Solution();
        System.out.println(mSol.solution(express));
    }
}

class Solution {
    LinkedList<String> numList = new LinkedList<>();
    long answer = 0;
    char[] opPrio = { '*', '+', '-' };

    public long solution(String expression) {
        String[] numbersStr = expression.split("\\+|\\-|\\*");

        int index = 0;
        for (Character c : expression.toCharArray()) {
            if (c == '-' | c == '+' | c == '*') {
                numList.add(numbersStr[index++]);
                numList.add("" + c);
            }
        }
        numList.add(numbersStr[index]);

        // System.out.println(numList);

        char[] opPrio = { '*', '+', '-' };

        makeSeq(0, opPrio);

        return answer;
    }

    void makeSeq(int depth, char[] sequence) {
        if (depth == sequence.length) {
            answer = Math.max(answer, calcExp(sequence));
            return;
        }

        for (int i = depth; i < sequence.length; i++) {
            swap(sequence, depth, i);
            makeSeq(depth + 1, sequence);
            swap(sequence, depth, i);
        }

    }

    static void swap(char[] arr, int depth, int i) {
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    long calcExp(char[] opPr) {
        LinkedList<String> localList = new LinkedList<>();
        for (String p : numList) {
            localList.add(p);
        }

        for (char op : opPr) {
            for (int i = 1; i < localList.size(); i++) {
                if (localList.get(i).charAt(0) == op) {
                    long num1 = Long.parseLong(localList.get(i - 1));
                    long num2 = Long.parseLong(localList.get(i + 1));
                    long midResult = calc(num1, num2, op);
                    localList.set(i - 1, midResult + "");
                    localList.remove(i);
                    localList.remove(i);
                    // System.out.println(localList);
                    i--;
                }
            }
        }

        // System.out.println(Arrays.toString(opPr) + "-> Result: " + localList);

        return Math.abs(Long.parseLong(localList.get(0)));
    }

    long calc(long num1, long num2, char op) {
        if (op == '*') {
            return num1 * num2;
        } else if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else {
            System.out.println("SomethingWrong");
            return -1;
        }
    }
}
