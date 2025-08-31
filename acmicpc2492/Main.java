package acmicpc2492;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    static HashMap<Integer, TreeSet<Integer>> valueMap = new HashMap<>();
    static HashMap<Integer, HashMap<Integer, Integer>> indexMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(bf.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            if (!valueMap.containsKey(Y)) {
                valueMap.put(Y, new TreeSet<>());
                indexMap.put(Y, new HashMap<>());
            }
            valueMap.get(Y).add(X);
        }
        for (Entry<Integer,TreeSet<Integer>> entrySet : valueMap.entrySet()) {
            int key = entrySet.getKey();
            int index = 0;
            for (Integer val : entrySet.getValue()) {
                indexMap.get(key).put(val, index++);
            }
        }
        int maxCount = 0;
        int count = 0;
        int squareCount = 0;
        for (int startY = 0; startY <= M - K; startY++) {
            for (int x = 0; x <= N - K; x++) {
                squareCount = 0;
                for (int y = startY; y <= startY + K; y++) {
                    //x(x0 ~ x3), y0, y1, y2, y3
                    count = 0;
                    if (valueMap.containsKey(y)) {
                        count = getCount(valueMap.get(y), y, x, x + K);
                        // System.out.print("(" + x + "~" + (x + K) + ","+ y + ")" + count + " , ");
                    } else {
                        // System.out.print("(" + x + "~" + (x + K)+ ","+ y + ")" + "none" + " , ");
                    }
                    squareCount += count;
                }
                // System.out.println("  ==> " + x + "," + startY + ":" + squareCount);
                maxCount = Math.max(maxCount, squareCount);
            }
        }
        System.out.println(maxCount);
    }

    static Integer lower, higher;
    static int tempCount;
    private static int getCount(TreeSet<Integer> treeSet, int key ,int from, int to) {
        lower = treeSet.ceiling(from);//크거나 같은 최소
        higher = treeSet.floor(to); //작거나 같은 최대

        tempCount = 0;

        if (lower == null || higher == null) { //낮은 원소가 없다
            tempCount = 0;
        } else
        if (lower > higher) {
            tempCount = 0;
        } else {
            tempCount = indexMap.get(key).get(higher) - indexMap.get(key).get(lower) + 1;
        }
        // System.out.println("getCount .. " + key + ": " + (from) + " ~ " + to + ":" + count + " " + treeSet);
        // System.out.println(lower + "," + higher);
        return tempCount;
    }
}
