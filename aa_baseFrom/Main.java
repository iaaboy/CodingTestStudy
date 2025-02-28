package aa_baseFrom;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(bf.readLine());
        int N = Integer.parseInt(bf.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            long price = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            sum += (price * n);
        }
        String result = sum == X ? "Yes" : "No";
        System.out.println(result);
    }
}
