package acmicpc10799;

import java.io.*;
import java.util.*;

/* 쇠막대기
 * https://www.acmicpc.net/problem/10799
괄호는 모두 정상적으로 닫힌다고 가정해야함.
열린 괄호 '('가 올 때 - count를 증가 .. 막대기가 하나 추가됨.
닫힌 괄호 ')'가 올 때 - 중간에 괄호가 있으면 막대기 끝부분이라고 생각하면 됨.
                - 중간에 괄호가 없고 바로 이전에 열린 괄호라면 레이저를 쏜 경우이므로, 
                이전까지 쌓인 (남은 stack size) 만큼 count + 현재 스택사이즈 해줌 .. 막대기가 잘렸다고 생각하면 됨.
count를 출력.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] str = bf.readLine().toCharArray();
        int count = 0;
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                s.push(str[i]);
                count++;
            } else { // )
                s.pop();
                if (str[i - 1] == '(') {// lazor case
                    count--;
                    count += s.size();
                }
            }
        }
        System.out.println(count);
    }
}

