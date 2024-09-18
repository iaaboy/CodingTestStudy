package acmicpc11399;

import java.io.*;
import java.util.*;
/* ATM
 * https://www.acmicpc.net/problem/11399
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long total = 0;
        long subTotal = 0;
        for (int i = 0; i < N; i++) {
            subTotal += arr[i];
            total += subTotal;
        }
        System.out.println(total);
    }
}
