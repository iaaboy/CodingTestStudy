package acmicpc22943;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<Long> primeList = new ArrayList<Long>();
    static int[] check = new int[100001];
    static int[] check2 = new int[100001];
    static int[] visit = new int[10];
    static int k, m;
    static int ans;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[100001];

        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i * i < 100000; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= 100000; j += i)
                    prime[j] = false;
            }
        }
        for (int i = 0; i < 100000; i++) {
            if (prime[i])
                primeList.add((long) i);
        }
        for (int i = 0; i < primeList.size(); i++) {
            for (int j = i + 1; j < primeList.size(); j++) {
                if (primeList.get(i) + primeList.get(j) < 100000)
                    check[(int) (primeList.get(i) + primeList.get(j))] = 1;
            }
        }

        for (int i = 0; i < primeList.size(); i++) {
            for (int j = i; j < primeList.size(); j++) {

                if ((long) (primeList.get(i) * primeList.get(j)) < 100000)
                    check2[(int) (primeList.get(i) * primeList.get(j))] = 1;
            }
        }
        int ret = comb(0, 0, k, 0);
        bw.write(Integer.toString(ret));
        bw.flush();
    }

    static boolean check2(int val) {
        while (val % m == 0)
            val /= m;

        if (check2[val] == 1) {
            System.out.println(val);
            return true;
        }
        return false;
    }

    static int comb(int cur, int idx, int max, int val) {
        if (idx == max) {
            if (check[val] == 1 && check2(val))
                return 1;
            return 0;
        }
        int ret = 0;
        for (int i = cur; i <= 9; i++) {
            if (idx == 0 && i == 0)
                continue;
            if (visit[i] == 1)
                continue;
            visit[i] = 1;
            ret += comb(cur, idx + 1, max, val * 10 + i);
            visit[i] = 0;
        }
        return ret;
    }

}