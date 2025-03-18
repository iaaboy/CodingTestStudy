package baseForm;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int i = 1;
        for (; i <= N; i++) {
            if (N % i == 0) {
                K--;
                if (K == 0) {
                    break;
                }
            }
        }

        if (K == 0) {
            System.out.println(i);
        } else {
            System.out.println(0);
        }

    }
}
