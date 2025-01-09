package acmicpc2166;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        double x[] = new double[N];
        double y[] = new double[N];
        double sum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            x[i] = Double.parseDouble(st.nextToken());
            y[i] = Double.parseDouble(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            sum += x[i % N] * y[(i + 1) % N];
            sum -= x[(i + 1) % N] * y[i % N];
            // System.out.println(x[i % N] * y[(i + 1) % N] + " , - " + x[(i + 1) % N] * y[i % N]);
        }
        sum = Math.abs(sum) / 2;
        System.out.printf("%.1f\n", sum);
    }
}
