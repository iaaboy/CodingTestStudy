package acmicpc27468;

import java.io.*;
import java.util.*;

/* 푸는중.
 * https://www.acmicpc.net/problem/27468V
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        permutation(arr, visited, 0);
        if (!done) {
            System.out.println("NO");
        }
    }

    static boolean done = false;

    public static void permutation(int [] resulList , boolean [] visited, int idx) {
        if(idx == resulList.length) {
            return;
        }
        for(int i = 0; i < visited.length; ++i) {
            if(visited[i]) continue;
                
            resulList[idx] = list[i];
            visited[i] = true;
            permutation(idx+1);
            visited[i] = false;
        }
    }

    private static boolean checkArr(int[] arr, int n) {
        if (n < 2) {
            return true;
        }
        int a = Math.max(arr[n - 2], arr[n - 1]) - Math.min(arr[n - 2], arr[n - 1]);
        int b = Math.max(arr[n - 1], arr[n]) - Math.min(arr[n - 1], arr[n]);
        if (a != 2 * b && a * 2 != b) {
            return false;
        }
        return true;
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
