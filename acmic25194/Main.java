package acmic25194;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        boolean[] pos = new boolean[7];
        for (int i = 0; i < N; i++) {
            int work = Integer.parseInt(st.nextToken()) - 1;
            work %= 7;
            ArrayList<Integer> candi = new ArrayList<>();
            for (int j = 0; j < pos.length; j++) {
                if (pos[j]) {
                    int next = (j + 1 + work) % 7;
                    // pos[next] = true;
                    if (!pos[next]) {
                        candi.add(next);
                    }
                }
            }
            for (Integer a : candi) {
                pos[a] = true;
            }
            pos[work] = !pos[work] ? true : pos[work];
        }
        if (pos[4]) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
}
