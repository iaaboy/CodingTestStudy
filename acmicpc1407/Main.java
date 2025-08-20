package acmicpc1407;

import java.io.*;
import java.util.*;

/* 2로 몇 번 나누어질까
 * https://www.acmicpc.net/problem/1407
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long count = 0;
        Vector<Long> counts = new Vector<>();
        Vector<Long> compares = new Vector<>();
        counts.add(B - A + 1);
        compares.add(B - A + 1);
        for (long i = 2; i <= B; i *= 2) {
            count = 0;
            long start = getStart(i, A);
            long end = B - (B % i);
            // for (long j = start; j <= B; j += i) {
            //     count++;
            // }
            counts.add(1 + (end - start) / i);
            // counts.add(count);
        }
        long sum = 0;
        long multi = 1;
        long curCount = 0;
        for (int i = 0; i < counts.size() - 1; i++) {
            curCount = (counts.get(i) - counts.get(i + 1));
            if (curCount != 0) {
                sum += multi * curCount;
            }
            multi *= 2;
        }
        long lastCount = counts.get(counts.size() - 1);
        if (lastCount > 0) {
            sum += multi * lastCount;
        }
        // System.out.println(counts);
        // System.out.println(compares);
        System.out.println(sum);
    }

    private static long getStart(long num, long a) {
        if (a % num == 0) {
            return a;
        } else {
            long div = a / num + 1;
            return div * num;
        }
    }
}
