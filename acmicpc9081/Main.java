package acmicpc9081;

import java.io.*;
import java.util.*;

/* 단어 맞추기
 * https://www.acmicpc.net/problem/9081
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char[] arr = bf.readLine().toCharArray();
            String str = getNextWord(arr);
            sb.append(str + "\n");
        }
        System.out.print(sb);
    }

    private static String getNextWord(char[] arr) {
        int point = -1;
        // 내림차순이 시작 찾기
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                point = i;
                break;
            }
        }
        if (point == -1) {
            return charToStr(arr);
        }
        // 내림차순 시작부터 끝까지중 point 보다 크고 가장 작은 수 찾기 switch
        char minBigger = 'Z' + 1;
        int mbIdx = -1;
        for (int i = point + 1; i < arr.length; i++) {
            char c = arr[i];
            if (c > arr[point] && c < minBigger) {
                minBigger = c;
                mbIdx = i;
            }
        }
        if (mbIdx != -1) {
            char temp = arr[point];
            arr[point] = arr[mbIdx];
            arr[mbIdx] = temp;
        }
        // 나머지를 오름차순 정렬
        char[] subChar = Arrays.copyOfRange(arr, point + 1, arr.length);
        Arrays.sort(subChar);
        for (int i = point + 1; i < arr.length; i++) {
            arr[i] = subChar[i - (point + 1)];
        }
        // System.out.println(Arrays.toString(arr));

        return charToStr(arr);
    }

    private static String charToStr(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}