package aa_baseFrom;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(bf.readLine());
        
        boolean [] arr = new boolean[31];

        for (int i = 0; i < 28; i++) {
            arr[Integer.parseInt(bf.readLine())] = true;            
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 30; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}
