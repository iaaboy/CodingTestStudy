package acmicpc16113;

import java.io.*;
import java.util.HashMap;

/* 시그널
 * https://www.acmicpc.net/problem/16113
 */

public class Main {
    static HashMap<String, Integer> numMap = new HashMap<>();
    static int [][] num;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        char[] inStr = bf.readLine().toCharArray();
        num = new int[5][N/5];

        numMap.put("111111000111111", 0);
        numMap.put("1111100000", 1);
        numMap.put("101111010111101", 2);
        numMap.put("101011010111111", 3);
        numMap.put("111000010011111", 4);
        numMap.put("111011010110111", 5);
        numMap.put("111111010110111", 6);
        numMap.put("100001000011111", 7);
        numMap.put("111111010111111", 8);
        numMap.put("111011010111111", 9);

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < N/5; j++) {
                num[i][j] = (inStr[i * N / 5 + j] == '#') ? 1 : 0;
            }
        }

        // for (int i = 0; i < num.length; i++) {
        //     for (int j = 0; j < num[i].length; j++) {
        //         System.out.print(num[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < num[0].length; i++) {
            if (num[0][i] == 1) {
                String numString = getNumberString(i);
                // System.out.println(numString);
                int number = 0;
                if (!numMap.containsKey(numString)) {
                    if (numString.length() <= 5) {
                       number = 1;
                    } else if (numMap.containsKey(numString.substring(0, 10))){
                        number = numMap.get(numString.substring(0, 10));
                        i+=1;
                    }
                } else {
                    number = numMap.get(numString);
                    i+=2;
                }
                answer.append(number);
            }
        }
        System.out.println(answer);
    }

    private static String getNumberString(int startI) {
        StringBuilder sb = new StringBuilder();
        int maxN = Math.min(startI + 3, num[0].length);
        for (int i = startI; i < maxN; i++) {
            for (int j = 0; j < 5; j++) {
                sb.append(num[j][i]);
            }
        }
        return sb.toString();
    }
}