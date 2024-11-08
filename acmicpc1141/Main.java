package acmicpc1141;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        ArrayList<String> dict = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            dict.add(bf.readLine());
        }

        dict.sort((a, b) -> a.length() - b.length());

        int result = N;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (dict.get(j).startsWith(dict.get(i))) {
                    result--;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}