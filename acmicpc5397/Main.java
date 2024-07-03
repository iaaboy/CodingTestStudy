package acmicpc5397;

import java.io.*;
import java.util.*;

/* 키로거
 * https://www.acmicpc.net/problem/5397
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder[] sb = new StringBuilder[N];
        for (int i = 0; i < N; i++) {
            char[] cArr = bf.readLine().toCharArray();
            LinkedList<Character> word = new LinkedList<>();
            ListIterator<Character> iter = word.listIterator();
            sb[i] = new StringBuilder();
            for (int j = 0; j < cArr.length; j++) {
                switch (cArr[j]) {
                    case '>':
                        if (iter.hasNext())
                            iter.next();
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    case '<':
                        if (iter.hasPrevious())
                            iter.previous();
                        break;
                    default:
                        iter.add(cArr[j]);
                        break;
                }
            }
            iter = word.listIterator();
            while (iter.hasNext()) {
                sb[i].append(iter.next());
            }
            // System.out.println(word);
        }
        for (int i = 0; i < sb.length; i++) {
            System.out.println(sb[i]);
        }
    }
}
