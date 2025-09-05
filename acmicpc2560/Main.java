package acmicpc2560;

import java.io.*;
import java.util.*;

/* 짚신벌레 풀이
 * https://www.acmicpc.net/problem/2560
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken()); // adult
        int b = Integer.parseInt(st.nextToken()); // egg until
        int d = Integer.parseInt(st.nextToken()); // die
        int N = Integer.parseInt(st.nextToken());
        int [] egg = new int[N + 1];//알로 대기.
        int [] adult = new int[N + 1];//알 낳는 애.
        int [] prime = new int[N + 1];//그냥 사는.
        adult[0] = 1;
        adult[1] = -1;
        int nA, nB, nD;
        int adultSum = 0;
        int eggSum = 0;
        int primeSum = 0;
        for (int i = 0; i <= N; i++) {
            nA = i + a; nB = i + b; nD = i + d;
            adultSum += adult[i];
            adultSum %= 1000;
            egg[i] += adultSum;
            egg[i] %= 1000;
            if(nA <= N) {
                egg[nA] -= adultSum;
                egg[nA] %= 1000;
            }
            if(nA <= N) {
                adult[nA] += adultSum;
                adult[nA] %= 1000;
            }
            if(nB <= N) {
                adult[nB] -= adultSum;
                adult[nB] %= 1000;
            }
            if(nB <= N) {
                prime[nB] += adultSum;
                prime[nB] %= 1000;
            }
            if(nD <= N) {
                prime[nD] -= adultSum;
                prime[nD] %= 1000;
            }
            adult[i] = adultSum;
            eggSum += egg[i];
            eggSum %= 1000;
            egg[i] = eggSum;
            primeSum += prime[i];
            primeSum %= 1000;
            prime[i] = primeSum;
        }
//        System.out.println(Arrays.toString(egg));
//        System.out.println(Arrays.toString(adult));
//        System.out.println(Arrays.toString(prime));
        int result = (egg[N] + adult[N] + prime[N]) % 1000;
        if (result < 0) {
            System.out.println(1000 + result);
        } else {
            System.out.println(result);
        }
    }
}