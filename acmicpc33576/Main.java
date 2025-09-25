package acmicpc33576;

import java.io.*;
import java.util.*;

/* 자습실과 쿼리
 * https://www.acmicpc.net/problem/33576
 */

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] walls = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int index = Integer.parseInt(st.nextToken());
            int tickness = Integer.parseInt(st.nextToken());
            walls[index] = tickness;
        }

        int[] student = new int[K];
        for (int i = 0; i < K; i++) {
            int index = Integer.parseInt(bf.readLine());
            student[i] = index;
        }

        long[] sum = new long[N + 1];
        long subSum = 0;
        for (int i = 1; i <= N; i++) {
            if (walls[i] != 0) {
                subSum += walls[i];
                sum[i] = subSum;
            } else {
                sum[i] = subSum;
            }
        }

        // System.out.println(Arrays.toString(sum));

        int lLast = 0, rLast = N;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            if (student[i] > rLast || student[i] < lLast) {
                sb.append("0").append("\n");
                continue;
            }
            long sumLeft = sum[student[i]] - sum[lLast];
            long sumRight = sum[rLast] - sum[student[i]];

            if (sumLeft > sumRight) {
                rLast = student[i];
                sb.append(sumRight).append("\n");
            } else if (sumRight > sumLeft) {
                lLast = student[i];
                sb.append(sumLeft).append("\n");
            } else {
                if (student[i] <= (1 + N) / 2) {
                    lLast = student[i];
                    sb.append(sumLeft).append("\n");
                } else {
                    rLast = student[i];
                    sb.append(sumRight).append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    static class Room {
        boolean isStudent;
        int index;
        int tickness;
        int id;

        public Room(boolean isStudent, int index, int tickness, int id) {
            this.isStudent = isStudent;
            this.index = index;
            this.tickness = tickness;
            this.id = id;
        }

        public Room(boolean isStudent, int index, int tickness) {
            this.isStudent = isStudent;
            this.tickness = tickness;
            this.index = index;
        }

        @Override
        public String toString() {
            if (isStudent) {
                return "(s " + id + ", i" + index + ")";
            } else {
                return "(w " + tickness + ", i" + index + ")";
            }
        }
    }
}

/*
 * 10 3 2
 * 2 700
 * 7 200
 * 9 300
 * 5
 * 8
 * 
 * 10 5 3
 * 3 8
 * 8 4
 * 9 3
 * 1 8
 * 10 10
 * 7
 * 5
 * 2
 */