package acmicpc2866;

import java.io.*;
import java.util.*;

/* 문자열 잘라내기
 * https://www.acmicpc.net/problem/2866
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] dictionary = new char[R][];
        for (int i = 0; i < R; i++) {
            dictionary[i] = br.readLine().toCharArray();
        }

        int start = 0;
        int end = R - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(dictionary, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }

    static boolean check(char[][] dictionary, int mid) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < dictionary[0].length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = mid + 1; j < dictionary.length; j++) {
                str.append(dictionary[j][i]);
            }
            if (set.contains(str.toString())) {
                return false;
            }
            set.add(str.toString());
        }
        return true;
    }
}
