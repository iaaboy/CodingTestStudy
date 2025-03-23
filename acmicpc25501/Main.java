package acmicpc25501;

import java.io.*;

/* 재귀의 귀재
 * https://www.acmicpc.net/problem/25501
 */

public class Main {
    static int recursionCnt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char[] inStr = bf.readLine().toCharArray();
            recursionCnt = 0;
            int rCount = isPalindrome(inStr);
            sb.append(rCount).append(" ").append(recursionCnt).append("\n");
        }
        System.out.print(sb);
    }

    static int recursion(char[] s, int l, int r) {
        recursionCnt++;
        if (l >= r)
            return 1;
        else if (s[l] != s[r])
            return 0;
        else
            return recursion(s, l + 1, r - 1);
    }

    static int isPalindrome(char[] s) {
        return recursion(s, 0, s.length - 1);
    }
}
