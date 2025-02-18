package acmicpc1456;

import java.io.*;
import java.util.*;

/* 거의 소수
 * https://www.acmicpc.net/problem/1456
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int MM = (int) Math.sqrt(B) + 1;
        boolean[] prime = new boolean[MM + 1];
        for (int i = 2; i <= MM; i++) {
            for (int j = i * 2; j <= MM; j += i) {
                if (!prime[j]) {
                    prime[j] = true;
                }
            }
        }
        HashSet<Long> nearPrime = new HashSet<>();
        for (int i = 2; i <= MM; i++) {
            if (!prime[i]) {
                long num = (long) i;
                while (num <= B / (long) i) {
                    num *= (long) i;
                    if (num >= A && !nearPrime.contains(num)) {
                        nearPrime.add(num);
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(nearPrime));
        System.out.println(nearPrime.size());
    }
}
