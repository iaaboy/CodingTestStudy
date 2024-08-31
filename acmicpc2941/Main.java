package acmicpc2941;

import java.io.*;
import java.util.Arrays;

/* 크로아티아 알파벳
 * https://www.acmicpc.net/problem/2941
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = bf.readLine().toCharArray();
        char[][] dict = {
                { 'c', '=' },
                { 'c', '-' },
                { 'd', '-' },
                { 'd', 'z', '=' },
                { 'l', 'j' },
                { 'n', 'j' },
                { 's', '=' },
                { 'z', '=' }
        };
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < dict.length; j++) {
                if (arr[i] == dict[j][0]) {
                    if (arr[i + 1] == dict[j][1]) {
                        if (j == 3) {
                            // check 4
                            if (i + 2 < arr.length && arr[i + 2] == dict[j][2]) {
                                arr[i] = '1';
                                arr[i + 1] = '0'; count++;
                                arr[i + 2] = '0'; count++;
                            }
                        } else {
                            arr[i] = '1';
                            arr[i + 1] = '0'; count++;
                        }
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(arr));
        System.out.println(arr.length - count);
    }
}
