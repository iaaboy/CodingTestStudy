package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int sum = 0;
        int A = Integer.parseInt(st.nextToken());
        sum += Math.min(N, A);
        int B = Integer.parseInt(st.nextToken());
        sum += Math.min(N, B);
        int C = Integer.parseInt(st.nextToken());
        sum += Math.min(N, C);
        System.out.println(sum);
    }
}
