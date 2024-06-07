package acmicpc1138;

import java.io.*;
import java.util.*;

/* 한 줄로 서기
 * https://www.acmicpc.net/problem/1138
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int j = 0;
            while (num[i] != 0) {
                if (answer[j] == 0) {
                    num[i]--;
                }
                j++;
            }
            while (answer[j] != 0)
                j++;
            answer[j] = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}
