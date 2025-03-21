package acmicpc3986;

import java.io.*;
import java.util.*;

/* 좋은 단어
 * https://www.acmicpc.net/problem/3986
스택을 이용해서, 현재 peek과 다르면 stack에 push, 같으면 pop.
모두 처리한 뒤에 stack이 비어있는지 확인
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            char[] str = bf.readLine().toCharArray();
            if (isPerfectWord(str)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPerfectWord(char[] str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length; i++) {
            if (!s.isEmpty() && str[i] == s.peek()) {
                s.pop();
            } else {
                s.push(str[i]);
            }
        }

        return s.size() == 0;
    }
}
