package acmicpc0322;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inN = Integer.parseInt(br.readLine());

        new Main().solution(inN);
    }
    public void solution(int n) { // N 출력
        System.out.println("n: " + n);
    }

}
