package acmicpc1377;

import java.io.*;
import java.util.*;

/* 버블 소트
 * https://www.acmicpc.net/problem/1377
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Num[] arr = new Num[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Num(Integer.parseInt(bf.readLine()), i);
        }
        Arrays.sort(arr, (a, b) -> a.num - b.num);

        int max = 0;
        for (int i = 0; i < N; i++) {
            //System.out.print(arr[i].num + " " + arr[i].idx + " .. " + (arr[i].idx - i) + "|");
            max = Math.max(max, arr[i].idx - i);
        }
        System.out.println(max + 1);
    }

    static class Num {
        int num;
        int idx;

        public Num(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
