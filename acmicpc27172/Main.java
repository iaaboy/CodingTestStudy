package acmicpc27172;

import java.io.*;
import java.util.*;

/* 수 나누기 게임
 * https://www.acmicpc.net/problem/27172
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] players = new int[N];
        int[] scores = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int maxNum = 0;
        for (int i = 0; i < N; i++) {
            players[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, players[i]);
        }
        maxNum++;
        boolean[] playerExist = new boolean[maxNum];
        int[] lostCount = new int[maxNum];
        for (int i = 0; i < players.length; i++) {
            playerExist[players[i]] = true;
        }
        for (int i = 0; i < players.length; i++) {
            int p = players[i];
            for (int j = p * 2; j < maxNum; j += p) {
                if (playerExist[j]) {
                    scores[i]++;
                    lostCount[j]++;
                }
            }
        }
        for (int i = 0; i < players.length; i++) {
            scores[i] -= lostCount[players[i]];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scores.length; i++) {
            sb.append(scores[i] + " ");
        }
        System.out.println(sb);
    }
}
