package acmicpc28140;

import java.io.*;
import java.util.*;

/* 빨강~ 빨강~ 파랑! 파랑! 달콤한 솜사탕!
 * https://www.acmicpc.net/problem/28140
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        char[] cArr = bf.readLine().toCharArray();
        ArrayList<Integer> r = new ArrayList<>();
        r.add(-1);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(-1);
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == 'R') {
                r.add(i);
            } else if (cArr[i] == 'B') {
                b.add(i);
            }
        }
        r.add(N);
        b.add(N);

        // System.out.println("\n" + r);
        // System.out.println(b);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int r1 = getLowerBounce(r, start);
            r1 = r.get(r1);
            if (r1 > end) {
                sb.append("-1\n");
                continue;
            }
            int r2 = getLowerBounce(r, r1 + 1);
            r2 = r.get(r2);
            if (r2 > end) {
                sb.append("-1\n");
                continue;
            }
            int b1 = getLowerBounce(b, r2 + 1);
            b1 = b.get(b1);
            if (b1 > end) {
                sb.append("-1\n");
                continue;
            }
            int b2 = getLowerBounce(b, b1 + 1);
            b2 = b.get(b2);
            if (b2 > end) {
                sb.append("-1\n");
                continue;
            }
            sb.append(r1 + " " + r2 + " " + b1 + " " + b2 + "\n");
        }
        System.out.print(sb);
    }

    static int getLowerBounce(ArrayList<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();
        while (left < right) {
            int center = (left + right) / 2;
            if (target <= arr.get(center)) {
                right = center;
            } else {
                left = center + 1;
            }
        }
        return left;
    }
}
