package acmicpc14425;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        Set<String> set = new HashSet();
        for (int i = 0; i < N; i++) {
            set.add(bf.readLine());
        }
        for (int i = 0; i < M; i++) {
            if (set.contains(bf.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }
}
