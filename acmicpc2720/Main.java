package acmicpc2720;

import java.io.*;
import java.util.*;

/* 세탁소 사장 동혁
 * https://www.acmicpc.net/problem/2720
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int quater = 25;
        int dime = 10;
        int nikel = 5;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(bf.readLine());
            sb.append(money/quater).append(" ");
            money %= quater;
            sb.append(money/dime).append(" ");
            money %= dime;
            sb.append(money/nikel).append(" ");
            money %= nikel;
            sb.append(money).append("\n");
        }
        System.out.print(sb);
    }
}
