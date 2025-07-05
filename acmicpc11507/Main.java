package acmicpc11507;

import java.io.*;
import java.util.Arrays;

/* 카드셋트
 * https://www.acmicpc.net/problem/11507
문자열.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] inStr = bf.readLine().toCharArray();
        int[] cards = new int[inStr.length / 3];
        int strIdx = 0;
        boolean hasPair = false;
        int[] leftCards = { 13, 13, 13, 13 };
        for (int i = 0; i < cards.length; i++) {
            cards[i] = inStr[strIdx] == 'P' ? 0 : inStr[strIdx] == 'K' ? 100 : inStr[strIdx] == 'H' ? 200 : 300;
            strIdx++;
            cards[i] += 10 * (inStr[strIdx++] - '0');
            cards[i] += (inStr[strIdx++] - '0');
            for (int j = 0; j < i; j++) {
                if (cards[i] == cards[j]) {
                    hasPair = true;
                }
            }
            leftCards[cards[i] / 100]--;
        }
        if (hasPair) {
            System.out.println("GRESKA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < leftCards.length; i++) {
                sb.append(leftCards[i]).append(" ");
            }
            System.out.println(sb);
        }

        // System.out.println(Arrays.toString(cards));
    }
}
