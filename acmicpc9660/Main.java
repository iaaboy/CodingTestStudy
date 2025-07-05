package acmicpc9660;

import java.io.*;
import java.util.*;

/* 돌 게임 6
 * https://www.acmicpc.net/problem/9660
 * 게임 이론
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bf.readLine());
        String [] dp = {"CY", "SK", "CY", "SK", "SK", "SK", "SK" };
        int idx = (int)(N % 7);
        System.out.println(dp[idx]);
    }
}
