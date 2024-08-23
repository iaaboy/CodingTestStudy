package acmicpc2107;

import java.io.*;
import java.util.*;

/* 포함하는 구간
 * https://www.acmicpc.net/problem/2107
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Leg[] arr = new Leg[N * 2];
        for (int i = 0; i < N * 2; i += 2) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Leg(i / 2, start, end, false);
            arr[i + 1] = new Leg(i / 2, start, end, true);
        }
        Arrays.sort(arr, (a, b) -> {
            int aTimeStamp = a.isStop ? a.end : a.start;
            int bTimeStamp = b.isStop ? b.end : b.start;
            return aTimeStamp - bTimeStamp;
        });

        for (int me = 0; me < arr.length; me++) {
            if (arr[me].isStop) {
                for (int subSet = me - 1; subSet >= 0; subSet--) {
                    if (arr[subSet].id == arr[me].id) {
                        break;
                    }
                    if (!arr[subSet].isStop) {
                        if (arr[subSet].end < arr[me].end) {
                            arr[me].subSetCount++;
                        }
                    }
                }
            }
        }
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            maxCount = Math.max(maxCount, arr[i].subSetCount);
        }
        System.out.println(maxCount);
    }

    static class Leg {
        int start;
        int end;
        int id;
        int subSetCount;
        boolean isStop;

        public Leg(int id, int start, int end, boolean isStop) {
            this.id = id;
            this.start = start;
            this.end = end;
            this.isStop = isStop;
        }

        @Override
        public String toString() {
            return id + "<" + start + "," + end + "> " + isStop + "," + subSetCount;
        }
    }
}