package acmicpc31423;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] names = new String[N];
        int[] head = new int[N + 1];
        int[] tail = new int[N + 1];
        for (int i = 0; i < N; i++) {
            names[i] = bf.readLine();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // set to Head
            int headIdx = to;
            while (head[headIdx] != 0) {
                headIdx = head[headIdx];
            }
            head[headIdx] = from;

            // set to Tail
            int tailIdx = from;
            while (tail[tailIdx] != 0) {
                tailIdx = tail[tailIdx];
            }
            tail[tailIdx] = to;
        }
        int startIdx = 0;
        for (int i = 0; i < N; i++) {
            if (head[i] == 0) {
                startIdx = i;
            }
        }
        // System.out.println(Arrays.toString(head));
        // System.out.println(Arrays.toString(tail));

        StringBuilder sb = new StringBuilder();
        do {
            sb.append(names[startIdx - 1]);
            startIdx = tail[startIdx];
        } while (startIdx != 0);

        System.out.println(sb);
    }
}
