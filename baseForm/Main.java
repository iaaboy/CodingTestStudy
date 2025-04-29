package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        char[] ref = bf.readLine().toCharArray();
        for (int i = 0; i < M; i++) {
            char[] inStr = bf.readLine().toCharArray();
            if (compareStr(ref, inStr)) {
                sb.append("true").append("\n");
            } else {
                sb.append("false").append("\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean compareStr(char[] ref, char[] inStr) {
        int idx = 0;
        for (int i = 0; i < inStr.length; i++) {
            if (inStr[i] == ref[idx]) {
                idx++;
                if (idx >= ref.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
