package acmicpc30980;

import java.io.*;
import java.util.*;

/* 여중생 파댕이와 공부를
 * https://www.acmicpc.net/problem/30980
 */

public class Main {
    static char[][] inStr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        inStr = new char[N * 3][M * 8];
        for (int i = 0; i < 3 * N; i++) {
            inStr[i] = bf.readLine().toCharArray();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N * 3; i += 3) {
            for (int j = 0; j < M * 8; j += 8) {
                String sentence = getLine(i, j);
                sentence = sentence.replace(".", "");
                String[] inputs = sentence.split("\\+|\\=");
                int a = Integer.parseInt(inputs[0]);
                int b = Integer.parseInt(inputs[1]);
                int c = Integer.parseInt(inputs[2]);
                boolean result = (a + b == c);
                // sb.append(sentence + ", " + result + "\n");
                setResult(i, j, result);

            }
        }

        for (int i = 0; i < inStr.length; i++) {
            for (int j = 0; j < inStr[i].length; j++) {
                sb.append(inStr[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void setResult(int i, int j, boolean result) {
        if (result) {
            int updateCount = 0;
            for (int k = j; k < j + 8; k++) {
                if (inStr[i][k] == '.') {
                    if (updateCount < 2)
                        inStr[i][k] = '*';
                    updateCount++;
                } else {
                    inStr[i - 1][k] = '*';
                    inStr[i + 1][k] = '*';
                }
            }
        } else {
            int index = 1;
            for (int k = i + 1; k >= i - 1; k--) {
                inStr[k][j + index++] = '/';
            }
        }
    }

    private static String getLine(int i, int j) {
        // System.out.println(i + "," + j);
        char[] rr = new char[8];
        int index = 0;
        for (int k = j; k < j + 8; k++) {
            rr[index++] = inStr[i][k];
        }
        return new String(rr);
    }
}
