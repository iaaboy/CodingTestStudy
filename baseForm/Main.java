package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int max = 0;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            sum += num;
        }
        Double result = (double)(100 * sum) / (double)(max * N);
        System.out.println(result);
    }
}
