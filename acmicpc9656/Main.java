package acmicpc9656;

import java.io.*;
import java.util.Arrays;

/* 돌 게임 2
 * https://www.acmicpc.net/problem/9656
 */

public class Main {
     public static void main(String[] args) throws NumberFormatException, IOException {
         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
         int N = Integer.parseInt(bf.readLine());
         boolean[] victory = new boolean[N + 5];
         victory[0] = false;
         victory[1] = false;
         victory[2] = true;
         victory[3] = false;
         for (int i = 4; i <= N; i++) {
             victory[i] = !(victory[i - 1] && victory[i - 3]);
         }
         System.out.println(victory[N]? "SK" : "CY");
     }
 }
 