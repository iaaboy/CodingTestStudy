package acmicpc22943;

import java.io.*;
import java.util.*;

/* 수
 * https://www.acmicpc.net/problem/22943
 * 에라토스테네스 체, 애드혹(?)
 */

public class Main {
    static int K,N;
    static boolean[] isPrime, primeMulti, primeSum;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isPrime = new boolean [100000];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                prime.add(i);
                for (int j = i + i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        ArrayDeque <Integer> nn = new ArrayDeque<>();
        makeNum(nn, 0);

        primeSum = new boolean [100000];
        primeMulti = new boolean [100000];
        for (Integer p1 : prime) {
            for (Integer p2 : prime) {
                if (p1 + p2 < 100000 && p1 != p2) {
                    primeSum[p1 + p2] = true;
                }
                long multi = (long)p1 * (long)p2;
                if (multi < 100000) {
                    primeMulti[p1 * p2] = true;
                }
            }
        }
        
        int count = 0;
        for (Integer num : numbers) {
            if (primeSum[num]) {
                // System.out.print(num);
                int numLastDiv = getDivNum(num);
                if (primeMulti[numLastDiv]) {
                    // System.out.print("*");
                    count++;
                }
                // System.out.print(" ");
            }
        }
        System.out.println(count);
    }
    private static int getDivNum(Integer num) {
        //k로 더이상 나누어 떨어지지 않는 수
        while (num % K == 0) {
            num /= K;
        }
        return num;
    }
    static int number;
    static ArrayList<Integer> prime = new ArrayList<>();
    static ArrayList < Integer> numbers = new ArrayList<>();
    private static void makeNum(ArrayDeque<Integer> nn, int depth) {
        if (depth == N) {
            number = 0;
            nn.forEach((a) -> {
                number *= 10;
                number += a;
            });
            numbers.add(number);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (depth == 0 && i == 0) {
                continue;
            }
            if (nn.contains(i)) {
                continue;
            }
            nn.addLast(i);
            makeNum(nn, depth + 1);
            nn.removeLast();
        }
    }
}
