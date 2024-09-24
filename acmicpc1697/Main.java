package acmicpc1697;

import java.io.*;
import java.util.*;

/* 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if (A > B || A == B) {
            System.out.println(A - B);
            return;
        }
        int gap = (B - A) / 2;
        int[] arr = new int[B + gap + 2];
        Arrays.fill(arr, Integer.MAX_VALUE);

        arr[A] = 0;
        PriorityQueue<Next> q = new PriorityQueue<>((a, b) -> a.time - b.time);
        q.add(new Next(A, 0));
        while (!q.isEmpty()) {
            Next cur = q.poll();
            if (cur.index == B) {
                break;
            }
            if (cur.index - 1 > 0 && arr[cur.index - 1] == Integer.MAX_VALUE) {
                arr[cur.index - 1] = arr[cur.index] + 1;
                q.add(new Next(cur.index - 1, arr[cur.index - 1]));
            }
            if (cur.index + 1 < arr.length - 1 && arr[cur.index + 1] == Integer.MAX_VALUE) {
                arr[cur.index + 1] = arr[cur.index] + 1;
                q.add(new Next(cur.index + 1, arr[cur.index + 1]));
            }
            if (cur.index * 2 < arr.length - 1 && arr[cur.index * 2] == Integer.MAX_VALUE) {
                arr[cur.index * 2] = arr[cur.index] + 1;
                q.add(new Next(cur.index * 2, arr[cur.index * 2]));
            }
        }
        // System.out.println(Arrays.toString(arr));
        System.out.println(arr[B]);
    }

    static class Next {
        int index;
        int time;

        public Next(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }
}
