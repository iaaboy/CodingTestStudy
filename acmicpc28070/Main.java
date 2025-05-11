package acmicpc28070;

import java.io.*;
import java.util.*;

/* 유니의 편지 쓰기
 * https://www.acmicpc.net/problem/28070
 * 자바로는 에러 @..@
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<Index> index = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String inStr = bf.readLine();
            // StringTokenizer st = new StringTokenizer(inStr, " |-");
            String y1 = inStr.substring(0,4);
            String m1 = inStr.substring(5, 7);
            String y2 = inStr.substring(8, 12);
            String m2 = inStr.substring(13, 15);
            index.add(new Index(y1, m1, false));
            index.add(new Index(y2, m2, true));
        }
        Collections.sort(index);

        // System.out.println(index);

        Index maxIdx = null;
        int maxCount = 0;
        int curCount = 0;
        for (Index idx : index) {
            if (idx.isEnd) {
                curCount--;
            } else {
                curCount++;
            }
            if (curCount > maxCount) {
                maxCount = curCount;
                maxIdx = idx;
            }
        }
        if (maxIdx == null) {
            return;
        }
        // String year = Integer.toString((maxIdx.y)) + "-";
        // String month = Integer.toString((maxIdx.m));
        // if (month.length() == 1) {
        //     month = "0" + month;
        // }
        System.out.println(maxIdx.y + "-" + maxIdx.m);
    }

    static class Index implements Comparable<Index> {
        String y, m;
        int time;
        boolean isEnd;
        public Index(String y, String m, boolean isEnd) {
            this.y = y;
            this.m = m;
            this.time = Integer.parseInt(y) * 12 + Integer.parseInt(m);
            this.isEnd = isEnd;
        }

        @Override
        public int compareTo(Index b) {
            if (this.time == b.time) {
                if (!this.isEnd) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return this.time - b.time;
            }
        }

        @Override
        public String toString() {
            return "(" + time / 12 + " " + time % 12 + "," + (isEnd? "end" : "start") + ")";
        }
    }
}

/*
4
2023-02 2023-04
2023-03 2025-03
2023-04 2025-02
2024-02 2026-02
*/