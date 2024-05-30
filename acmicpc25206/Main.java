package acmicpc25206;

import java.io.*;
import java.util.*;

/* 너의 평점은
 * https://www.acmicpc.net/problem/25206
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Float> gMap = new HashMap<>();
        gMap.put("A+", 4.5f);
        gMap.put("A0", 4.0f);
        gMap.put("B+", 3.5f);
        gMap.put("B0", 3.0f);
        gMap.put("C+", 2.5f);
        gMap.put("C0", 2.0f);
        gMap.put("D+", 1.5f);
        gMap.put("D0", 1.0f);
        gMap.put("F", 0f);
        float total = 0;
        float count = 0;
        for (int i = 0; i < 20; i++) {
            String[] grade = bf.readLine().split(" ");
            if (gMap.containsKey(grade[2])) {
                float hakjum = Float.parseFloat(grade[1]);
                count += hakjum;
                total += hakjum * gMap.get(grade[2]);
            }
        }
        if (count == 0) {
            System.out.println(0);
        } else {
            System.out.println(total / count);
        }
    }
}
