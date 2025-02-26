package aa_baseFrom;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()) + Integer.parseInt(bf.readLine());
        H += (M / 60);
        H %= 24;
        M %= 60;
        System.out.println(H + " " + M);
    }
}
