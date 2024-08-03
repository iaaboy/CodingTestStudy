package acmicpc25955;

import java.io.*;
import java.util.*;

//풀이중
/*
 * https://www.acmicpc.net/problem/25955
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        char[] tier = { 'B', 'S', 'G', 'P', 'D' };
        int[] tierNum = { 10000, 20000, 30000, 40000, 50000 };
        int[] tierInt = new int[N];
        String[] log = new String[N];
        for (int i = 0; i < N; i++) {
            log[i] = st.nextToken();
            char[] t = log[i].toCharArray();
            for (int j = 1; j < t.length; j++) {
                tierInt[i] *= 10;
                tierInt[i] += t[j] - '0';
            }
            tierInt[i] = 1000 - tierInt[i];
            for (int j = 0; j < tier.length; j++) {
                if (t[0] == tier[j]) {
                    tierInt[i] += tierNum[j];
                }
            }
        }
        Integer [] index = new Integer[N];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> tierInt[a] - tierInt[b]);
        for (int i = 0; i < index.length; i++) {
            if (index[i] != i) {
                System.out.println("diff: " + i);
            }
        }
        //System.out.println("OK");
        System.out.println(Arrays.toString(tierInt));
    }
}
