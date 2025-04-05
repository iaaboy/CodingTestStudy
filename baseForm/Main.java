package baseForm;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(bf.readLine());
        String B = bf.readLine();
        char[] bStr = B.toCharArray();

        StringBuilder sb = new StringBuilder();
        int num = bStr[2] - '0';
        sb.append(A * num).append("\n");
        num = bStr[1] - '0';
        sb.append(A * num).append("\n");
        num = bStr[0] - '0';
        sb.append(A * num).append("\n");
        sb.append(A * Integer.parseInt(B));
        System.out.println(sb);

    }
}
