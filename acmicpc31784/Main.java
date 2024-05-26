package acmicpc31784;

import java.io.*;
import java.util.*;

/* 포닉스의 문단속
 * https://www.acmicpc.net/problem/31784
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] ch = bf.readLine().toCharArray();
        int curIndex = 0;
        while (K > 0) {
            if (curIndex == N - 1) {
                K %= 26;
                // 한바퀴 돌릴 있으면 , 돌리고, 남은거 더해
                if (K > 'Z' + 1 - ch[curIndex]) {
                    K -= 'Z' + 1 - ch[curIndex];
                    ch[curIndex] = 'A';
                }
                ch[curIndex] += K;
                K = 0;
                // 없으면 그냥 더해
            } else {
                int possibleCount = ch[curIndex] == 'A' ? 0 : 'Z' - ch[curIndex] + 1;
                if (possibleCount <= K) {
                    ch[curIndex] = 'A';
                    K -= possibleCount;
                    curIndex++;
                } else {
                    curIndex++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            sb.append(ch[i]);
        }
        System.out.println(sb.toString());
    }
}
