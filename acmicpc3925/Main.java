package acmicpc3925;

import java.util.*;
import java.io.*;

/* 암호화의 취약점 찾기
 * https://www.acmicpc.net/problem/3925
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < n; t++) {
            int idx = 0;
            long[] arr = new long[9]; // 입력 데이터 저장 배열 (8개의 값 + 검증 값)
            while (true) {
                String[] input = br.readLine().split(" ");
                for (String s : input) {
                    arr[idx++] = Long.parseLong(s, 16);
                    if (idx >= 9) {
                        break;
                    }
                }
                if (idx >= 9) {
                    break;
                }
            }

            int k = 0; // 결과로 계산될 Key 값을 저장할 변수
            for (int i = 0; i < 32; i++) {
                long sum = 0;
                for (int j = 0; j < 8; j++) {
                    sum += arr[j];
                }
                if ((sum & (1L << i)) != (arr[8] & (1L << i))) {
                    k |= (1L << i);
                    for (int j = 0; j < 8; j++) {
                        arr[j] ^= (1 << i); // XOR 연산으로 i번째 비트를 반전
                    }
                }
                
            }
            sb.append(Integer.toHexString(k)).append("\n");
        }
        System.out.print(sb);
    }
}
