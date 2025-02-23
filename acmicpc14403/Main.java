package acmicpc14403;

import java.io.*;
import java.util.*;

/* 가장 긴 증가하는 부분 수열 5
 * https://www.acmicpc.net/problem/14003
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        int[] idxList = new int[N];
        int[] lenList = new int[N];
        int size = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int pos = Arrays.binarySearch(lenList, 0, size, arr[i]);
            // System.out.println(arr[i] + " : " + pos + " .. " + Arrays.toString(lenList));
            if (pos >= 0) {
                idxList[i] = Integer.MAX_VALUE; //***
                continue;
            }
            int insertPos = Math.abs(pos) - 1;
            lenList[insertPos] = arr[i];
            idxList[i] = insertPos;

            if (insertPos == size) {
                size++;
            }
        }
        // System.out.println(Arrays.toString(idxList));
        // System.out.println(Arrays.toString(lenList));
        StringBuilder sb = new StringBuilder();
        int curMax = size - 1;
        int[] result = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            if (idxList[i] == curMax) {
                result[curMax] = arr[i];
                curMax--;
                if (curMax < 0) {
                    break;
                }
            }
        }
        sb.append(size).append("\n");
        for (int i = 0; i < size; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
