package acmicpc31836;

import java.io.*;

/* 피보나치 기념품
 * https://www.acmicpc.net/problem/31836
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] pivo = new int[n];
        pivo[0] = 1;
        pivo[1] = 1;
        for (int i = 2; i < pivo.length; i++) {
            pivo[i] = pivo[i - 2] + pivo[i - 1];
        }

        int[] distributer = new int[n];
        int rest = n % 3;
        int lastItem = (distributer.length - 1) % 3;
        for (int i = distributer.length - 1; i >= rest; i--) {
            if (i % 3 == lastItem) {
                distributer[i] = 2;
            } else {
                distributer[i] = 1;
            }
        }
        if (rest == 1) {
            distributer[1] = 1;
        } else if (rest == 2) {
            distributer[0] = 1;
            distributer[1] = 2;
        }
        // System.out.println(Arrays.toString(pivo));
        // System.out.println(Arrays.toString(distributer));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int count1 = 0, count2 = 0;
        for (int i = 0; i < distributer.length; i++) {
            if (distributer[i] == 1) {
                sb1.append(i + 1 + " ");
                count1++;
            }
            if (distributer[i] == 2) {
                sb2.append(i + 1 + " ");
                count2++;
            }
        }
        sb1.insert(0, count1 + "\n");
        sb2.insert(0, count2 + "\n");
        System.out.println(sb1);
        System.out.println(sb2);
    }
}
