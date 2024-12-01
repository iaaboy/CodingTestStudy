package acmicpc23048;

import java.io.*;

/* 자연수 색칠하기
 * https://www.acmicpc.net/problem/23048
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 1];
        int idNum = 1;
        int cId = idNum;
        arr[1] = idNum;
        for (int i = 2; i <= N; i++) {
            if (arr[i] == 0) {
                idNum++;
                cId = idNum;
            } else {
                cId = arr[i];
            }
            int j = i;
            for (; j <= N; j += i) {
                if(arr[j] == 0)
                    arr[j] = cId;
            }
        }
        System.out.println(idNum);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
