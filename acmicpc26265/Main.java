package acmicpc26265;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        if (S + K + H >= 100) {
            System.out.println("OK");
        } else if (S < K && S < H) {
            System.out.println("Soongsil");
        } else if (K < S && K < H) {
            System.out.println("Korea");
        } else if (H < S && H < K) {
            System.out.println("Hanyang");
        }

    }
}
