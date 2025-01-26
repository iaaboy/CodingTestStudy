package acmicpc6159;

import java.io.*;
import java.util.*;

/* Costume Party
 * https://www.acmicpc.net/problem/6159
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(arr);
        int count = 0;
        for (int l = 0; l < N; l++) {
            int r = l + 1;
            for (; r < N; r++) {
                if (arr[l] + arr[r] > S) {
                    break;
                }
            }    
            count += r - l - 1;   
        }
        System.out.println(count);
    }
}
