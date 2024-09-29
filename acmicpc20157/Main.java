package acmicpc20157;

import java.io.*;
import java.util.*;

/* 화살을 쏘자!
 * https://www.acmicpc.net/problem/20157
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<Double, Integer> Map1 = new HashMap<>();
        HashMap<Double, Integer> Map2 = new HashMap<>();
        HashMap<Double, Integer> Map3 = new HashMap<>();
        HashMap<Double, Integer> Map4 = new HashMap<>();
        Vector<HashMap<Double, Integer>> mV = new Vector<>();
        mV.add(Map1);
        mV.add(Map2);
        mV.add(Map3);
        mV.add(Map4);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            Double a = Double.parseDouble(st.nextToken());
            Double b = Double.parseDouble(st.nextToken());
            Double div = a / b;
            HashMap<Double, Integer> numMap;
            if (a > 0 && b > 0) {
                numMap = mV.get(0);
            } else if (a < 0 && b > 0) {
                numMap = mV.get(1);
            } else if (a < 0 && b < 0) {
                numMap = mV.get(2);
            } else if (a > 0 && b < 0) {
                numMap = mV.get(3);
            } else {
                numMap = mV.get(3);
            }
            if (!numMap.containsKey(div)) {
                numMap.put(div, 1);
            } else {
                numMap.put(div, numMap.get(div) + 1);
            }

        }
        int maxCount = 0;
        for (HashMap<Double, Integer> hashMap : mV) {
            for (Integer c : hashMap.values()) {
                maxCount = Math.max(maxCount, c);
            }
        }
        System.out.println(maxCount);
    }
}
