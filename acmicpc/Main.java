package acmicpc;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(String.format("Hello World, Judge %d!\n", i + 1));
        }
        System.out.println(sb);
    }
}
