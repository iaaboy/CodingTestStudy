package acmicpc4779;

import java.io.*;

/* 칸토어 집합
 * https://www.acmicpc.net/problem/4779
N을 3등분해서 재귀 호출한 결과를 모음.
kanto(N-1) + 스페이스를 3의 n-1승 + kanto(N-1)
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = bf.readLine()) != null && !line.isEmpty()) {
            int N = Integer.parseInt(line);
            String result = kanto(N);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    private static String kanto(int n) {
        if (n == 0) {
            return "-";
        }
        if (n == 1) {
            return "- -";
        }
        String mid = " ".repeat((int)Math.pow(3, n - 1));
        return kanto(n-1) + mid + kanto(n-1);
    }
}
