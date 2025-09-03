package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                boolean result1 = (a*x + b*y == c);
                boolean result2 = (d*x + e*y == f);
                if (result1 && result2) {
                    System.out.println(x + " " + y);
                    return;
                }
            }
        }
    }
}
