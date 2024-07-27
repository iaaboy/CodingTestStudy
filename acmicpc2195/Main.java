package acmicpc2195;

import java.io.*;
import java.util.*;

/* 문자열 복사
 * https://www.acmicpc.net/problem/2195
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] ref = bf.readLine().toCharArray();
        char[] comp = bf.readLine().toCharArray();

        HashMap<Character, ArrayList<Integer>> chMap = new HashMap<>();
        for (int i = 0; i < ref.length; i++) {
            if (!chMap.containsKey(ref[i])) {
                ArrayList<Integer> idxList = new ArrayList<>();
                idxList.add(i);
                chMap.put(ref[i], idxList);
            } else {
                chMap.get(ref[i]).add(i);
            }
        }

        int fCall = 0;
        int cPointer = 0;

        while (cPointer < comp.length) {
            int maxMatch = 0;
            fCall++;
            for (Integer refIdx : chMap.get(comp[cPointer])) {
                int curMatch = 0;
                for (int i = refIdx; i < ref.length; i++) {
                    int nextPtr = cPointer + (i - refIdx);
                    if (nextPtr >= comp.length) {
                        System.out.println(fCall);
                        return;
                    }
                    if (ref[i] == comp[nextPtr]) {
                        curMatch++;
                    } else {
                        break;
                    }
                }
                maxMatch = Math.max(maxMatch, curMatch);
            }
            // System.out.println(maxMatch);
            cPointer += maxMatch;
        }
        System.out.println(fCall);
    }
}

/*
 * xy0z
 * zzz0yyy0xxx
 */