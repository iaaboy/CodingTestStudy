package acmicpc25192;

import java.io.*;
import java.util.*;

/* 인사성 밝은 곰곰이
 * https://www.acmicpc.net/problem/25192
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Set<String> members = new HashSet<>();
        int emotiCount = 0;
        for (int i = 0; i < N; i++) {
            String name = bf.readLine();
            if (name.contains("ENTER")) {
                emotiCount += members.size();
                members.clear();
            } else {
                members.add(name);
            }
        }
        emotiCount += members.size();
        System.out.println(emotiCount);
    }
}
