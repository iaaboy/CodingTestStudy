package acmicpc31963;

import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        double pre = Integer.parseInt(st.nextToken());
        long count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (pre > number) {
                double jegob = Math.ceil(Math.log10(pre / number) / Math.log10(2));
                if (jegob > 0) {
                    jegob = Math.max(jegob, 0);
                    count += jegob;
                    pre = number * Math.pow(2, jegob);
                } else {
                    pre = number;
                }
            } else {
                pre = number;
            }
            sb.append((int)pre + " ");
        }
        System.out.println(sb);
        System.out.println(count);
    }
}
