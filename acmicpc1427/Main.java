package acmicpc1427;

import java.util.*;
import java.io.*;

/* 소트인사이드
 * https://www.acmicpc.net/problem/1427
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char [] arr = bf.readLine().toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
