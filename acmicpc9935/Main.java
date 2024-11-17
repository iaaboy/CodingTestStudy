package acmicpc9935;

import java.io.*;
import java.util.*;

/* 문자열 폭발
 * https://www.acmicpc.net/problem/9935
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = bf.readLine().toCharArray();
        char[] bomb = bf.readLine().toCharArray();
        Deque<Character> mSt = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            mSt.add(arr[i]);
            checkBomb(mSt, bomb);
        }
        if (mSt.size() == 0) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!mSt.isEmpty()) {
                sb.append(mSt.pollFirst());
            }
            System.out.println(sb);
        }
    }

    private static void checkBomb(Deque<Character> mSt, char[] bomb) {
        Iterator<Character> iter = mSt.descendingIterator();
        for (int i = 0; i < bomb.length; i++) {
            if (iter.hasNext()) {
                char ch = iter.next();
                if (bomb[bomb.length - 1 - i] != ch) {
                    return;
                }
            } else {
                return;
            }
        }
        for (int i = 0; i < bomb.length; i++) {
            mSt.pollLast();
        }
    }
}
