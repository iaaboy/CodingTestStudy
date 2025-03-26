package baseForm;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long result = factorial(N);
        System.out.println(result);
    }

    private static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
