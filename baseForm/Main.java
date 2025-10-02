package baseForm;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int [] arr = new int[N + 1];
        int [] id = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            id[i] = i;
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        HashMap<Integer, Integer> valueKey = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (valueKey.containsKey(arr[i])) {
                id[i] = valueKey.get(arr[i]);
            } else {
                valueKey.put(i, arr[i]);
            }
        }
        int M = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) { //value switch
                int valFrom = Integer.parseInt(st.nextToken());
                int valTo = Integer.parseInt(st.nextToken());
                
            } else { //print value
                int realId = id[Integer.parseInt(st.nextToken())];
                sb.append(arr[realId]).append("\n");
            }
        }
    }
}