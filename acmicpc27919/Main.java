package acmicpc27919;

import java.io.*;

/* UDPC 파티
 * https://www.acmicpc.net/problem/27919
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inStr = br.readLine();
        int[] possibleCnt = new int[2];// UC , DP
        for (char c : inStr.toCharArray()) {
            switch (c) {
                case 'U':
                case 'C':
                    possibleCnt[0]++;
                    break;
                case 'P':
                case 'D':
                    possibleCnt[1]++;
                    break;
                default:
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (possibleCnt[0] > (possibleCnt[1]) / 2 + (possibleCnt[1]) % 2) {
            sb.append('U');
        }
        if (possibleCnt[1] > 0) {
            sb.append("DP");
        }
        if (sb.length() == 0) {
            sb.append("C");
        }
        System.out.println(sb.toString());
    }
}