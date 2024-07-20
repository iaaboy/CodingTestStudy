package acmicpc14569;

import java.io.*;
import java.util.*;

/* 시간표 짜기
 * https://www.acmicpc.net/problem/14569
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        BitSet[] course = new BitSet[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            course[i] = new BitSet();
            for (int j = 0; j < n; j++) {
                course[i].set(Integer.parseInt(st.nextToken()));
            }
            course[i].flip(0, 51);
        }

        int K = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            BitSet student = new BitSet();
            int count = 0;
            for (int j = 0; j < n; j++) {
                student.set(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < N; j++) {
                BitSet studentCp = (BitSet) student.clone();
                studentCp.or(course[j]);
                studentCp.flip(0, 51);
                // System.out.println(studentCp);
                if (studentCp.isEmpty()) {
                    // System.out.println(i + " can attend " + j);
                    count++;
                }
            }
            sb.append(count + "\n");
        }
        System.out.print(sb);
    }
}
