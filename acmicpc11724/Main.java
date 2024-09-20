package acmicpc11724;

import java.io.*;
import java.util.*;

/* 연결 요소의 개수
 * https://www.acmicpc.net/problem/11724
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int gId = Math.min(getGid(arr, s), getGid(arr, e));
            setGid(arr, s, gId);
            setGid(arr, e, gId);
            // arr[s] = gId;
            // arr[e] = gId;
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == i) {
                count++;
            }
        }
        System.out.println(count);
        // System.out.println(Arrays.toString(arr));
    }
    private static void setGid(int[] arr, int s, int targetId) {
        int gid = arr[s];
        arr[s] = targetId;
        while (gid != arr[gid]) {
            int tempGid = gid;
            gid = arr[gid];
            arr[tempGid] = targetId;
        }
        arr[gid] = targetId;
    }

    private static int getGid(int[] arr, int s) {
        int gid = arr[s];
        while (gid != arr[gid]) {
            gid = arr[gid];
        }
        return gid;
    }
}
