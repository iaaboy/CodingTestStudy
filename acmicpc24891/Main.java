package acmicpc24891;

import java.io.*;
import java.util.*;

/* 단어 마방진
 * https://www.acmicpc.net/problem/24891
 */

public class Main {
    static int wordLength, countOfWords;
    static char[][] words;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        wordLength = Integer.parseInt(st.nextToken()); // 단어 길이.
        countOfWords = Integer.parseInt(st.nextToken()); // 단어 개수.
        String[] wStr = new String[countOfWords];
        words = new char[countOfWords][wordLength];
        for (int i = 0; i < countOfWords; i++) {
            wStr[i] = bf.readLine();
        }
        Arrays.sort(wStr);
        for (int i = 0; i < countOfWords; i++) {
            words[i] = wStr[i].toCharArray();
        }
        int[] pick = new int[wordLength];
        boolean[] isUsed = new boolean[countOfWords];
        pick(pick, 0, isUsed);
        if (!isSuccess) {
            System.out.println("NONE");
        } else {
            // System.out.println("Mabang Success" + Arrays.toString(pick));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pick.length; i++) {
                String wrd = "";
                for (int j = 0; j < words[pick[i]].length; j++) {
                    wrd += words[pick[i]][j];
                }
                sb.append(wrd + "\n");
                // System.out.println(wrd);
            }
            System.out.print(sb);
        }
    }

    static boolean isSuccess = false;

    private static void pick(int[] pick, int depth, boolean[] isUsed) {
        // System.out.println(depth + ": " + Arrays.toString(isUsed));
        if (isSuccess) {
            return;
        }
        if (depth == wordLength) {
            // System.out.println(Arrays.toString(pick));
            if (isManbang(pick)) {
                // System.out.println("Mabang Success" + Arrays.toString(pick));
                isSuccess = true;
                return;
            }
            return;
        }
        for (int i = 0; i < countOfWords; i++) {
            if (!isUsed[i]) {
                pick[depth] = i;
                isUsed[i] = true;
                pick(pick, depth + 1, isUsed);
                if (isSuccess) {
                    break;
                }
                isUsed[i] = false;
            }
        }
    }

    private static boolean isManbang(int[] pick) {
        // pick Index는 세로
        for (int i = 1; i < wordLength; i++) {
            if (!cmpWords(i, pick)) {
                return false;
            }
        }
        return true;
    }

    private static boolean cmpWords(int center, int[] pick) {
        for (int i = center - 1; i >= 0; i--) {
            if (words[correctedIdx(center, pick)][i] != words[correctedIdx(i, pick)][center]) {
                return false;
            }
        }
        return true;
    }

    private static int correctedIdx(int i, int[] pick) {
        return pick[i];
    }
}