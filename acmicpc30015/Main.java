package acmicpc30015;

import java.io.*;
import java.util.*;

/* 학생회 뽑기
 * https://www.acmicpc.net/problem/30015
 */

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Integer[] students = new Integer[N];
        boolean[] included = new boolean[N];
        Arrays.fill(included, true);
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        
        for (int i = 19; i >= 0; i--) {
            int offset = 1 << i;
            int oneCount = 0;
            for (int j = 0; j < N; j++) {
                if (included[j] && (students[j] & offset) > 0) {
                    oneCount++;
                }
            }
            if (oneCount >= K) {
                for (int j = 0; j < N; j++) {
                    if (included[j] && (students[j] & offset) == 0) {
                        included[j] = false;
                    }
                }
            }
            // System.out.println(i + "," + Arrays.toString(included));
        }

        // for (int i = 0; i < N; i++) {
        //     if (included[i]) {
        //         System.out.print(students[i] + " ");
        //     }
        // }
        // System.out.println();
        int num = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (included[i]) {
                count++;
                num &= students[i];
                if (count >= K) {
                    break;
                }
            }
        }
        System.out.println(num);
    }
}
