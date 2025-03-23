package acmicpc2504;

import java.io.*;
import java.util.*;

/* 괄호의 값
 * https://www.acmicpc.net/problem/2504
열린 괄호이면 stack에 push
닫힌 괄호이면 stack pop하고, 값 계산.
값이 나왔을경우 이전에 스택된 값이 있는지 확인 있으면 더한다.
연속으로 닫힐 경우 곱한다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] str = bf.readLine().toCharArray();
        Stack<State> s = new Stack<>();
        int totalScore = 0;
        int tempScore = 0;
        for (int i = 0; i < str.length; i++) {
            // System.out.println(s);
            if (!s.empty() && !s.peek().isCh) {
                tempScore = s.pop().value;
            }
            if (str[i] == ')') {
                if (s.empty() || s.peek().value != '(') {
                    totalScore = 0;
                    break;
                } else {
                    s.pop();
                    int tempSum = 0;
                    if (!s.empty() && !s.peek().isCh) {
                        tempSum += s.pop().value;
                    }
                    if (tempScore == 0) {
                        s.push(new State(false, 2 + tempSum));
                    } else {
                        s.push(new State(false, tempScore * 2 + tempSum));
                    }

                }
            } else if (str[i] == ']') {
                if (s.empty() || s.peek().value != '[') {
                    totalScore = 0;
                    break;
                } else {
                    s.pop();
                    int tempSum = 0;
                    if (!s.empty() && !s.peek().isCh) {
                        tempSum += s.pop().value;
                    }
                    if (tempScore == 0) {
                        s.push(new State(false, 3 + tempSum));
                    } else {
                        s.push(new State(false, tempScore * 3 + tempSum));
                    }
                }
            } else {
                if (tempScore != 0) {
                    s.push(new State(false, tempScore));
                    // System.out.println(s);
                    tempScore = 0; 
                }
                s.push(new State(true, str[i]));
            }
            if (s.size() == 1 && !s.peek().isCh) {
                totalScore = s.peek().value;
            } else {
                totalScore = 0;
            }
        }
        System.out.println(totalScore);
    }

    static class State {
        boolean isCh;
        int value;

        public State(boolean isCh, int value) {
            this.isCh = isCh;
            this.value = value;
        }
        @Override
        public String toString() {
            char ch = (char)value;
            if (isCh) {
                return ch + "";
            } else {
                return value +"";
            }
        }
    }
}
