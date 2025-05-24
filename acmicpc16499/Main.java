package acmicpc16499;

import java.io.*;
import java.util.*;

/* 동일한 단어 그룹화하기
 * https://www.acmicpc.net/problem/16499
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            char[] arr = bf.readLine().toCharArray();
            Arrays.sort(arr);
            set.add(new String(arr));
        }
        System.out.println(set.size());
    }
}
