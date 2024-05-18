package acmipc1049;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int line = Integer.parseInt(st.nextToken());
        int brand = Integer.parseInt(st.nextToken());

        int min6Set = Integer.MAX_VALUE;
        int min1line = Integer.MAX_VALUE;
        for (int i = 0; i < brand; i++) {
            st = new StringTokenizer(bf.readLine());
            min6Set = Math.min(min6Set, Integer.parseInt(st.nextToken()));
            min1line = Math.min(min1line, Integer.parseInt(st.nextToken()));
        }
        min6Set = Math.min(min6Set, 6 * min1line);
        int answer = (line / 6) * min6Set + Math.min(min6Set, (line % 6) * min1line);
        System.out.println(answer);
    }
}
