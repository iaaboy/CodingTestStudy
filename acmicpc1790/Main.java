package acmicpc1790;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Num[] numInfo = {
                new Num(1, 9, 1), // 1 - 9
                new Num(0, 99 - 10 + 1, 2), // 10 - 99
                new Num(0, 999 - 100 + 1, 3), // 100 - 999
                new Num(0, 9999 - 1000 + 1, 4), // 1000 - 9999
                new Num(0, 99999 - 10000 + 1, 5), // - 99999
                new Num(0, 999999 - 100000 + 1, 6), // - 999999
                new Num(0, 9999999 - 1000000 + 1, 7), // - 9999999
                new Num(0, 99999999 - 10000000 + 1, 8), // - 99999999
                new Num(0, 999999999 - 100000000 + 1, 9),// - 999999999
        };
        for (int i = 1; i < numInfo.length; i++) {
            numInfo[i].start = numInfo[i-1].start + numInfo[i-1].count * numInfo[i-1].digit;
        }

        for (int i = 0; i < numInfo.length; i++) {
            System.out.println(numInfo[i]);
        }

        
    }

    static class Num {
        int start;
        int count;
        int digit;

        public Num(int start, int count, int digit) {
            this.start = start;
            this.count = count;
            this.digit = digit;
        }

        @Override
        public String toString() {
            return start + "," + count + "," + digit;
        }
    }
}
