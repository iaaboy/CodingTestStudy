package acmicpc2439;

import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // N - 1 - i개 space
            for (int j = 0; j < N - 1 - i; j++) {
                sb.append(" ");
            }
            // i개 i
            for (int j = 0; j <= i; j++) {
                sb.append("*");
            }
            // \n
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
