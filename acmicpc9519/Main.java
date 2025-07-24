package acmicpc9519;

import java.io.*;
import java.util.*;

/* 졸려
 * https://www.acmicpc.net/problem/9519
 * 문자열, adhoc
 */

public class Main {
    static int k = 0;
    static ArrayList<ArrayList<Integer>> index = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(bf.readLine());
        String oriString = bf.readLine();
        String in = new String(oriString);
        // String in2 = new String(oriString);
        for (int i = 0; i < M; i++) {
            in = switchString(in);
            // System.out.println((i+1) + "," + in);
            if (oriString.contentEquals(in)) {
                M %= (i + 1);
                // System.out.println((i+1) + " matched new M " + M);
            }
        }
        in = new String(oriString);
        for (int i = 0; i < M; i++) {
            in = switchString(in);
        }
        System.out.println(in);
    }

    private static String switchString(String in) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < in.length(); i += 2) {
            sb.append(in.charAt(i));
        }
        int i = in.length() - 1;
        if (i % 2 == 0) {
            i--;
        }
        for (; i >= 0; i -= 2) {
            sb.append(in.charAt(i));
        }
        return sb.toString();
    }
}
