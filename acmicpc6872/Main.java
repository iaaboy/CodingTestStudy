package acmicpc6872;

import java.io.*;

/* RSA Numbers
 * https://www.acmicpc.net/problem/6872
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());

        int result = 0;
        for (int i = a; i <= b; i++) {
            if (isRSA(i)) {
                result++;
            }
        }
        System.out.println("The number of RSA numbers between " + a + " and " + b + " is " + result + " ");
    }

    private static boolean isRSA(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
                if (count > 4) {
                    return false;
                }
            }
        }
        if (count == 4) {
            return true;
        }
        return false;
    }
}
