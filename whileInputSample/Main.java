package whileInputSample;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = bf.readLine();
            if (line == null || line.contentEquals("")) { // line이 null 이거나, contents가 "" 일 때까지 while true.
                break;
            }
            int num = Integer.parseInt(line);
            System.out.println(num);
        }
    }
}
