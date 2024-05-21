package acmicpc8595;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        str = bf.readLine();
        String[] numbers = str.split("[a-zA-Z]");
        long sum = 0;
        for (String num : numbers) {
            if (num.length() > 0) {
                int n = Integer.parseInt(num);
                sum += (long) n;
            }
        }
        System.out.println(sum);
    }
}