package acmicpc1978;

import java.io.*;
import java.util.StringTokenizer;

/* 소수 찾기
 * https://www.acmicpc.net/problem/1978
 */

public class Main {
	public static void main(String[] args) throws IOException {		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(bf.readLine());
		//System.out.println(M);
		int N = 1001;
		int [] arr = new int[N+1];
		for (int i = 2; i <= N; i++) { 
			arr[i] = i;
		}
		for (int i = 2; i <= N; i++) { 
			if (arr[i] == 0) {
				continue;
			}
			for (int j = i + i; j <= N; j += i) {
				arr[j] = 0;
			}
		}
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int count = 0;
		for (int i = 0; i <  M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (arr[num] != 0) {
				count++;
			}
		}
		System.out.println(count);
	}
}