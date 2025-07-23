package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Set<Integer> numSet;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char [] num = bf.readLine().toCharArray();
            numSet = new HashSet<>();
            for (char n : num) {
                numSet.add(n - '0');
            }
            sb.append(numSet.size()).append("\n");
        }
        System.out.print(sb);
    }
}
