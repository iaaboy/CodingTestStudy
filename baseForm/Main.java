package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (N != -1) {
            ArrayList<Integer> gcs = new ArrayList<>();
            for (int i = 1; i <= N / 2; i++) {
                if (N % i == 0) {
                    gcs.add(i);
                }
            }
            long sum = 0;
            for(Integer g : gcs) {
                sum += g;
            }
            if (sum == N) {
                sb.append(N).append(" = ").append(gcs.get(0)).append(" ");
                for (int i = 1; i < gcs.size() - 1; i++) {
                    sb.append("+ ").append(gcs.get(i)).append(" ");
                }
                sb.append("+ ").append(gcs.get(gcs.size() - 1));
            } else {
                sb.append(N).append(" is NOT perfect.");
            }
            sb.append("\n");
            N = Integer.parseInt(bf.readLine());
        }
        System.out.print(sb);
    }
}
