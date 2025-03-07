package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int i = 0; i <= N ; i++) {
            int n = i;
            int num = n;
            while (n > 0) {
                num += n % 10;
                n /= 10;
            }
            if (num == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
