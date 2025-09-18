package acmicpc5640;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        char[] answer = new char[T];
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> board = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                ArrayList<Integer> oneRaw = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    oneRaw.add(Integer.parseInt(st.nextToken()));
                }
                board.add(oneRaw);
            }

            int loopCount = getMask(N);
            boolean haFlips = false;
            loop: for (int i = 1; i < loopCount; i++) {
                int[] bits = new int[N];
                for (int j = 0; j < N; j++) {
                    bits[j] = i & (1 << j);
                }

                for (int j = 0; j < M; j++) {
                    int result = 0;
                    for (Integer atom : board.get(j)) {
                        result |= bits[i];
                    }
                    System.out.println(Integer.toBinaryString(i) + " , " + j + " :" + Integer.toBinaryString(result));
                }
            }
            System.out.println(haFlips);
            if (T > 0) {
                bf.readLine();
            }
        }
        System.out.println(new String(answer));
    }

    private static int getMask(int M) {
        int mMask = 0;
        while (M > 0) {
            mMask |= 1 << M - 1;
            M--;
        }
        return mMask;
    }
}
