package acmicpc33692;

import java.io.*;
import java.util.*;

/* 해밍 거리
 * https://www.acmicpc.net/problem/33692
ad-hoc... 하.. 답 보고 풀었음.
입력을 이진수로 바꾼뒤.
a 앞에 0을 채워두고
첫번째로 b는 1, a는 0일 자리를 찾고, 
이후 다 반대수로 바꾼다.
샘플
25 3함
[1, 1, 0, 0, 1]
[1, 1, 1, 1, 1]
 >>> 뒤에서 세번째수부터 flip된 수가 존재함
[1, 1, 0, 1, 1]
[1, 1, 1, 0, 0]
27 28
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String a = Long.toBinaryString(Long.parseLong(st.nextToken()));
        String b = Long.toBinaryString(Long.parseLong(st.nextToken()));
        a = "0".repeat(b.length() - a.length()) + a;
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int i = 0;
        for (; i < bChar.length; i++) {
            if (aChar[i] == '0' && bChar[i] == '1') {
                break;
            }
        }

        // System.out.println(Arrays.toString(aChar));
        // System.out.println(Arrays.toString(bChar) + "\n");

        for (int j = i + 1; j < bChar.length; j++) {
            aChar[j] = '1';
            bChar[j] = '0';
        }

        String flippedA = new String(aChar);
        String flippedB = new String(bChar);
        // System.out.println(Arrays.toString(aChar));
        // System.out.println(Arrays.toString(bChar));
        System.out.println(Long.parseLong(flippedA, 2) + " " + Long.parseLong(flippedB, 2));
    }
}
