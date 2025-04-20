package acmicpc1339;

import java.io.*;
import java.util.*;

/* 단어 수학
 * https://www.acmicpc.net/problem/1339
그리디.
알바벳 글자별로 각 자리수에 나온 것을 수로 표현.
AAB
첫번째 A : 100
두번째 A : 10
세번째 B : 1
글자별로 각 자리수에 나온수를 더해서 
우선순위 정렬 .. 결과 가장 큰 수에 9를 넣어주면 합이 최대가 됨.
결과의 알파벳을 숫자로 치환한 뒤에 , 스트링을 숫자로 변환하여 모두 더함.
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[26];
        Integer[] idx = new Integer[26];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
        int N = Integer.parseInt(bf.readLine());
        char[][] inStr = new char[N][];
        for (int i = 0; i < N; i++) {
            inStr[i] = bf.readLine().toCharArray();
            setCount(nums, inStr[i]);
        }
        Arrays.sort(idx, (a, b) -> nums[b] - nums[a]);

        // idx 1등부터 숫자 부여
        for (int i = 0; i < 10; i++) {
            setNumber(inStr, (char) ('A' + idx[i]), 9 - i);
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(new String(inStr[i]));
            result += num;
        }
        System.out.println(result);

        // for (int i = 0; i < inStr.length; i++) {
        // System.out.println(inStr[i]);
        // }
    }

    private static void setNumber(char[][] inStr, char ch, int targetNum) {
        for (int i = 0; i < inStr.length; i++) {
            for (int j = 0; j < inStr[i].length; j++) {
                if (inStr[i][j] == ch) {
                    inStr[i][j] = (char) ('0' + targetNum);
                }
            }
        }
    }

    private static void setCount(int[] nums, char[] inStr) {
        int digit = (int) Math.pow(10, inStr.length - 1);
        for (int i = 0; i < inStr.length; i++) {
            nums[inStr[i] - 'A'] += digit;
            digit /= 10;
        }
    }

}
