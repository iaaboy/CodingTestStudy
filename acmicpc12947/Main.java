package acmicpc12947;

import java.io.*;
import java.util.*;

/* 트리 만들기
 * https://www.acmicpc.net/problem/12947
트리 아래에서 위로 올라가며 자식 노드가 있으면 자식 노드의 자식을 포함한 개수를 더해준다.
4 2 3 1 5라면
1111
11
111
1
11111

아래와 같이 개수 계산됨.
5311
42
311
2
11111

가장 긴 토드는 5 + 3 임.
 */



public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int arr[] = new int[N];
        int maxCount = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxCount = Math.max(maxCount, arr[i]);
        }
        int [][] sum = new int[N + 2][maxCount + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < arr[i]; j++) {
                sum[i][j] = 1;
            }   
        }

        for (int i = N - 1; i >= 0 ; i--) {
            for (int j = 0; j < arr[i]; j++) {
                if (sum[i][j] != 0) {
                    sum[i][j] = sum [i+1][j] + sum[i][j];
                }
            }
        }

        // for (int i = 0; i < N + 1; i++) {
        //     for (int j = 0; j < maxCount; j++) {
        //         System.out.print(sum[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int maxN = 0;
        for (int i = 0; i < sum.length; i++) {
            maxN = Math.max(maxN, sum[i][0] + sum[i][1]);
        }
        System.out.println(maxN);
    }

}
