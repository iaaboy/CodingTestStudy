package acmicpc1251;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] inStr = bf.readLine().toCharArray();

        int firstIdx = 0;
        for (int i = 0; i < inStr.length - 1; i++) {
            if (inStr[i] < inStr[firstIdx]) {
                firstIdx = i;
            }
        }
        int secondIdx = firstIdx == 0 ? 1 : 0;
        for (int i = 0; i < inStr.length - 1; i++) {
            if (i == firstIdx)
                continue;
            if (inStr[i] < inStr[secondIdx]) {
                secondIdx = i;
            }
        }
        int l = Math.min(firstIdx, secondIdx);
        int r = Math.max(firstIdx, secondIdx);
        System.out.println(l + "," + r);
        StringBuilder sb = new StringBuilder();
        for (int i = l; i >= 0; i--) {
            sb.append(inStr[i]);
        }
        for (int i = r; i >= l + 1; i--) {
            sb.append(inStr[i]);
        }
        for (int i = inStr.length - 1; i >= r + 1; i--) {
            sb.append(inStr[i]);
        }
        System.out.println(sb.toString());
    }
}
