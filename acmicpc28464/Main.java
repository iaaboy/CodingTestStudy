package acmicpc28464;

import java.io.*;
import java.util.*;

/* Potato
 * https://www.acmicpc.net/problem/28464
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] patato = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            patato[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(patato);
        int idxL = N / 2;
        long lSum = 0;
        long rSum = 0;
        for (int i = 0; i < idxL; i++) {
            lSum += patato[i];
        }
        for (int i = idxL; i < N; i++) {
            rSum += patato[i];
        }
        System.out.println(lSum + " " + rSum);
    }
}
