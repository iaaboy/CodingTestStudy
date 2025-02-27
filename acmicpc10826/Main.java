package acmicpc10826;

import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        String [] pivo = new String[n + 1];
        pivo[0] = "0";
        pivo[1] = "1";
        for (int i = 2; i <= n; i++) {
            pivo[i] = pivo[i - 2] + pivo[i - 1];
        }
        System.out.println(pivo[n]);
    }
    static String plus (String a, String b) {
        int aSize = a.length();
        int bSize = b.length();
        StringBuilder sb = new StringBuilder();

        int add = 0;
        int length = Math.max(a.length(), b.length());
        for (int i = 0; i < length ; i++) {
            int aNum = a.charAt(a.length() - i) - '0';
            int bNum = b.charAt(b.length() - i) - '0';
            add += (aNum + bNum);
            sb.append(add % 10);
            add /= 10;
        }


        return "";
    }
}