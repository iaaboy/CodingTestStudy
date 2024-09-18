package acmicpc2141;

import java.io.*;
import java.util.*;

/* 우체국
https://www.acmicpc.net/problem/2285
https://www.acmicpc.net/problem/2141
 */

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Town[] arr = new Town[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int location = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            arr[i] = new Town(location, num);
            sum += num;
        }
        Arrays.sort(arr, (a, b) -> a.location - b.location);

        long result = 0;
        for (int i = 0; i < N; i++) {
            result += arr[i].people;
            if ((sum + 1) / 2 <= result) {
                System.out.println(arr[i].location);
                break;
            }
        }
    }

    static class Town {
        int location;
        int people;

        public Town(int location, int people) {
            this.location = location;
            this.people = people;
        }
    }
}
