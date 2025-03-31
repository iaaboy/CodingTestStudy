package acmicpc16139;

import java.io.*;
import java.util.*;

/* 인간-컴퓨터 상호작용
 * https://www.acmicpc.net/problem/16139
각 알파벳별로 누적합을 저장하고,
각 쿼리를 받았을때에 
arr[char][q1 index] - arr[char][q2 index] 값을 리턴.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char [] str = bf.readLine().toCharArray();

        int [][] count = new int[26][str.length];

        for (int i = 0; i < str.length; i++) {
            int alpha = str[i] - 'a';
            count[alpha][i]++;
        }

        for (int i = 0; i < 26; i++) {
            int accumul = 0;
            for (int j = 0; j < str.length; j++) {
                accumul += count[i][j];
                count[i][j] = accumul;
            }
        }

        // for (int i = 0; i < 26; i++) {
        //     System.out.println(Arrays.toString(count[i]));
        // }


        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int ch = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int diff = 0;
            if (start == 0) {
                diff = count[ch][end];
            } else {
                diff = count[ch][end] - count[ch][start - 1];
            }
            sb.append(diff).append("\n");
        }
        System.out.print(sb);
    }
}
