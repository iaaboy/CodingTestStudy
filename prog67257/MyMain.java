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
    ArrayList <Long> numbers = new ArrayList<>();
    Stack <String> expStack = new Stack<>();
    long answer = 0;
    char[] opPrio = { '*', '+', '-' };

    public long solution(String expression) {
        String[] numbersStr = expression.split("\\+|\\-|\\*");

        int index = 0;
        for (Character c : expression.toCharArray()) {
            if (c == '-' | c == '+' | c == '*') {
                expStack.add(numbersStr[index++]);
                expStack.add("" + c);
            }
        }

        System.out.println(expStack);

        char [] opPrio = { '*','+','-'};

        makeSeq(0, opPrio);

        return answer;
    }

    void makeSeq(int depth, char[] sequence) {
        if (depth == sequence.length) {
            answer = calc(sequence);
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

    long calc(char[] seq) {
        System.out.println(Arrays.toString(seq));

        // for (char idx : seq) {
            
        // }

        return -1;
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
