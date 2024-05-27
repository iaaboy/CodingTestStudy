package acmicpc30412;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int [] towers = new int[N];
        for (int i = 0; i < towers.length; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i < towers.length - 1; i++) {
            
        }
    }
}
