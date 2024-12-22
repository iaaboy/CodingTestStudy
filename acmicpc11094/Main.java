package acmicpc11094;

import java.io.*;

/* 꿍 가라사대
 * https://www.acmicpc.net/problem/11094
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String sentence = bf.readLine();
            if (sentence.contains("Simon says")) {
                sb.append(sentence.replace("Simon says","")).append("\n");
            }          
        }
        System.out.print(sb);
    }
}
