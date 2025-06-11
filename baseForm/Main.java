package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            int [] arr = new int[1001];    
            for (int j = 0; j < N; j++) {
                arr[Integer.parseInt(bf.readLine())]++;
            }
            int max = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }
}
