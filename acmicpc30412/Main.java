package acmicpc30412;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int addMin = Integer.MAX_VALUE;
        int add = 0;

        // left side
        int l = arr[0];
        int r = arr[1];
        if (l > r) {
            add = Math.max(r + X - l, 0);
        } else {
            add = Math.max(l + X - r, 0);
        }
        addMin = Math.min(add, addMin);

        // right side
        l = arr[arr.length - 2];
        r = arr[arr.length - 1];
        if (l > r) {
            add = Math.max(r + X - l, 0);
        } else {
            add = Math.max(l + X - r, 0);
        }
        addMin = Math.min(add, addMin);

        for (int i = 1; i < arr.length - 1; i++) {
            l = arr[i - 1];
            int c = arr[i];
            r = arr[i + 1];
            // 1 long short long
            int tempLeft = Math.max(X + c - l, 0);
            int tempRight = Math.max(X + c - r, 0);
            add = tempLeft + tempRight;
            addMin = Math.min(add, addMin);

            // 2 short Long short
            int tempLRMax = Math.max(l, r);
            add = Math.max(X + tempLRMax - c, 0);
            addMin = Math.min(add, addMin);

            // 3 short mid long
            int centerAdd = Math.max(X + r - c, 0);
            int tempCenter = c + centerAdd;
            int leftAdd = Math.max(X + tempCenter - l, 0);
            add = centerAdd + leftAdd;
            addMin = Math.min(add, addMin);

            // 4 long mid short
            centerAdd = Math.max(X + l - c, 0);
            tempCenter = c + centerAdd;
            int rightAdd = Math.max(X + tempCenter - r, 0);
            add = centerAdd + rightAdd;
            addMin = Math.min(add, addMin);
        }
        System.out.println(addMin);
    }
}