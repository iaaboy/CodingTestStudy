package aa_baseFrom;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(bf.readLine());
        char[] M = bf.readLine().toCharArray();
        int K = Integer.parseInt(bf.readLine());
        int k = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (M[i] == '0') {
                k++;
            } else {
                break;
            }
        }

        if ((k == N || k >= K)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
