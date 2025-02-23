package acmicpc2661;

import java.io.*;
import java.util.*;

/* 좋은수열
 * https://www.acmicpc.net/problem/2661
 */

public class Main {
    static int[] arr;
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        goodArr(0);
    }

    private static boolean goodArr(int size) {
        if (size == N) {
            printArr(size, "final result");
            return true;
        }

        for (int i = 1; i <= 3; i++) {
            arr[size] = i;
            if (!checkHasPair(size + 1)) {
                if(goodArr(size + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkHasPair(int size) {
        if (size <= 1) {
            return false;
        }
        
        int last = size - 1;
        boolean allSame = true;
        for (int cnt = 1; cnt <= size / 2; cnt++) { // 비교 개수
            //다른게 하나라도 있으면 false
            //뒤에서부터
            allSame = true; 
            for (int i = 0; i < cnt; i++) {
                if(arr[last - i] != arr[last - i - cnt]) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                break;
            }
        }
        // printArr(size, Boolean.toString(allSame));
        return allSame;
    }

    private static void printArr(int size, String msg) {
        StringBuilder sb = new StringBuilder();
        // sb.append(msg).append(" : ");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
