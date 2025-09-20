package BitMaskBacktracking;

import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int loopCount = (int) Math.pow(2, N);
        for (int i = 0; i < loopCount; i++) {
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }
}
