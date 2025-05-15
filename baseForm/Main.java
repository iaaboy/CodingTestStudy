package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int K = Integer.parseInt(bf.readLine());
        int sum = N * M * K;
        char [] num = Integer.toString(sum).toCharArray();
        int [] count = new int[10];
        for (char num2 : num) {
            count[num2 - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int count2 : count) {
            sb.append(count2).append("\n");
        }
        System.out.print(sb); 
    }
}
