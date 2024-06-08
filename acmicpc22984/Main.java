package acmicpc22984;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

/* 반짝반짝 2
 * https://www.acmicpc.net/problem/22984
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        BigDecimal[] num = new BigDecimal[N];
        BigDecimal ans = new BigDecimal(0);
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = new BigDecimal(st.nextToken());
            ans = ans.add(num[i]);
        }

        for (int i = 1; i < N; i++) {
            // ans += (num[i - 1] * (1 - num[i]) + (1 - num[i - 1]) * num[i]);
            BigDecimal one = new BigDecimal(1);
            BigDecimal left = num[i - 1].multiply(one.subtract(num[i]));
            BigDecimal right = (one.subtract(num[i - 1])).multiply(num[i]);
            ans = ans.add(left).add(right);
        }
        System.out.println(ans);
    }
}
