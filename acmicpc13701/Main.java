package acmicpc13701;

import java.io.*;
import java.util.*;

/* 중복 제거
 * https://www.acmicpc.net/problem/13701
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        LinkedHashSet<Integer> mSet = new LinkedHashSet<>();
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            mSet.add(num);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : mSet) {
            sb.append(integer + " ");
        }
        System.out.println(sb);
    }
}
