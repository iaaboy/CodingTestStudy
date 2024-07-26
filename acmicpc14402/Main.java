package acmicpc14402;

import java.io.*;
import java.util.*;

/* 야근
 * https://www.acmicpc.net/problem/14402
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        HashMap<String, Integer> record = new HashMap<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String name = st.nextToken();
            boolean inOut = st.nextToken().charAt(0) == '+'; // in true , out false
            if (inOut) { // in
                if (!record.containsKey(name)) {
                    record.put(name, 1);
                } else {
                    record.put(name, record.get(name) + 1);
                }
            } else { // out
                if (!record.containsKey(name)) {
                    count++;
                } else {
                    if (record.get(name) == 0) {
                        count++;
                    } else {
                        record.put(name, record.get(name) - 1);
                    }
                }
            }
        }
        for (Integer c : record.values()) {
            count += c;
        }
        System.out.println(count);
    }
}
