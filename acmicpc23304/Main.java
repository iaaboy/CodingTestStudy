package acmicpc23304;

import java.io.*;

/* 아카라카
 * https://www.acmicpc.net/problem/23304
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String aka = bf.readLine();

        boolean akaResult = checkAka(aka);
        System.out.println(akaResult ? "AKARAKA" : "IPSELENTI");
    }

    private static boolean checkAka(String aka) {
        char[] arr = aka.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        if (aka.length() > 1) {
            String prefix = aka.substring(0, aka.length() / 2);
            if (!checkAka(prefix))
                return false;
        }
        return true;
    }
}
