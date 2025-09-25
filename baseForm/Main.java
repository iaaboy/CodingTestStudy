package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            while (N % i == 0) {
                sb.append(i + "\n");
                N /= i;
            }
        }
        System.out.print(sb);
    }
}
