package baseForm;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bf.readLine(), 2);
        long result = N * 17;
        System.out.println(Long.toBinaryString(result));
    }
}
