package acmicpc10899;

import java.io.*;
import java.util.*;

/* King of penalty
 * https://www.acmicpc.net/problem/10899
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        P--;
        int index = 0;
        long sum = 0;
        while (index < N && P >= arr[index]) {
            sum += P;
            P -= arr[index++];
        }
        System.out.println(index + " " + sum);
    }
}
