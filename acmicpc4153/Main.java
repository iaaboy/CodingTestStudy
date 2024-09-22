package acmicpc4153;

import java.io.*;
import java.util.*;

/* 직각삼각형
 * https://www.acmicpc.net/problem/4153
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                return;
            }
            Arrays.sort(arr);
            if (arr[2] * arr[2] == (arr[0] * arr[0] + arr[1] * arr[1])) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
