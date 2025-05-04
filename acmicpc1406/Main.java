package acmicpc1406;

import java.io.*;
import java.util.*;

/* 에디터
 * https://www.acmicpc.net/problem/1406
 * LinkedList 사용.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] inChar = bf.readLine().toCharArray();
        LinkedList<Character> mList = new LinkedList<>();


        int N = Integer.parseInt(bf.readLine());
        ListIterator<Character> iter = mList.listIterator();
        for (char ch : inChar) {
            iter.add(ch);
        }
        // System.out.println(mList.get(index));
        for (int i = 0; i < N; i++) {
            inChar = bf.readLine().toCharArray();
            if (inChar[0] == 'P') {
                iter.add(inChar[2]);
            } else if (inChar[0] == 'L') {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (inChar[0] == 'D') {
                if (iter.hasNext()) {
                    iter.next();    
                }
            } else if (inChar[0] == 'B') {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : mList) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
