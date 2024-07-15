package acmicpc20943;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<Double, Integer> slopes = new HashMap<>();
        int vCount = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Double a = Double.parseDouble(st.nextToken());
            Double b = Double.parseDouble(st.nextToken());
            
            Integer.parseInt(st.nextToken());
            if (b == 0) {
                vCount++;
            } else {
                double slope = - a / b;
                if (!slopes.containsKey(slope)) {
                    slopes.put(slope, 1);
                } else {
                    slopes.put(slope, slopes.get(slope) + 1);
                }
            }
        }

        long count = 0;
        count = nC2(N) - nC2(vCount);
        for (Integer c : slopes.values()) {
            count -= nC2(c);
        }

        System.out.println(count);
    }

    static long nC2(long n) {
        return (n * (n - 1)) / 2;
    }
}
