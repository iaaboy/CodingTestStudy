package acmicpc3061;

import java.io.*;
import java.util.*;

//TODO

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += findNreplace(arr, j);
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }

    private static int findNreplace(int[] arr, int num) {
        int curIdx = num;
        int targetNum = num + 1;
        for (int i = curIdx; i < arr.length; i++) {
            if (arr[i] == targetNum) {
                curIdx = i;
                break;
            }
        }

        // shiftleft
        int temp = arr[curIdx];
        int moveCount = 0;
        while (curIdx >= targetNum) {
            arr[curIdx] = arr[curIdx - 1];
            curIdx--;
            moveCount++;
        }
        arr[curIdx] = temp;
        return moveCount;
    }
}
