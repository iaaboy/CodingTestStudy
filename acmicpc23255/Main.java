package acmicpc23255;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        int []idIndex = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            arr[child] = parent;
        }
        for (int i = 1; i <= N; i++) {
            setUnion(i);
        }
        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            arr[i] = ++idIndex[arr[i]];
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void setUnion(int currentId) {
        int root = arr[currentId];
        while (arr[root] != root) {
            root = arr[root];
        }
        while (arr[currentId] != root) {
            int prev = currentId;
            currentId = arr[currentId];
            arr[prev] = root;
        }
    }
}
